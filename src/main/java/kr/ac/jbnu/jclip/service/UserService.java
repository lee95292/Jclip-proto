package kr.ac.jbnu.jclip.service;

import java.util.Optional;

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
	
	/*
	 * @Args keyword - hostname, word가 설정된 키워드
	 * 
	 * */
	public void addKeyword(User user, Keyword keyword) {
		Keyword validKeyword= getValidKeyword(keyword);		
		validKeyword.addUser(user);	
		
		keywordRepository.save(validKeyword);
	}
	
	public Keyword getValidKeyword(Keyword keyword) {
		Optional<Keyword> optionKeyword = keywordRepository.findByHostNameAndWord(keyword.getHostName(), keyword.getWord());
		
		return optionKeyword.orElse(keyword);
	}

	public Optional<User> LoginByEmail(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
