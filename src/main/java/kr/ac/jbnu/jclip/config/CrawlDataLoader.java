package kr.ac.jbnu.jclip.config;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import kr.ac.jbnu.jclip.service.JBNUClipService;

@Component
public class CrawlDataLoader {
	
	JBNUClipService jbnuCrawl;
	
	public CrawlDataLoader(JBNUClipService jbnuCrawl) {
		this.jbnuCrawl=jbnuCrawl;
	}
	
	@PostConstruct
	public void articleDataLoad() {
		jbnuCrawl.initArticleDB("jbnu_main");
	}
}
