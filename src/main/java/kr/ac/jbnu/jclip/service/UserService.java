package kr.ac.jbnu.jclip.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.jbnu.jclip.model.Keyword;
import kr.ac.jbnu.jclip.model.User;
import kr.ac.jbnu.jclip.repository.KeywordRepository;
import kr.ac.jbnu.jclip.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	KeywordRepository keywordRepository;
	
	public void joinUser(User user) {
		userRepository.save(user);
	}
	
	public boolean addKeyword(User user, String word) {
		List<Keyword> keyList = null;
		Keyword keyWord = new Keyword();
		
		keyWord.set
		
		if(user.getKeywords() == null) {
			keyList = new ArrayList<Keyword>();
			
		}
		user.setKeywords();
	}
	
	public boolean isValidAddition(String word, String hostName) {
		keywordRepository.fin
		
	}
}
