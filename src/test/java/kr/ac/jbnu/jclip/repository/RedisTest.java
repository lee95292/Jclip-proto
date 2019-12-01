package kr.ac.jbnu.jclip.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.jbnu.jclip.model.redis.JwtCache;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class RedisTest {

    @Autowired
    JwtRedisRepository jwtRedisRepository;

    @Test
    public void test() {
        JwtCache jwtCache = new JwtCache("test@jbnu.ac.kr", 12345L);
        jwtRedisRepository.save(jwtCache);

        JwtCache result = jwtRedisRepository.findById("test@jbnu.ac.kr").get();
        long iat = result.getIat();
        assertEquals(12345L, iat);
    }

}
