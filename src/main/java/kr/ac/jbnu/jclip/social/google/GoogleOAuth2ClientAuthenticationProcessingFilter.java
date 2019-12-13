package kr.ac.jbnu.jclip.social.google;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import kr.ac.jbnu.jclip.config.auth.jwt.JwtUtil;
import kr.ac.jbnu.jclip.model.UserConnection;
import kr.ac.jbnu.jclip.model.redis.JwtCache;
import kr.ac.jbnu.jclip.service.user.RedisService;
import kr.ac.jbnu.jclip.social.SocialService;

public class GoogleOAuth2ClientAuthenticationProcessingFilter extends OAuth2ClientAuthenticationProcessingFilter {

    private ObjectMapper mapper = new ObjectMapper();
    private SocialService socialService;
    RedisService redisService;

    private JwtUtil jwtUtil;

    public GoogleOAuth2ClientAuthenticationProcessingFilter(SocialService socialService, JwtUtil jwtUtil,
            RedisService redisService) {
        super("/login/google");
        this.socialService = socialService;
        this.jwtUtil = jwtUtil;
        this.redisService = redisService;
    }

    @PostConstruct
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {
        // super.successfulAuthentication(request, response, chain, authResult);
        // Nearly a no-op, but if there is a ClientTokenServices then the token will now
        // be stored

        final OAuth2AccessToken accessToken = restTemplate.getAccessToken();
        final OAuth2Authentication auth = (OAuth2Authentication) authResult;
        final Object details = auth.getUserAuthentication().getDetails();

        final GoogleUserDetails userDetails = mapper.convertValue(details, GoogleUserDetails.class);
        userDetails.setAccessToken(accessToken);
        System.out.println(userDetails.toString());
        final UserConnection userConnection = UserConnection.valueOf(userDetails);
        final UsernamePasswordAuthenticationToken authenticationToken = socialService.doAuthentication(userConnection);

        // TODO: set auth token in the Response

        String token = jwtUtil.createToken(userConnection, authenticationToken.getAuthorities());
        System.out.println("jwt token" + token);
        JwtCache jwtCache = JwtCache.builder().id(jwtUtil.getUserId(token)).iat(jwtUtil.getIat(token)).build();

        response.setHeader("token: ", token);
        response.sendRedirect("/");
        redisService.saveToken(jwtCache);

        System.out.println("redis test" + redisService.retrieveToken(jwtUtil.getUserId(token)).getIat());
        super.successfulAuthentication(request, response, chain, authenticationToken);

    }

}
