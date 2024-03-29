package kr.ac.jbnu.jclip.config.auth;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;

import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CompositeFilter;

import kr.ac.jbnu.jclip.config.auth.jwt.JwtAuthenticationFilter;
import kr.ac.jbnu.jclip.config.auth.jwt.JwtAuthenticationManager;
import kr.ac.jbnu.jclip.config.auth.jwt.JwtUtil;
import kr.ac.jbnu.jclip.service.user.RedisService;
import kr.ac.jbnu.jclip.social.SocialService;
import kr.ac.jbnu.jclip.social.google.GoogleOAuth2ClientAuthenticationProcessingFilter;
import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
@EnableOAuth2Client
@EnableWebSecurity
@ComponentScan(basePackages = { "kr.ac.jbnu.jclip" })
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final OAuth2ClientContext oauth2ClientContext;
	private final SocialService socialService;
	private final RedisService redisService;
	private final JwtUtil jwtUtil;
	private final JwtAuthenticationManager jwtAuthenticationManager;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.csrf().disable();

		// TODO - 인증권한 모두 풀려있음.
		http.authorizeRequests().antMatchers("/static/**", "/", "/token", "/article", "/bind", "/keyword", "/user/**")
				.permitAll().requestMatchers(CorsUtils::isPreFlightRequest).permitAll().and().authorizeRequests()
				.antMatchers("/servie/**").authenticated().and()
				.addFilterBefore(jwtAuthenticationFilter(), BasicAuthenticationFilter.class);

		http.antMatcher("/**").authorizeRequests().antMatchers("/", "/login**").permitAll().anyRequest().authenticated()
				.and().exceptionHandling()
				// Spring Security의 자체 로그인 success/fail redirection 방지
				.and().addFilterBefore(ssoFilter(), UsernamePasswordAuthenticationFilter.class);

		http.logout().invalidateHttpSession(true).clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/").permitAll();

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		super.configure(web);
	}

	private Filter ssoFilter() {
		CompositeFilter filter = new CompositeFilter();
		List<Filter> filters = new ArrayList<>();
		filters.add(ssoFilter(google(),
				new GoogleOAuth2ClientAuthenticationProcessingFilter(socialService, jwtUtil, redisService)));
		filter.setFilters(filters);
		return filter;
	}

	private Filter ssoFilter(ClientResource client, OAuth2ClientAuthenticationProcessingFilter filter) {
		OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(client.getClient(), oauth2ClientContext);
		filter.setRestTemplate(restTemplate);
		UserInfoTokenServices tokenServices = new UserInfoTokenServices(client.getResource().getUserInfoUri(),
				client.getClient().getClientId());
		filter.setTokenServices(tokenServices);
		tokenServices.setRestTemplate(restTemplate);
		return filter;
	}

	/*
	 * OAuth Beans
	 */

	@Bean
	@ConfigurationProperties("google")
	public ClientResource google() {
		return new ClientResource();
	}

	@Bean
	public FilterRegistrationBean<Filter> oauth2ClientFilterRegistration(OAuth2ClientContextFilter filter) {
		FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<Filter>();
		registration.setFilter(filter);
		registration.setOrder(-100);
		return registration;
	}

	@Bean
	public Filter jwtAuthenticationFilter() {
		JwtAuthenticationFilter filter = new JwtAuthenticationFilter(jwtUtil);
		filter.setAuthenticationManager(jwtAuthenticationManager);
		// We do not need to do anything extra on REST authentication success, because
		// there is no page to redirect to
		filter.setAuthenticationSuccessHandler((request, response, authentication) -> {
		});

		return filter;
	}

	// cors
	@Bean
	public CorsConfigurationSource corsConfiguration() {
		CorsConfiguration configuration = new CorsConfiguration();
		// - (3)
		configuration.addAllowedOrigin("*");
		configuration.addAllowedMethod("*");
		configuration.addAllowedHeader("*");
		configuration.setAllowCredentials(true);
		configuration.setMaxAge(3600L);
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

}
