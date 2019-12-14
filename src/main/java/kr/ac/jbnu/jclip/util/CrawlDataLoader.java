package kr.ac.jbnu.jclip.util;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import kr.ac.jbnu.jclip.model.Article;
import kr.ac.jbnu.jclip.repository.ArticleRepository;
import kr.ac.jbnu.jclip.service.crawl.ArticleUpdateService;

@Component
public class CrawlDataLoader {

	ArticleUpdateService articleUpdateService;
	ArticleRepository articleRepository;
	List<String> hostNames = new ArrayList<String>();

	boolean workStatus = false;

	public CrawlDataLoader(ArticleRepository articleRepository, ArticleUpdateService articleUpdateService) {
		this.articleRepository = articleRepository;
		this.articleUpdateService = articleUpdateService;
		hostNames.add("jbnu_main");
	}

	@PostConstruct
	public void articleDataLoad() {

		if (!workStatus)
			return;
		for (String hostName : hostNames) {
			List<Article> latestArticles = articleUpdateService.getLatestArticles(hostName);
			articleRepository.saveAll(latestArticles);
			CrawlerGroup.setLatestArticles(hostName, latestArticles);
		}

	}
}
