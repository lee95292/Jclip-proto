package kr.ac.jbnu.jclip.controller.bind;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.jbnu.jclip.config.auth.jwt.JwtUtil;
import kr.ac.jbnu.jclip.model.Article;
import kr.ac.jbnu.jclip.model.Keyword;
import kr.ac.jbnu.jclip.model.User;
import kr.ac.jbnu.jclip.repository.ArticleRepository;
import kr.ac.jbnu.jclip.service.bind.ArticleBindService;
import kr.ac.jbnu.jclip.service.clip.ClipService;
import kr.ac.jbnu.jclip.service.user.UserService;
import kr.ac.jbnu.jclip.util.CrawlerGroup;

@RestController
public class ArticleBindController {
    ArticleBindService ArticleBindService;
    UserService userService;
    JwtUtil jwtUtil;
    ClipService clipService;
    ArticleRepository articleRepository;

    public ArticleBindController(JwtUtil jwtUtil, UserService userService, ArticleBindService articleBindService,
            ClipService clipService, ArticleRepository articleRepository) {
        this.ArticleBindService = articleBindService;
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.clipService = clipService;
        this.articleRepository = articleRepository;
    }

    // 호스트별로 최신 아티클 로드
    @GetMapping(value = "/article")
    public List<Article> getLatestArticle(@RequestParam("hostname") String hostname) {
        // return
        return articleRepository.findByHostName(hostname);
    }

    // 키워드 추가 요청 받는 컨트롤러
    @GetMapping(value = "/bind")
    public List<Keyword> bindUserKeyword(@RequestParam("keyword") String word, @RequestParam("token") String token,
            @RequestParam("hostname") String hostname) {
        User user = userService.getUserByToken(token);

        if (user == null) {
            System.out.println("ArticleBindController debug: user null");
            return null;
        }
        ArticleBindService.bindKeywordAndLatestArticle(articleRepository.findByHostName(hostname),
                clipService.addKeyword(user, hostname, word));
        return user.getKeywords();
    }

}