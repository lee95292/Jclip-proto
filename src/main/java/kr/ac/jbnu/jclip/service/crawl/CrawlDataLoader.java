package kr.ac.jbnu.jclip.service.crawl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import kr.ac.jbnu.jclip.model.Article;
import kr.ac.jbnu.jclip.repository.ArticleRepository;
import kr.ac.jbnu.jclip.service.bind.ArticleBindService;
import kr.ac.jbnu.jclip.util.CrawlerGroup;

@Component
public class CrawlDataLoader {

	ArticleBindService articleBindService;
	ArticleRepository articleRepository;

	boolean workStatus = true;

	public CrawlDataLoader(ArticleRepository articleRepository, ArticleBindService articleBindService) {
		this.articleRepository = articleRepository;
		this.articleBindService = articleBindService;
	}

	// @PostConstruct
	// public void articleDataLoad() {
	// doPrerequisite();
	// if (!workStatus)
	// return;
	// for (CrawlerGroup unit : CrawlerGroup.values()) {
	// List<Article> latestArticles = unit.getCrawlService().crawlLatestArticles();
	// articleRepository.saveAll(latestArticles);
	// CrawlerGroup.setLatestArticles(unit.getHostName(), latestArticles);
	// }

	// }

	@Scheduled(cron = "0 0/3 * * * *")
	public void periodicalDataLoader() {
		doPrerequisite();
		System.out.println("CrawlDataLoader.periodicalDataLoader executed");
		for (CrawlerGroup unit : CrawlerGroup.values()) {
			List<Article> latestArticles = unit.getCrawlService().crawlLatestArticles();
			System.out.println(latestArticles.size());
			articleRepository.saveAll(latestArticles);
			CrawlerGroup.setLatestArticles(unit.getHostName(), latestArticles);
			articleBindService.bindAllKeywordAndLatestArticle(latestArticles, unit.getHostName());
		}
	}

	// TODO refactor.. : crawl 서비스별로 개별적 수행되어야 하는 소스코드가 하드코딩됨.
	public void doPrerequisite() {
		Article topArticle = articleRepository.findTopByhostNameOrderByArticleNumberDesc("jbnu_main");

		if (topArticle == null) {
			return;
		}

		CrawlerGroup.getCrawlServiceByHostName("jbnu_main").setCrawlUnderBound(topArticle.getArticleNumber());
	}
}
