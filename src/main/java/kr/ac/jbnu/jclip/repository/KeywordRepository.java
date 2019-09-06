package kr.ac.jbnu.jclip.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kr.ac.jbnu.jclip.model.Keyword;

@Repository
public interface KeywordRepository extends CrudRepository<Keyword, Integer>{
	Optional<Keyword> findByHostNameAndWord(String hostName, String word);
}
