package kr.ac.jbnu.jclip.service.crawl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kr.ac.jbnu.jclip.model.Article;
import kr.ac.jbnu.jclip.repository.ArticleRepository;
import kr.ac.jbnu.jclip.service.crawl.domins.CrawlService;
import kr.ac.jbnu.jclip.util.CrawlerGroup;

@Service
public class ArticleUpdateService {
	private static final int articleNumberUnderBound = 40000;

	private ArticleRepository articleRepository;

	// statically declared domains..
	private int numberOfCrawl = 30;

	public ArticleUpdateService(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;

	}

	/*
	 * Service 1. HostNameë³„ë¡œ ìµœì‹  Article crawl
	 */
	public List<Article> getLatestArticles(String hostName) {
		int underBound = getTopArticleNumber(hostName) + 1;
		List<Article> validArticleList = new ArrayList<Article>();
		Article article;
		CrawlService crawl = CrawlerGroup.getCrawlServiceByHostName(hostName);

		for (int i = underBound; i < underBound + numberOfCrawl; i++) {
			article = crawl.getArticle(i);
			if (article.getArticleContent() == null) {
				break;
			}

			article.setArticleNumber(i);

			validArticleList.add(article);
		}

		return validArticleList;
	}

	// hostname top article number return
	int getTopArticleNumber(String hostName) {
		Article topArticle = articleRepository.findTopByhostNameOrderByArticleNumberDesc(hostName);

		if (topArticle == null) {
			return articleNumberUnderBound;
		}
		return topArticle.getArticleNumber();
	}

}
