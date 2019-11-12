package kr.ac.jbnu.jclip.config;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import kr.ac.jbnu.jclip.model.Article;
import kr.ac.jbnu.jclip.repository.ArticleRepository;
import kr.ac.jbnu.jclip.service.ArticleCrawlService;

@Component
public class CrawlDataLoader {
	
	ArticleCrawlService crawlService;
	ArticleRepository articleRepository;
	List<String> hostNames = new ArrayList<String>();
	
	public CrawlDataLoader(ArticleCrawlService crawlService,ArticleRepository articleRepository) {
		this.articleRepository=articleRepository;
		this.crawlService=crawlService;
		
		hostNames.add("jbnu_main");
	}
	@PostConstruct
	public void articleDataLoad() {

		System.out.println(articleRepository.toString()+"\n\n\n");
		for(String hostName :hostNames) {
			List<Article> validArticles=crawlService.getLatestArticles(hostName);
			articleRepository.saveAll(validArticles);
		}

	}
}
