package kr.ac.jbnu.jclip.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.jbnu.jclip.social.google.GoogleUserDetails;

@RestController
public class TestController {

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public Principal home(Principal principal) {
		return principal;
	}
	
	@RequestMapping(value="/test2", method = RequestMethod.GET)
	public GoogleUserDetails test2(GoogleUserDetails guser) {
		System.out.println(guser.getName());
		return guser;
	}
}
