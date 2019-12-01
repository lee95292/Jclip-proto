package kr.ac.jbnu.jclip.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.jbnu.jclip.model.redis.JwtCache;

@ComponentScan(basePackages = { "kr.ac.jbnu.jclip" })
@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class RedisTest {

    @Autowired
    @Qualifier(value = "JwtRedisRepository")
    JwtRedisRepository jwtRedisRepository;

    @Test
    public void test() {
        JwtCache jwtCache = new JwtCache("test@jbnu.ac.kr", "12345");
        JwtCache jwtCache2 = new JwtCache("test@jbnu.ac.kr", "123456");

        jwtRedisRepository.save(jwtCache);
        jwtRedisRepository.save(jwtCache2);

        JwtCache result = jwtRedisRepository.findById("test@jbnu.ac.kr").get();
        String iat = result.getIat();
        assertEquals("12345", iat);
    }

}
