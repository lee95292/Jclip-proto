package kr.ac.jbnu.jclip.repository;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.jbnu.jclip.model.Keyword;
import kr.ac.jbnu.jclip.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class KeywordRepositoryTest {
	
	@Autowired
	KeywordRepository keywordRepository;
	
	@Before
	public void setup() {
		Keyword keyword = null;
		for(int i=0;i<10;i++) {
			keyword = new Keyword();
			keyword.setHostName("jbnu_main");
			keyword.setWord("key"+Integer.toString(i));
			keyword.setUsers(new ArrayList<User>());
		}
	}
	
	@Test
	public void test() {		
		Optional<Keyword> key = keywordRepository.findByHostNameAndWord("jbnu_main", "keyword3");
		System.out.println(key.get().toString());
	}

}
