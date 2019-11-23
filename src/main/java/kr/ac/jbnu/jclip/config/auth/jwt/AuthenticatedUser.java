package kr.ac.jbnu.jclip.config.auth.jwt;

import java.util.Collection;
import java.util.Collections;

import javax.security.auth.Subject;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.StringUtils;

public class AuthenticatedUser implements Authentication {
    private String email;
    private String name;

    AuthenticatedUser(String email, String nickname) {
        this.email = email;
        this.name = nickname;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Object getPrincipal() {
        return this.email;
    }

    @Override
    public boolean isAuthenticated() {
        return !StringUtils.isEmpty(email) && !StringUtils.isEmpty(name);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public boolean implies(Subject subject) {
        return false;
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
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

    }
}
