package kr.ac.jbnu.jclip.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kr.ac.jbnu.jclip.model.User;
import kr.ac.jbnu.jclip.model.UserConnection;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	User findUserByUserEmail(String userEmail);

	User findBySocial(UserConnection userConnection);

	User findByUsername(String name);
}
