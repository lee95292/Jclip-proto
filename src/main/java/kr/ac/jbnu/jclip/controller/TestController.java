package kr.ac.jbnu.jclip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}
}
