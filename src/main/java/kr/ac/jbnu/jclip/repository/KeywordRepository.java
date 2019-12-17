package kr.ac.jbnu.jclip.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kr.ac.jbnu.jclip.model.Keyword;

@Repository
public interface KeywordRepository extends CrudRepository<Keyword, Integer> {
	Keyword findByHostNameAndWord(String hostName, String word);

	List<Keyword> findByHostName(String hostName);
}
