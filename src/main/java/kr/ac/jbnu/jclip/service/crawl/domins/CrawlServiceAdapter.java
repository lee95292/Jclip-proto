package kr.ac.jbnu.jclip.service.crawl.domins;

import java.util.ArrayList;
import java.util.List;

import kr.ac.jbnu.jclip.model.Article;

public abstract class CrawlServiceAdapter implements CrawlService{
	private List<Article> latestArticles = new ArrayList<Article>();
	
	protected int articleNumberUnderbound=40000;
	
	@Override
	public List<Article> getLatestArticles() {
		return latestArticles;
	}


	@Override
	public void setLatestArticles(List<Article> latestArticles) {
		this.latestArticles=latestArticles;
	}
}
