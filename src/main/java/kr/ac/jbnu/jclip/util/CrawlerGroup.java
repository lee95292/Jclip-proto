package kr.ac.jbnu.jclip.util;

import kr.ac.jbnu.jclip.model.Article;
import kr.ac.jbnu.jclip.service.crawl.domins.CrawlService;

public enum CrawlerGroup {

    JBNU_MAIN("jbnu_main", CrawlerList.jbnuMainCrawler), CSE_MAIN("jbnu_cse_main", CrawlerList.cseMainCrwaler);

    private String hostName;

    private CrawlerGroup(String hostName, CrawlService crawler) {
        this.hostName = hostName;
    }

    public String getHostName() {
        return this.hostName;
    }
}