package kr.ac.jbnu.jclip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
public class JclipProtoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JclipProtoApplication.class, args);
	}
	


}

