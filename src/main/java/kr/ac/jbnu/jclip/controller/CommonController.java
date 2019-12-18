package kr.ac.jbnu.jclip.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommonController {

	@GetMapping(value = "/")
	public String index(Model model) {
		return "index";
	}

	@GetMapping(value = "/token")
	public String getToken(@RequestParam("token") String token, HttpServletResponse response) throws IOException {
		response.setHeader("token", token);
		return "index";
	}
}
