package kr.ac.jbnu.jclip.controller;

import java.security.Principal;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.jbnu.jclip.model.User;
import kr.ac.jbnu.jclip.repository.UserRepository;
import lombok.AllArgsConstructor;

/*
 * 테스트를 통해 알아낸 정보
 * 
 * */
@AllArgsConstructor
@RestController
public class TestController {

	UserRepository userRepository;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public Principal home(Principal principal) {
		// System.out.println("princiapl.getname: "+principal.getName());
		// Collection <? extends GrantedAuthority> gauthes =
		// userDetailsService.loadUserByUsername(principal.getName()).getAuthorities();
		// for(GrantedAuthority auth : gauthes) {
		// System.out.println(auth.getAuthority());
		// }
		if (principal instanceof UsernamePasswordAuthenticationToken) {

			System.out.println(((User) (((UsernamePasswordAuthenticationToken) principal).getDetails())));
		} else {
			System.out.println("none");
		}
		return principal;
	}

	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public User test2(UsernamePasswordAuthenticationToken token) {

		return ((User) token.getDetails());
	}
}
