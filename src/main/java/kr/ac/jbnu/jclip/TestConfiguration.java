package kr.ac.jbnu.jclip;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan("kr.ac.jbnu.jclip.model")
@EnableJpaRepositories("kr.ac.jbnu.jclip.repository")
@EnableTransactionManagement
public class TestConfiguration {

}
