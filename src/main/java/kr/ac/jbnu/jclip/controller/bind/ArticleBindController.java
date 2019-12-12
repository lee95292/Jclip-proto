package kr.ac.jbnu.jclip.controller.bind;

import org.springframework.web.bind.annotation.RestController;

import kr.ac.jbnu.jclip.repository.KeywordRepository;
import kr.ac.jbnu.jclip.service.bind.ArticleBindService;
import kr.ac.jbnu.jclip.service.clip.ClipService;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ArticleBindController {
    ArticleBindService ArticleBindService;
    ClipService clipService;

    public ArticleBindController(ArticleBindService articleBindService, ClipService clipService) {
        this.ArticleBindService = articleBindService;
        this.clipService = clipService;
    }

    @GetMapping(value = "bind/{keyword}")
    public void singleWordArticleBind(@PathVariable("keyword") String keyword,Principal principal) {
        System.out.println("ArticleBindController debug - "+principal.getName(););
        
    }
}