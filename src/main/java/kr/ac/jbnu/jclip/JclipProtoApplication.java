package kr.ac.jbnu.jclip;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableScheduling
public class JclipProtoApplication {
	private static final String APPLICATION = "spring.config.location=" + "classpath:/application.yml,"
			+ "classpath:/private.yml";

	public static void main(String[] args) {
		System.setProperty("spring.profiles.active", "dev"); // 목적에 따라 주석 처리 가능함.
		new SpringApplicationBuilder(JclipProtoApplication.class).properties(APPLICATION).run(args);

		// SpringApplication.run(JclipProtoApplication.class, args);
	}

}
