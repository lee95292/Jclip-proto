package kr.ac.jbnu.jclip.service.crawl;

import java.util.List;

import kr.ac.jbnu.jclip.model.Article;
import kr.ac.jbnu.jclip.repository.ArticleRepository;

public class LatestArticleManager {
	
	private ArticleUpdateService articleUpdateService;
	private ArticleRepository articleRepository;
	
	public LatestArticleManager(ArticleUpdateService articleUpdateService, ArticleRepository articleRepository) {
		this.articleUpdateService=articleUpdateService;
		this.articleRepository=articleRepository;
	}
	
	public List<Article> getLatestArticles(String hostname){
		return null;
	}
}
