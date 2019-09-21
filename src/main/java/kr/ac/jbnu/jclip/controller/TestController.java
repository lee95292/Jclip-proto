package kr.ac.jbnu.jclip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping(value = "/")
	public String index() {
		return "index";
	}
}
