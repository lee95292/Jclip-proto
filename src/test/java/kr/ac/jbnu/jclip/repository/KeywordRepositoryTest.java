package kr.ac.jbnu.jclip.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.jbnu.jclip.model.Keyword;
import kr.ac.jbnu.jclip.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class KeywordRepositoryTest {
	
	@Autowired
	KeywordRepository keywordRepository;
	
	@Before
	public void setup() {
		Keyword keyword = null;
		User user = new User();
		for(int i=0;i<10;i++) {
			keyword = new Keyword();
			keyword.setHostName("jbnu_main");
			keyword.setWord("key"+Integer.toString(i));
			
			user.addKeyword(keyword);
			keywordRepository.save(keyword);
		}
	}
	
	@Test
	@Transactional
	public void test() {		
		Optional<Keyword> key = keywordRepository.findByHostNameAndWord("jbnu_main", "key3");
		key.ifPresent(keye -> System.out.println(keye.toString()));
		System.out.println();
	}

}
