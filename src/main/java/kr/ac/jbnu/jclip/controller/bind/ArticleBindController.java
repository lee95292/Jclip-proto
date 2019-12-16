package kr.ac.jbnu.jclip.controller.bind;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.jbnu.jclip.config.auth.jwt.JwtUtil;
import kr.ac.jbnu.jclip.model.Article;
import kr.ac.jbnu.jclip.model.Keyword;
import kr.ac.jbnu.jclip.model.User;
import kr.ac.jbnu.jclip.service.bind.ArticleBindService;
import kr.ac.jbnu.jclip.service.clip.ClipService;
import kr.ac.jbnu.jclip.service.user.UserService;

@RestController
public class ArticleBindController {
    ArticleBindService ArticleBindService;
    UserService userService;
    JwtUtil jwtUtil;
    ClipService clipService;

    public ArticleBindController(JwtUtil jwtUtil, UserService userService, ArticleBindService articleBindService,
            ClipService clipService) {
        this.ArticleBindService = articleBindService;
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.clipService = clipService;
    }

    @GetMapping(value = "/article")
    public List<Article> getBindedArticle(@RequestParam("token") String token) {
        User user = getUserByToken(token);

        if (user == null) {
            return null;
        }

        return user.getArticles();
    }

    @GetMapping(value = "/bind")
    public List<Keyword> bindUserKeyword(@RequestParam("keyword") String word, @RequestParam("token") String token,
            @RequestParam("hostname") String hostname) {
        User user = getUserByToken(token);

        if (user == null) {
            System.out.println("ArticleBindController debug: user null");
            return null;
        }
        clipService.addKeyword(user, hostname, word);
        return user.getKeywords();
    }

    private User getUserByToken(String token) {
        String email = jwtUtil.getUserId(token);
        if (email == null) {
            return null;
        }

        return userService.getUserByUserEmail(email);
    }

}