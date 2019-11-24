package kr.ac.jbnu.jclip.config.auth.jwt;

import java.util.Collection;

import javax.security.auth.Subject;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class JwtAuthenticationToken implements Authentication {
    private String authToken;

    JwtAuthenticationToken(String authToken) {
        this.authToken = authToken;
    }

    @Override
    public Object getPrincipal() {
        return authToken;
    }

    @Override
    public boolean implies(Subject subject) {
        return false;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public boolean isAuthenticated() {
        return false;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

    }
}
// https://jamcode.tistory.com/45