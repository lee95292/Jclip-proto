package kr.ac.jbnu.jclip.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kr.ac.jbnu.jclip.model.redis.JwtCache;

@Repository
public interface JwtRedisRepository extends CrudRepository<JwtCache, String> {

}