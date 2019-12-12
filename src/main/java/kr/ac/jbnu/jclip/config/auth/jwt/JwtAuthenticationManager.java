package kr.ac.jbnu.jclip.config.auth.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import kr.ac.jbnu.jclip.service.user.RedisService;

@Component
public class JwtAuthenticationManager implements AuthenticationManager {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private RedisService redisService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication;
        String token = (String) jwtAuthenticationToken.getPrincipal();

        if (!redisService.isValidateToken(token)) {
            System.out.println("유효하지 않은 토큰이거나 최신 토큰이 아닙니다.");
            return null;
        }

        AuthenticatedUser user = jwtUtil.getUser(token);
        if (user == null) {
            System.out.println("JWT token is not valid");
        } else if (!user.isAuthenticated()) {
            System.out.println("required field is wrong.");
        }

        return user;
    }
}
