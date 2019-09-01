package kr.ac.jbnu.jclip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class JclipProtoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JclipProtoApplication.class, args);
	}

}
