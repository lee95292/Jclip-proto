package kr.ac.jbnu.jclip.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kr.ac.jbnu.jclip.model.Article;
import kr.ac.jbnu.jclip.repository.ArticleRepository;
import kr.ac.jbnu.jclip.service.crawl.CrawlService;
import kr.ac.jbnu.jclip.service.crawl.JBNUMainCrawlService;

@Service
public class ArticleCrawlService {
	private static final int articleNumberUnderBound=40000;
	private ArticleRepository articleRepository;
	private JBNUMainCrawlService jbnu_mainCrawl;
	
	private int numberOfCrawl=30;
	
	public ArticleCrawlService(ArticleRepository articleRepository, JBNUMainCrawlService jbnuCrawl) {
		this.articleRepository = articleRepository;
		this.jbnu_mainCrawl=jbnuCrawl;
		
	}
	
	public List<Article> getLatestArticles(String hostName){
		int underBound = getTopArticleNumber(hostName)+1;
		List<Article> validArticleList = new ArrayList<Article>();
		Article article;
		CrawlService crawl = getCrawlServiceByHostName(hostName);
		
		for(int i=underBound;i<underBound+numberOfCrawl;i++) {
			article = crawl.getArticle(i);
			if(article.getArticleContent()==null) {
				break;
			}
			
			article.setArticleNumber(i);
			
			validArticleList.add(article);
		}
		
		return validArticleList;
	}
	
	//hostname top article number return
	int getTopArticleNumber(String hostName) {
		Article topArticle = articleRepository.findTopByhostNameOrderByArticleNumberDesc(hostName);
		
		if(topArticle==null) {
			return articleNumberUnderBound;
		}
		return topArticle.getArticleNumber();
	}
	

	//TODO: Hostnames ���Ž� enum���� ��ü
	CrawlService getCrawlServiceByHostName(String hostName) {
		if(hostName.equals("jbnu_main")) {
			return jbnu_mainCrawl;
		}
		return null;
	}
}
