package kr.ac.jbnu.jclip.util;

import kr.ac.jbnu.jclip.service.crawl.domains.JBNUCSEMainCrawlService;
import kr.ac.jbnu.jclip.service.crawl.domains.JBNUMainCrawlService;

public class CrawlerList {
    public static JBNUMainCrawlService jbnuMainCrawler = new JBNUMainCrawlService();
    public static JBNUCSEMainCrawlService cseMainCrwaler = new JBNUCSEMainCrawlService();
}