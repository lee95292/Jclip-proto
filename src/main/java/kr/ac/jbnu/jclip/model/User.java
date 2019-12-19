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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Table
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "provider_id", referencedColumnName = "provider_id", updatable = false, unique = true)
	private UserConnection social;

	@Column(name = "user_name" /* ,nullable = false */)
	private String username;

	@Column(name = "user_email")
	private String userEmail;

	@Column(name = "user_password")
	private String password;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	@JoinTable(name = "tbl_user_keyword", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "KEYWORD_ID"))
	private List<Keyword> keywords = new ArrayList<Keyword>();

	// @ManyToMany(fetch = FetchType.LAZY)
	// @JsonManagedReference
	// @JoinTable(name = "tbl_user_article", joinColumns = @JoinColumn(name =
	// "USER_ID"), inverseJoinColumns = @JoinColumn(name = "ARTICLE_ID"))
	// private List<Article> articles = new ArrayList<Article>();

	@Builder
	private User(String userEmail, String userName, UserConnection social) {
		this.userEmail = userEmail;
		this.username = userName;
		this.social = social;
	}

	public static User signUp(UserConnection userConnection) {
		return User.builder().userEmail(userConnection.getEmail()).userName(userConnection.getDisplayName())
				.social(userConnection).build();
	}

	public void addKeyword(Keyword keyword) {
		if (!this.keywords.contains(keyword)) {
			this.keywords.add(keyword);
			keyword.addUser(this);
		}
	}

	public void removeKeyword(Keyword removeKey) {
		if (this.keywords.contains(removeKey)) {
			keywords.remove(removeKey);
		}
	}

	public List<Article> getArticles() {
		List<Article> total = new ArrayList<Article>();
		for (Keyword keyword : this.keywords) {
			total.addAll(keyword.getArticles());
		}
		return total;
	}

}
