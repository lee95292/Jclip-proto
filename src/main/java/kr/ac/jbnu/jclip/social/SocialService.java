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
import kr.ac.jbnu.jclip.repository.UserRepository;
import kr.ac.jbnu.jclip.service.user.UserService;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class SocialService {

    private final UserService userService;
    private final UserRepository userRepository;
    
    public UsernamePasswordAuthenticationToken doAuthentication(UserConnection userConnection) {

        if (userService.isExistUser(userConnection)) {
            // 기존 회원일 경우에는 데이터베이스에서 조회해서 인증 처리
            final User user = userService.findBySocial(userConnection);
            return setAuthenticationToken(user);
        } else {
            // 새 회원일 경우 회원가입 이후 인증 처리
            final User user = userService.signUp(userConnection);
            return setAuthenticationToken(user);

        }
    }

    private UsernamePasswordAuthenticationToken setAuthenticationToken(Object user) {
    	UsernamePasswordAuthenticationToken OauthToken=new UsernamePasswordAuthenticationToken(user, null, getAuthorities("ROLE_USER"));
        return setTokenDetails(OauthToken, user);
    }

    private UsernamePasswordAuthenticationToken setTokenDetails(
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken,Object user) {
		usernamePasswordAuthenticationToken.setDetails(user);
    	return usernamePasswordAuthenticationToken;
	}


	public Collection<? extends GrantedAuthority> getAuthorities(String role) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));
        return authorities;
    }
}
