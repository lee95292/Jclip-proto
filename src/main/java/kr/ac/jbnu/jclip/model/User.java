package kr.ac.jbnu.jclip.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class User{
	
	@Id
	@Column(name="USER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name="user_name")
	private String userName;

	@Column(name="user_email")
	private String userEmail;
	
	@Column(name="user_password")
	private String userPassword;
	

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
	private List<Keyword> keywords;
	
	public void addKeyword(Keyword keyword) {
		this.keywords.add(keyword);
	}
}
 