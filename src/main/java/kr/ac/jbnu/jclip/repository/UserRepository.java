package kr.ac.jbnu.jclip.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kr.ac.jbnu.jclip.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

}
