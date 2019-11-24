package kr.ac.jbnu.jclip.config;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import kr.ac.jbnu.jclip.model.Article;
import kr.ac.jbnu.jclip.repository.ArticleRepository;
import kr.ac.jbnu.jclip.service.crawl.ArticleUpdateService;

@Component
public class CrawlDataLoader {
	
	ArticleUpdateService updateService;
	ArticleRepository articleRepository;
	List<String> hostNames = new ArrayList<String>();
	
	//for development. 
	boolean workStatus = true;
	
	public CrawlDataLoader(ArticleUpdateService updateService,ArticleRepository articleRepository) {
		this.articleRepository=articleRepository;
		this.updateService=updateService;
		
		hostNames.add("jbnu_main");
	}
	@PostConstruct
	public void articleDataLoad() {

		if(!workStatus)
			return;
		System.out.println(articleRepository.toString()+"\n\n\n");
		for(String hostName :hostNames) {
			List<Article> latestArticles=updateService.getLatestArticles(hostName);
			updateService.setLatestArticles(hostName, latestArticles);
			articleRepository.saveAll(latestArticles);
			
		}

	}
}
