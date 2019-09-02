package kr.ac.jbnu.jclip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.ac.jbnu.jclip.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
