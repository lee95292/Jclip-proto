package kr.ac.jbnu.jclip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {

	@GetMapping(value = "/")
	public String index(Model model) {
		return "index";
	}
}
