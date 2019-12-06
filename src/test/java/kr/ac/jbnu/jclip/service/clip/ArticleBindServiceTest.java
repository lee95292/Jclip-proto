package kr.ac.jbnu.jclip.service.clip;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.jbnu.jclip.config.CrawlDataLoader;
import kr.ac.jbnu.jclip.model.Article;
import kr.ac.jbnu.jclip.model.User;
import kr.ac.jbnu.jclip.model.UserConnection;
import kr.ac.jbnu.jclip.util.CrawlerGroup;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ArticleBindServiceTest {
    @Autowired
    CrawlDataLoader cd;
    List<Article> latest;
    User user;

    @Before
    public void setup() {
        user = User.signUp(new UserConnection());
        cd.articleDataLoad();
        latest = CrawlerGroup.getLatestArticles("jbnu_main");
    }

    @Test
    public void test() {
        for (Article article : latest) {
            System.out.println(article.toString());
        }
    }
}