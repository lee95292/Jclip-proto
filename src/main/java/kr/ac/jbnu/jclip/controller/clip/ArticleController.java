package kr.ac.jbnu.jclip.controller.clip;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.jbnu.jclip.model.Article;
import kr.ac.jbnu.jclip.service.JBNUClipService;

@RestController("/api/article/")
public class ArticleController {
	private JBNUClipService jbnuClip;
	
	
	@GetMapping("recent")
	public List<Article> getRecentArticle(){
			return jbnuClip.getVailidArticleList("jbnu_main");
	}
	
	//service binding 
	public ArticleController(JBNUClipService jbnuClip) {
		this.jbnuClip = jbnuClip;
	}
}
