package kr.ac.jbnu.jclip.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.jbnu.jclip.model.Article;
@RunWith( SpringJUnit4ClassRunner.class )
@SpringBootTest
@Commit
public class JBNUClipServiceTest {
	@Autowired
	private JBNUClipService clipService;
	

	@Before
	public void setup() {
		clipService.initArticleDB("jbnu_main");
	}
	@Test
	public void test() {
		List<Article> list = clipService.getVailidArticleList("jbnu_main");
		
		for(Article a :list) {
			System.out.println(a.toString());
//			articleRepository.save(a);
		}
	}
}

