package kr.ac.jbnu.jclip.service.user;

import org.springframework.stereotype.Service;

import kr.ac.jbnu.jclip.service.crawl.ArticleUpdateService;

@Service
public class ArticleBindingService {
	ArticleUpdateService articleUpdateService;
	
	public ArticleBindingService(ArticleUpdateService articleUpdateService) {
		this.articleUpdateService=articleUpdateService;
	}
	
	
}
