package kr.ac.jbnu.jclip.config.redis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.util.StringUtils;

import redis.embedded.RedisServer;

@Profile("real")
@Configuration
public class EmbeddedRedisConfig {

    @Value("${spring.redis.port}")
    private int redisPort;

    private RedisServer redisServer;

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory("localhost", findAvailablePort());
    }

    @PostConstruct
    public void redisServer() throws IOException {
        redisPort = findAvailablePort();
        redisServer = new RedisServer(redisPort);
        redisServer.start();
    }

    @PreDestroy
    public void stopRedis() {
        if (redisServer != null) {
            redisServer.stop();
        }
    }

    /**
     * 현재 PC/서버에서 사용가능한 포트 조회
     */
    public int findAvailablePort() {

        for (int port = 10000; port <= 65535; port++) {

            if (!availablePort(port)) {
                System.out.println("lcc3108" + port);
                return port;
            }
        }
        return 0;
    }

    public boolean availablePort(int port) {
        boolean result = false;

        try {
            (new Socket("127.0.0.1", port)).close();

            result = true;
        } catch (Exception e) {

        }
        return result;
    }

}