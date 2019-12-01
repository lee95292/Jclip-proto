package kr.ac.jbnu.jclip.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.jbnu.jclip.config.auth.jwt.JwtUtil;
import kr.ac.jbnu.jclip.model.redis.JwtCache;
import kr.ac.jbnu.jclip.repository.JwtRedisRepository;

@Service
public class RedisService {
    @Autowired
    JwtRedisRepository jwtRepository;
    @Autowired
    JwtUtil jwtUtil;

    public JwtCache saveToken(JwtCache jwtCache) {
        return jwtRepository.save(jwtCache);
    }

    public JwtCache retrieveToken(String id) {

        JwtCache jwtCache = jwtRepository.findById(id).get();
        return jwtCache;
    }

    public boolean isValidateToken(String token) {
        String id = jwtUtil.getUserId(token);
        if (jwtUtil.isValidateToken(token) && retrieveToken(id).getIat() == jwtUtil.getIat(token))
            return true;

        return false;
    }

}
