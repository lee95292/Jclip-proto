package kr.ac.jbnu.jclip.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.jbnu.jclip.model.Keyword;
import kr.ac.jbnu.jclip.model.User;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserRepositoryTest {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	KeywordRepository keywordRepository;
	@Test
	public void test() {
		Keyword testkey = new Keyword();
		keywordRepository.save(testkey);
		
		for(int i=0;i<10;i++) {
			User user = User.builder()
					.userName("mklee"+i)
					.userEmail("lee9595"+i)
					.userPassword("pspsp")
					.build();
			
			user.addKeyword(testkey);
			userRepository.save(user);
		}
		
		
	}

}
