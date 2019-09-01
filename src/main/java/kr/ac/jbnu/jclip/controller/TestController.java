package kr.ac.jbnu.jclip.controller;

import java.util.List;

import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.jbnu.jclip.service.JBNUClipService;

@Controller
public class TestController {

	@Autowired
	private JBNUClipService jbnuClipService;
	
	@GetMapping("/test")
	@ResponseBody
	public List<Element> test() {
		List<Element> list = jbnuClipService.getValidArticleList();
		
		return list;
	}
}
