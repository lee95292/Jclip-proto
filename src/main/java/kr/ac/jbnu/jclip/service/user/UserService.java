package kr.ac.jbnu.jclip.service.user;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import kr.ac.jbnu.jclip.model.Keyword;
import kr.ac.jbnu.jclip.model.User;
import kr.ac.jbnu.jclip.model.UserConnection;
import kr.ac.jbnu.jclip.repository.KeywordRepository;
import kr.ac.jbnu.jclip.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	KeywordRepository keywordRepository;
		
	public User signUp(UserConnection userConnection) {
		final User user = User.signUp(userConnection);
		System.out.println("debug2:"+user.getUserEmail());
		return userRepository.save(user);
	}
	
	public User findBySocial(UserConnection userConnection) {
		
		final User user=userRepository.findBySocial(userConnection);
		if(user==null) {
			/*
			 * UserNotfound
			 * */
			throw new RuntimeException();
		}
		return user;
	}
	
	public boolean isExistUser(UserConnection userConnection) {
		final User user = userRepository.findBySocial(userConnection);
        return (user != null);
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
	
	public User getUserByAuthenticationToken(UsernamePasswordAuthenticationToken token){
		if(token.getDetails()==null) {
			throw new NullPointerException();
		}
		return (User)token.getDetails();
	}
	
	@Transactional
	public Optional<User> getUserByUserEmail(String userEmail) {
		return userRepository.findUserByUserEmail(userEmail);
	}
	
	
}
