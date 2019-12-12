package kr.ac.jbnu.jclip.config.auth.jwt;
// import 생략

import java.util.Base64;
import java.util.Collection;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import kr.ac.jbnu.jclip.model.User;
import kr.ac.jbnu.jclip.model.UserConnection;
import kr.ac.jbnu.jclip.service.user.UserService;
import kr.ac.jbnu.jclip.social.SocialService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
@Repository
public class JwtUtil { // JWT 토큰을 생성 및 검증 모듈

    @Value("spring.jwt.secret")
    private String secretKey;

    private final long tokenValidMilisecond = 1000L * 60 * 60; // 1시간만 토큰 유효
    // private final String tokenType = "Bearer ";
    private final UserService userService;
    private final SocialService socialService;

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
        System.out.println("secret key :" + secretKey);
    }

    // Jwt 토큰 생성
    public String createToken(final UserConnection userConnection,
            final Collection<GrantedAuthority> grantedAuthorities) {
        final Claims claims = Jwts.claims().setSubject(userConnection.getEmail());
        claims.put("name", userConnection.getDisplayName());
        grantedAuthorities.forEach(auth -> {
            claims.put("auth", auth.getAuthority());
        });

        final Date now = new Date();
        return Jwts.builder().setClaims(claims) // 데이터
                .setIssuedAt(now) // 토큰 발행일자
                .setExpiration(new Date(now.getTime() + tokenValidMilisecond)) // set Expire Time
                .signWith(SignatureAlgorithm.HS256, secretKey) // 암호화 알고리즘, secret값 세팅
                .compact();
    }

    // Jwt 토큰으로
    // 인증 정보를 조회

    public Authentication getAuthentication(final String token) {
        // Claims claims =
        // Jwts.parser().setSigningKey(this.secretKey).parseClaimsJws(token).getBody();

        Collection<? extends GrantedAuthority> authorities = socialService.getAuthorities("ROLE_USER");
        final User userDetails = userService.getUserByUserEmail(this.getUserId(token)).get();
        return new UsernamePasswordAuthenticationToken(userDetails, null, authorities);
    }

    // Jwt 토큰에서 회원 구별 정보 추출
    public String getUserId(final String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    public String getUserName(final String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().get("name").toString();
    }

    public String getIat(final String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().get("iat").toString();
    }

    // Request의 Header에서 token 파싱 : "X-AUTH-TOKEN: jwt토큰"
    public String resolveToken(final HttpServletRequest req) {
        return req.getHeader("Authorization");
    }

    // Jwt 토큰의 유효성 + 만료일자 확인
    public boolean isValidateToken(final String jwtToken) {
        try {
            final Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (final Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public AuthenticatedUser getUser(final String jwtToken) {
        return new AuthenticatedUser(getUserId(jwtToken), getUserName(jwtToken));
    }
}
