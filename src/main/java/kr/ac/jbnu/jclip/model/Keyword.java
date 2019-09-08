package kr.ac.jbnu.jclip.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="keyword")
@Getter
@Setter
public class Keyword extends BaseEntity{
	@Column(name="word")
	private String word;
	
	@Column(name="host_name")
	private String hostName;
	
	@ManyToMany
	private List<User> users;
	
	@Override
	public String toString() {
		return "word["+ word +"] hostName["+ hostName+ "] users["+users+"]";
	}
}
