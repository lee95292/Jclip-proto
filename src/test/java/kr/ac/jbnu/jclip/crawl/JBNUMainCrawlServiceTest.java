package kr.ac.jbnu.jclip.crawl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.jbnu.jclip.model.Article;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class JBNUMainCrawlServiceTest {

	@Autowired
	JBNUMainCrawlService crawl;
	
	@Test
	public void test() {
		Article article = crawl.getArticle(42036);
		article.setArticleNumber(41036);
		
		System.out.println(article.toString());
	}

}
