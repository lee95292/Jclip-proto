package kr.ac.jbnu.jclip.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.ac.jbnu.jclip.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
	Article findTopByArticleNumber();
}
