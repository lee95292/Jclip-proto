package kr.ac.jbnu.jclip.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public Principal home(Principal principal) {
		System.out.println(principal.getName());
		return principal;
	}
}
