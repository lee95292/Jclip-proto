package kr.ac.jbnu.jclip.service.clip;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.ac.jbnu.jclip.model.Keyword;
import kr.ac.jbnu.jclip.model.User;
import kr.ac.jbnu.jclip.repository.ArticleRepository;
import kr.ac.jbnu.jclip.repository.KeywordRepository;
import kr.ac.jbnu.jclip.service.crawl.ArticleUpdateService;

@Service
public class ClipService {
	
	private ArticleUpdateService articleUpdateService;
	private ArticleRepository articleRepository;
	private KeywordRepository keywordRepository;
	
	public ClipService(ArticleUpdateService articleUpdateService, ArticleRepository articleRepository ,KeywordRepository keywordRepository) {
		this.articleUpdateService=articleUpdateService;
		this.articleRepository=articleRepository;
		this.keywordRepository=keywordRepository;
	}
	public void addKeyword(User user,String hostname,String word) {
		//유효 문자열 체크 : controller
		
		Keyword keyword= keywordRepository.findByHostNameAndWord(hostname, word);
		
		if(keyword==null) {
			keyword=Keyword.generateKeyword(hostname,word);
		}
		user.addKeyword(keyword);
	}
	
	public void removeKeywordByHostNameAndWord(User user, String hostname,String word) {		
		Keyword rmKey = Keyword.builder()
			.hostName(hostname)
			.word(word).build();
		
		user.removeKeyword(rmKey);
	}
	
}
