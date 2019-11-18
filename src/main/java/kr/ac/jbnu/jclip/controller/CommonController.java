package kr.ac.jbnu.jclip.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {
	
	@GetMapping(value = "/")
	public String index(Principal principal){
		if(principal!=null)
		System.out.println(principal.getName());
		return "index";
	}
}
