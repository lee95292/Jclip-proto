package kr.ac.jbnu.jclip.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kr.ac.jbnu.jclip.model.Article;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Integer> {
	Article findTopByhostNameOrderByArticleNumberDesc(String hostName);

	List<Article> findByHostName(String hostName);
}
