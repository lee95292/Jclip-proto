package kr.ac.jbnu.jclip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.ac.jbnu.jclip.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
	Article findTopByOrderByArticleNumberDesc();
}
