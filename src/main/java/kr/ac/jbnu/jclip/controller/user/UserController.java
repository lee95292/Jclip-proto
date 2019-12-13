package kr.ac.jbnu.jclip.controller.user;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.jbnu.jclip.config.auth.jwt.JwtUtil;

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

	@GetMapping(value = "/token")
	public String getToken(@RequestParam("token") String token, HttpServletResponse response) throws IOException {
		response.setHeader("token", token);
		return "index";
	}

}
