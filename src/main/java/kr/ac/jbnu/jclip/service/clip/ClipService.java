package kr.ac.jbnu.jclip.service.clip;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import kr.ac.jbnu.jclip.model.Keyword;
import kr.ac.jbnu.jclip.model.User;
import kr.ac.jbnu.jclip.repository.KeywordRepository;

@Service
public class ClipService {

	private KeywordRepository keywordRepository;

	public ClipService(KeywordRepository keywordRepository) {

		this.keywordRepository = keywordRepository;
	}

	@Transactional
	public Keyword addKeyword(User user, String hostname, String word) {
		// 유효 문자열 체크 : controller
		Keyword keyword = keywordRepository.findByHostNameAndWord(hostname, word);

		if (keyword == null) {
			keyword = Keyword.generateKeyword(hostname, word);
			keywordRepository.save(keyword);
		}
		user.addKeyword(keyword);

		return keyword;
	}

	public void removeKeyword(User user, String hostname, String word) {
		Keyword rmKey = Keyword.builder().hostName(hostname).word(word).build();

		user.removeKeyword(rmKey);
	}

}
