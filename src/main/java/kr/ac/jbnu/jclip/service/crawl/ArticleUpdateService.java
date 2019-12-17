package kr.ac.jbnu.jclip.service.crawl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kr.ac.jbnu.jclip.model.Article;
import kr.ac.jbnu.jclip.repository.ArticleRepository;
import kr.ac.jbnu.jclip.service.crawl.domains.CrawlService;
import kr.ac.jbnu.jclip.util.CrawlerGroup;

@Service
public class ArticleUpdateService {
	// private static final int articleNumberUnderBound = 42300;

	// private ArticleRepository articleRepository;

	// // statically declared domains..
	// private int numberOfCrawl = 60;

	// public ArticleUpdateService(ArticleRepository articleRepository) {
	// this.articleRepository = articleRepository;

	// }

	// /*
	// * Service 1. HostNameë³„ë¡œ ìµœì‹  Article crawl
	// */
	// public List<Article> getLatestArticles(String hostName) {
	// int underBound = getTopArticleNumber(hostName) + 1;
	// List<Article> validArticleList = new ArrayList<Article>();
	// Article article;
	// CrawlService doaminCrawlService =
	// CrawlerGroup.getCrawlServiceByHostName(hostName);

	// for (int i = underBound; i < underBound + numberOfCrawl; i++) {
	// article = doaminCrawlService.getArticle(i);
	// // 더 이상 크롤링할 공지가 없을 경우
	// if (article == null || article.getArticleContent() == null) {
	// break;
	// }

	// article.setArticleNumber(i);

	// validArticleList.add(article);
	// }

	// return validArticleList;
	// }

	// // hostname top article number return
	// int getTopArticleNumber(String hostName) {
	// Article topArticle =
	// articleRepository.findTopByhostNameOrderByArticleNumberDesc(hostName);

	// if (topArticle == null) {
	// return articleNumberUnderBound;
	// }
	// return topArticle.getArticleNumber();
	// }

}
