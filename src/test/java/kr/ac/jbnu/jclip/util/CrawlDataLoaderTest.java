package kr.ac.jbnu.jclip.util;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.jbnu.jclip.model.Article;
import kr.ac.jbnu.jclip.service.crawl.domins.JBNUMainCrawlService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CrawlDataLoaderTest {
    @Autowired
    CrawlDataLoader crawlDataLoader;

    @Test
    public void test() {
        List<Article> articles = CrawlerGroup.getLatestArticles("jbnu_main");
        System.out.println(articles.size());
        for (Article article : articles) {
            System.out.println(article.toString());
        }
    }
}