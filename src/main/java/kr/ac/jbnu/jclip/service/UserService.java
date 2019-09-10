package kr.ac.jbnu.jclip.service;

import java.util.ArrayList;
import java.util.List;
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
	
	public void addKeyword(User user, Keyword keyword) {
		Keyword validKeyword= getValidKeyword(keyword);
		
		validKeyword.addUser(user);	
		
		keywordRepository.save(validKeyword);
	}
	
	public Keyword getValidKeyword(Keyword keyword) {
		Optional<Keyword> optionKeyword = keywordRepository.findByHostNameAndWord(keyword.getHostName(), keyword.getWord());
		
		return optionKeyword.orElse(keyword);
	}
}
