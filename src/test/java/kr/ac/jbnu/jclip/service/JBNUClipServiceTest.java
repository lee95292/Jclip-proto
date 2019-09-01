package kr.ac.jbnu.jclip.service;

import java.util.List;

import org.jsoup.nodes.Element;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith( SpringJUnit4ClassRunner.class )
//@DataJpaTest
@WebMvcTest
public class JBNUClipServiceTest {
	private JBNUClipService clipService;
	
	@Before
	public void setup() {
		clipService = new JBNUClipService();
	}
	@Test
	public void test() {
		List<Element> articleList= clipService.getValidArticleList();
		System.out.println(articleList.toString());
		
		for(Element e: articleList) {
			System.out.println("e:"+e.text());
		}
		System.out.println("asdasdasdtest");
	}
}
