package kr.ac.jbnu.jclip.controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.x.protobuf.MysqlxExpect.Open.Condition.Key;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.jbnu.jclip.config.auth.jwt.JwtUtil;
import kr.ac.jbnu.jclip.model.Article;
import kr.ac.jbnu.jclip.model.Keyword;
import kr.ac.jbnu.jclip.model.User;
import kr.ac.jbnu.jclip.repository.KeywordRepository;
import kr.ac.jbnu.jclip.service.user.UserService;

@RestController
public class UserController {

	UserService userService;
	JwtUtil jwtUtil;
	KeywordRepository keywordRepository;

	UserController(UserService userService, JwtUtil jwtUtil, KeywordRepository keywordRepository) {
		this.userService = userService;
		this.jwtUtil = jwtUtil;
		this.keywordRepository = keywordRepository;
	}

	@GetMapping(value = "/user/article")
	public List<Article> getBindedArticle(@RequestParam("token") String token) {
		User user = userService.getUserByToken(token);

		if (user == null) {
			return null;
		}
		return user.getArticles();
	}

	@GetMapping(value = "/user/keyword")
	public List<Keyword> getUserKeyword(@RequestParam("token") String token) {
		User user = userService.getUserByToken(token);
		if (user == null) {
			return null;
		}
		return user.getKeywords();
	}

	@GetMapping(value = "/user/removekey")
	public List<Keyword> removeUserKeyword(@RequestParam("token") String token, @RequestParam("word") String word,
			@RequestParam("hostname") String hostname) {
		User user = userService.getUserByToken(token);

		if (user == null) {
			return null;
		}

		user.getKeywords().remove(keywordRepository.findByHostNameAndWord(hostname, word));

		return user.getKeywords();
	}
}
