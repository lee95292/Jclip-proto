package kr.ac.jbnu.jclip.model.redis;

import java.io.Serializable;

import javax.persistence.Id;

import org.springframework.data.redis.core.RedisHash;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@Getter
@RedisHash("JwtCache")
public class JwtCache implements Serializable {

    @Id
    private String id;
    private Long iat;

    @Builder
    public JwtCache(String id, Long iat) {
        this.id = id;
        this.iat = iat;
    }

}