package kr.ac.jbnu.jclip.service.domains;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.jbnu.jclip.model.Article;
import kr.ac.jbnu.jclip.service.crawl.ArticleUpdateService;

@SpringBootTest() // (properties = { "classpath:application.yml", "classpath:private.yml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class ArticleUpdateServiceTest {

    @Autowired
    private ArticleUpdateService articleUpdateService;

    @Before
    public void setup() {
    }

    @Test
    public void test() {

    }
}
