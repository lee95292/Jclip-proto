package kr.ac.jbnu.jclip.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

	@GetMapping(value = "/login")
	public String login() {

		return "";
	}

	@PostMapping(value = "/register")
	public String registerByEmail() {
		return "";
	}
}
