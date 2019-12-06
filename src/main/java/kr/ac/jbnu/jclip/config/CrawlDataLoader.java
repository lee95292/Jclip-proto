package kr.ac.jbnu.jclip.config;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import kr.ac.jbnu.jclip.model.Article;
import kr.ac.jbnu.jclip.repository.ArticleRepository;
import kr.ac.jbnu.jclip.service.crawl.ArticleUpdateService;
import kr.ac.jbnu.jclip.util.CrawlerGroup;

@Component
public class CrawlDataLoader {

	ArticleRepository articleRepository;
	List<String> hostNames = new ArrayList<String>();

	// for development.
	boolean workStatus = false;

	public CrawlDataLoader(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
		hostNames.add("jbnu_main");
	}

	@PostConstruct
	public void articleDataLoad() {

		if (!workStatus)
			return;
		System.out.println(articleRepository.toString() + "\n\n\n");
		for (String hostName : hostNames) {
			List<Article> latestArticles = CrawlerGroup.getLatestArticles(hostName);
			CrawlerGroup.setLatestArticles(hostName, latestArticles);
			articleRepository.saveAll(latestArticles);

		}

	}
}
