package kr.ac.jbnu.jclip.service.domains;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest // (properties = { "classpath:application.yml", "classpath:private.yml" })
// @RunWith(SpringJUnit4ClassRunner.class)
public class JBNUMainCrawlServiceTest {

    @Before
    public void setup() {
    }

    @Test
    public void test() {
        System.out.println("test start");
        String tableURL = "https://www.jbnu.ac.kr/kor/?menuID=139";
        Element LatestNumber = null;
        Document totalDocument;
        try {
            totalDocument = Jsoup.connect(tableURL).get();
            LatestNumber = totalDocument.selectFirst("table > tbody > tr:nth-child(1) > th");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(LatestNumber.text());
    }
}
