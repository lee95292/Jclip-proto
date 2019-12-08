package kr.ac.jbnu.jclip.util;

import java.util.ArrayList;
import java.util.List;

import kr.ac.jbnu.jclip.model.Article;
import kr.ac.jbnu.jclip.service.crawl.domins.CrawlService;

public enum CrawlerGroup {

    jbnu_main("jbnu_main", CrawlerList.jbnuMainCrawler), jbnu_cse_main("jbnu_cse_main", CrawlerList.cseMainCrwaler);

    private String hostName;
    private CrawlService crawler;

    private CrawlerGroup(String hostName, CrawlService crawler) {
        // System.out.println(hostName + crawler.toString());
        this.hostName = hostName;
        this.crawler = crawler;
    }

    public String getHostName() {
        return this.hostName;
    }

    public CrawlService getCrawlService() {
        return this.crawler;
    }

    public static void setLatestArticles(String hostName, List<Article> latestArticles) {
        getCrawlServiceByHostName(hostName).setLatestArticles(latestArticles);
        if (getCrawlServiceByHostName(hostName) == null || latestArticles == null || latestArticles.size() == 0) {
            System.out.println("test!!!\n\n");
        }
    }

    public static List<Article> getLatestArticles(String hostName) {
        return getCrawlServiceByHostName(hostName).getLatestArticles();

    }

    public static CrawlService getCrawlServiceByHostName(String hostName) {
        for (CrawlerGroup unit : CrawlerGroup.values()) {
            if (hostName.equals(unit.getHostName())) {
                return unit.getCrawlService();
            }
        }

        throw new NullPointerException();
    }

}