package kr.ac.jbnu.jclip.config.auth.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationManager implements AuthenticationManager {
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication;
        String token = (String) jwtAuthenticationToken.getPrincipal();

        AuthenticatedUser user = jwtUtil.getUser(token);
        if (user == null) {
            System.out.println("JWT token is not valid");
        } else if (!user.isAuthenticated()) {
            System.out.println("required field is wrong.");
        }

        return user;
    }
}
