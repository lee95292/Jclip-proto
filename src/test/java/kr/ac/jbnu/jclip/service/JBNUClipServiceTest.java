package kr.ac.jbnu.jclip.service;

import java.util.List;

import org.jsoup.nodes.Element;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.jbnu.jclip.model.Article;
import kr.ac.jbnu.jclip.repository.ArticleRepository;
@RunWith( SpringJUnit4ClassRunner.class )
@SpringBootTest
public class JBNUClipServiceTest {
	private JBNUClipService clipService;

	@Autowired
	private ArticleRepository articleRepository;
	
	@Before
	public void setup() {
		clipService = new JBNUClipService(articleRepository);
		Article e = new Article();
		e.setArticleContent("asd");
		e.setArticleName("asd");
		e.setId(1);
		e.setArticleNumber(40992);
		articleRepository.save(e);
	}
	@Test
	public void test() {
		List<Element> articleList= clipService.getValidArticleEntitiyList();
		System.out.println(articleList.toString());
		
		for(Element e: articleList) {
			System.out.println("e:"+e.text());
		}
	}
}
