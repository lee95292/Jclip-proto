package kr.ac.jbnu.jclip.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.AntPathMatcher;

//@Log
//@Configuration
//@EnableWebSecurity
//@EnableGlobalAuthentication
@ComponentScan("kr.ac.jbnu.jclip")
public class SecurityConfig extends WebSecurityConfigurerAdapter{
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
			.and()
			//logout 관련 설정 )
			.logout()
			.logoutRequestMatcher((RequestMatcher) new AntPathMatcher("/user/logout"))
			.logoutSuccessUrl("/")
			.invalidateHttpSession(true);
		}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		super.configure(web);
	}
	
}
