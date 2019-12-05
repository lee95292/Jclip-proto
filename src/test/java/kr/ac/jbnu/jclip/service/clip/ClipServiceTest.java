package kr.ac.jbnu.jclip.service.clip;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.jbnu.jclip.model.Keyword;
import kr.ac.jbnu.jclip.model.User;
import kr.ac.jbnu.jclip.model.UserConnection;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ClipServiceTest {

	@Autowired
	ClipService clipService;

	User user;
	Keyword keyword;

	@Before
	public void setup() {
		user = User.signUp(new UserConnection());
		keyword = Keyword.generateKeyword("jbnu_main", "학삭공지");
	}

	@Test
	public void test() {
		clipService.addKeyword(user, "jbnu_main", "학삭공지");
		for (Keyword key : user.getKeywords()) {
			System.out.println(key.toString());
		}
	}

}
