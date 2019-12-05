package kr.ac.jbnu.jclip.util;

import kr.ac.jbnu.jclip.service.crawl.domins.CrawlService;

public enum CrawlerGroup {

    JBNU_MAIN("jbnu_main", CrawlerList.jbnuMainCrawler), CSE_MAIN("jbnu_cse_main", CrawlerList.cseMainCrwaler);

    private String hostName;
    private CrawlService crawler;

    private CrawlerGroup(String hostName, CrawlService crawler) {
        this.hostName = hostName;
        this.crawler = crawler;
    }

    public String getHostName() {
        return this.hostName;
    }

    public CrawlService getCrawlService() {
        return this.crawler;
    }
}