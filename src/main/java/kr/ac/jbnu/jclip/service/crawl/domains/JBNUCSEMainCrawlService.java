package kr.ac.jbnu.jclip.service.crawl.domains;

import java.util.List;

import org.jsoup.nodes.Element;

import kr.ac.jbnu.jclip.model.Article;

public class JBNUCSEMainCrawlService implements CrawlService {

	@Override
	public List<Article> crawlLatestArticles() {
		return null;
	}

	@Override
	public Article getArticleByElement(Element row) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Article getArticle(int articleNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLatestArticles(List<Article> latestArticles) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Article> getLatestArticles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCrawlUnderBound(int bound) {
		// TODO Auto-generated method stub

	}

}
