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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Keyword {

	@Id
	@Column(name = "KEYWORD_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "word", unique = true)
	private String word;

	@Column(name = "host_name")
	private String hostName;

	// TODO cascade 위험성 체크하고 refactor 하기. 성능저하 우려
	@Builder.Default
	@JsonBackReference
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "keywords")
	private List<User> users = new ArrayList<User>();

	@ManyToMany(fetch = FetchType.LAZY)
	@JsonManagedReference
	@JoinTable(name = "tbl_keyword_article", joinColumns = @JoinColumn(name = "KEYWORD_ID"), inverseJoinColumns = @JoinColumn(name = "ARTICLE_ID"))
	private List<Article> articles = new ArrayList<Article>();

	@Override
	public String toString() {
		return "word[" + word + "] hostName[" + hostName + "] users[" + users + "]";
	}

	public static Keyword generateKeyword(String hostname, String word) {
		return Keyword.builder().hostName(hostname).word(word).build();
	}

	public void addUser(User user) {
		this.users.add(user);
	}

	public void addArticle(Article article) {
		if (!this.articles.contains(article)) {
			this.articles.add(article);
		}
	}
}
