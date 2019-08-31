package kr.ac.jbnu.jclip.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.jbnu.jclip.model.Article;

@RunWith( SpringJUnit4ClassRunner.class )
@DataJpaTest
public class ArticleRepositoryTest {

	@Autowired
	ArticleRepository articleRepository;
	
	@Test
	public void test() {
		Article a = new Article();
		a.setArticleNumber(11);
		a.setArticleName("asdas");
		a.setArticleContent("asdasd");
		articleRepository.save(a);
		
		Article article = articleRepository.findTopByOrderByArticleNumberDesc();
	
		assertEquals(11, article.getArticleNumber());
	}

}
