package kr.ac.jbnu.jclip.social;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import kr.ac.jbnu.jclip.model.User;
import kr.ac.jbnu.jclip.model.UserConnection;
import kr.ac.jbnu.jclip.service.UserService;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class SocialService {

    private final UserService userService;

    public UsernamePasswordAuthenticationToken doAuthentication(UserConnection userConnection) {

        if (userService.isExistUser(userConnection)) {
            // ���� ȸ���� ��쿡�� �����ͺ��̽����� ��ȸ�ؼ� ���� ó��
            final User user = userService.findBySocial(userConnection);
            return setAuthenticationToken(user);
        } else {
            // �� ȸ���� ��� ȸ������ ���� ���� ó��
            final User user = userService.signUp(userConnection);
            return setAuthenticationToken(user);

        }
    }


    private UsernamePasswordAuthenticationToken setAuthenticationToken(Object user) {
        return new UsernamePasswordAuthenticationToken(user, null, getAuthorities("ROLE_USER"));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String role) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));
        return authorities;
    }
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}