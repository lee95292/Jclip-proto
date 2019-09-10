package kr.ac.jbnu.jclip.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="keyword")
@Getter
@Setter
public class Keyword{
	
	@Id
	@Column(name = "KEYWORD_ID")	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="word")
	private String word;
	
	@Column(name="host_name")
	private String hostName;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="tbl_user_keyword", joinColumns = @JoinColumn(name="KEYWORD_ID")
										,inverseJoinColumns = @JoinColumn(name="USER_ID"))
	private List<User> users= new ArrayList<User>();
	
	@Override
	public String toString() {
		return "word["+ word +"] hostName["+ hostName+ "] users["+users+"]";
	}
	
	public void addUser(User user) {
		this.users.add(user);
	}
}
