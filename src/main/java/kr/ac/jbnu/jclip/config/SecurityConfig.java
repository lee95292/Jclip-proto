package kr.ac.jbnu.jclip.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/*
 * Spring Security 참조 
 * @Authow wedul 님의
 * https://github.com/weduls/wedulpos_boot
 * */

@Configuration
@EnableWebSecurity
@EnableGlobalAuthentication
@ComponentScan(basePackages = {"kr.ac.jbnu.jclip"})
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private AuthFailureHandler authFailureHandler;
	
	@Autowired
	private AuthSuccessHandler authSuccessHadnler;
	
	@Autowired
	private AuthenticationProvider authProvider;
	
	@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
			//login페이지_파라미터_핸들러(성공,실패) 설정
			.formLogin()
			.loginPage("/")
			.loginProcessingUrl("/do_login")
//			.failureHandler()
			.defaultSuccessUrl("/")
			.usernameParameter("id")
			.passwordParameter("password")
			.failureHandler(authFailureHandler)
			.successHandler(authSuccessHadnler)
		.and()
			//logout 관련 설정 
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
			.logoutSuccessUrl("/")
			.invalidateHttpSession(true)
//		.and()
//			.csrf()
		.and()
			.authenticationProvider(authProvider);
			
		}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		super.configure(web);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
