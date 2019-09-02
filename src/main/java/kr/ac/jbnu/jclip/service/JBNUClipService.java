package kr.ac.jbnu.jclip.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.ac.jbnu.jclip.crawl.JBNUMainCrawlService;
import kr.ac.jbnu.jclip.model.Article;
import kr.ac.jbnu.jclip.repository.ArticleRepository;

@Service
//@EnableJpaRepositories
public class JBNUClipService {
	
	private ArticleRepository articleRepository;
	private JBNUMainCrawlService jbnu_mainCrawl;
	private int underBoundArticleNumber;
	
	public JBNUClipService(ArticleRepository articleRepository, JBNUMainCrawlService jbnuCrawl) {
		this.articleRepository = articleRepository;
		this.jbnu_mainCrawl=jbnuCrawl;
		
		this.underBoundArticleNumber=40000;
	}
	
	//TODO - host name에 따라 크롤링할 서비스 찾기!!!@!@
//	public List<Article> getVailidArticleList(String hostName){
//		jbnu_mainCrawl.getArticle()
//	}
	
	//hostname top article number return
	int getTopArticleNumber(String hostName) {
		Article topArticle = articleRepository.findTopByhostNameOrderByArticleNumberDesc(hostName);
		
		return topArticle.getArticleNumber();
	}
}

