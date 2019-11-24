package kr.ac.jbnu.jclip.controller.clip;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.jbnu.jclip.model.Article;
import kr.ac.jbnu.jclip.service.crawl.ArticleUpdateService;

@RestController(value = "/api/article/")
public class ArticleController {
	private ArticleUpdateService crawlService;
	
	@GetMapping("/service/recent")
	public List<Article> getRecentArticle() {
		return crawlService.getLatestArticles("jbnu_main");
	}

	// service binding
	public ArticleController(ArticleUpdateService crawlService) {
		this.crawlService = crawlService;
	}
}
