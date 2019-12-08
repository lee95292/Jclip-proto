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
import kr.ac.jbnu.jclip.model.Keyword;
import kr.ac.jbnu.jclip.model.User;
import kr.ac.jbnu.jclip.model.UserConnection;
import kr.ac.jbnu.jclip.service.bind.ArticleBindService;
import kr.ac.jbnu.jclip.util.CrawlerGroup;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ArticleBindServiceTest {
    @Autowired
    CrawlDataLoader cd;

    @Autowired
    ArticleBindService articleBindService;

    List<Article> latest;
    User user;

    @Before
    public void setup() {
        cd.articleDataLoad();

        user = User.signUp(new UserConnection());
        latest = CrawlerGroup.getLatestArticles("jbnu_main");
    }

    @Test
    public void test() {
        Keyword mykey = Keyword.generateKeyword("jbnu_main", "은");
        user.addKeyword(mykey);

        for (Article article : latest) {
            articleBindService.bindKeywordArticle(mykey, article);
        }

    }
}