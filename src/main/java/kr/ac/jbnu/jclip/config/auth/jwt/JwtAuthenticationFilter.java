package kr.ac.jbnu.jclip.config.auth.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

public class JwtAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    public JwtAuthenticationFilter(JwtUtil jwtUtil) {
        super("/service/**");
    }

    // @Override
    // protected boolean requiresAuthentication(HttpServletRequest request,
    // HttpServletResponse response) {
    // String method = request.getMethod();
    // String uri = request.getRequestURI();
    // System.out.println(method + uri);
    // return !ignorePath.contains(method + uri);
    // }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {

        String header = request.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer ")) {
            // TODO 에러메세지 출력후 홈으로 리다이렉트
            response.setStatus(401);
            return null;
        }

        String authToken = header.substring(7);

        JwtAuthenticationToken authRequest = new JwtAuthenticationToken(authToken);

        return getAuthenticationManager().authenticate(authRequest);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);

        // As this authentication is in HTTP header, after success we need to continue
        // the request normally
        // and return the response as if the resource was not secured at all

        chain.doFilter(request, response);
    }

}