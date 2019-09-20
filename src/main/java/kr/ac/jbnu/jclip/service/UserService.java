package kr.ac.jbnu.jclip.service;

import java.util.Optional;

import javax.transaction.Transactional;

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

	@Transactional
	public void addKeyword(User user, Keyword keyword) {
		Keyword validKeyword= getValidKeyword(keyword);		
		validKeyword.addUser(user);	
		
		keywordRepository.save(validKeyword);
	}
	
	@Transactional
	public Keyword getValidKeyword(Keyword keyword) {
		Optional<Keyword> optionKeyword = keywordRepository.findByHostNameAndWord(keyword.getHostName(), keyword.getWord());
		
		return optionKeyword.orElse(keyword);
	}

	@Transactional
	public Optional<User> getUserByUserEmail(String userEmail) {
		return userRepository.findUserByUserEmail(userEmail);
	}
	
	
}
