package kr.ac.jbnu.jclip.controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.jbnu.jclip.config.auth.jwt.JwtUtil;
import kr.ac.jbnu.jclip.model.Article;
import kr.ac.jbnu.jclip.model.Keyword;
import kr.ac.jbnu.jclip.model.User;
import kr.ac.jbnu.jclip.service.user.UserService;

@Controller
public class UserController {

	UserService userService;
	JwtUtil jwtUtil;

	UserController(UserService userService, JwtUtil jwtUtil) {
		this.userService = userService;
		this.jwtUtil = jwtUtil;
	}

	@GetMapping(value = "/user/article")
	public List<Article> getBindedArticle(@RequestParam("token") String token) {
		User user = userService.getUserByToken(token);

		if (user == null) {
			return null;
		}

		return user.getArticles();
	}

	@GetMapping(value = "/token")
	public String getToken(@RequestParam("token") String token, HttpServletResponse response) throws IOException {
		response.setHeader("token", token);
		return "index";
	}

	@GetMapping(value = "/user/keyword")
	public List<Keyword> getUserKeyword(@RequestParam("token") String token) {
		User user = userService.getUserByToken(token);
		if (user == null) {
			return null;
		}
		return user.getKeywords();
	}
}
