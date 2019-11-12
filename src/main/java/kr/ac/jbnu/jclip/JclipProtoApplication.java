package kr.ac.jbnu.jclip;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
public class JclipProtoApplication {
	private static final String APPLICATION=
											"spring.config.location="+
											"classpath:/application.yml,"+
											"classpath:/private.yml";

	public static void main(String[] args) {
		new SpringApplicationBuilder(JclipProtoApplication.class).properties(APPLICATION).run(args);
		
//		SpringApplication.run(JclipProtoApplication.class, args);
	}
	


}

