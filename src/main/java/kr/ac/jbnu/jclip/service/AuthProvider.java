package kr.ac.jbnu.jclip.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import kr.ac.jbnu.jclip.model.User;
import kr.ac.jbnu.jclip.service.user.UserService;

@Component("authProvider")
public class AuthProvider implements AuthenticationProvider {

	@Autowired
	UserService userService;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String id = authentication.getName();
		User user = userService.getUserByUserEmail(id);

		boolean passwordMatching = false;

		// if (user.isPresent()) {
		// passwordMatching =
		// passwordEncoder.matches(authentication.getCredentials().toString(),
		// user.get().getPassword());
		// }

		if (!passwordMatching) {
			authentication.setAuthenticated(false);
			;
		}

		return authentication;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return false;
	}

}
