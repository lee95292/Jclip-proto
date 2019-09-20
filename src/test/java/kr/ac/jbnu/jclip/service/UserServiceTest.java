package kr.ac.jbnu.jclip.service;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.jbnu.jclip.model.Keyword;
import kr.ac.jbnu.jclip.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceTest {

	@Autowired
	UserService userService;
	
	@Test
	@Transactional
	public void addKeywordTest() {
		User user = new User();
		userService.joinUser(user);

		
		Keyword key = new Keyword();
		key.setHostName("main_jbnu");
		
		userService.addKeyword(user, key);
		
	}

}
