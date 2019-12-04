package kr.ac.jbnu.jclip.service.crawl.domins;

import java.util.List;

import org.jsoup.nodes.Element;

import kr.ac.jbnu.jclip.model.Article;

public interface CrawlService {
	public Article getArticleByElement(Element row);

	public Article getArticle(int articleNumber);

	public void setLatestArticles(List<Article> latestArticles);

	public List<Article> getLatestArticles();
}