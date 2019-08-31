package kr.ac.jbnu.jclip.service;

import java.util.List;

import org.jsoup.nodes.Element;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class JBNUClipServiceTest {
	private JBNUClipService clipService;
	
	@Before
	public void setup() {
		clipService = new JBNUClipService();
	}
	@Test
	public void test() {
		List<Element> articleList= clipService.getArticleList(Integer.valueOf(1)));
		articleList.forEach(x -> System.out.println(x.parent()));
		
		System.out.println("test");
	
	}

}
