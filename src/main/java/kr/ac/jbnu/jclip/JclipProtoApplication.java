package kr.ac.jbnu.jclip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
public class JclipProtoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JclipProtoApplication.class, args);
	}

}

