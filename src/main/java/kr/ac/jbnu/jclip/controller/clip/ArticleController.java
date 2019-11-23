package kr.ac.jbnu.jclip.controller.clip;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.jbnu.jclip.model.Article;
import kr.ac.jbnu.jclip.service.ArticleCrawlService;

@RestController(value = "/api/article/")
public class ArticleController {
	private ArticleCrawlService crawlService;
	
	
	@GetMapping("recent")
	public List<Article> getRecentArticle(){
			return crawlService.getLatestArticles("jbnu_main");
	}
	
	//service binding 
	public ArticleController(ArticleCrawlService crawlService) {
		this.crawlService = crawlService;
	}
}
