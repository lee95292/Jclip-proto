package kr.ac.jbnu.jclip.model;

import java.util.ArrayList;
import java.util.List;

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

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;

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
@NoArgsConstructor
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
	

	@Builder.Default
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="tbl_user_keyword", joinColumns = @JoinColumn(name="USER_ID")
									  , inverseJoinColumns = @JoinColumn(name="KEYWORD_ID"))
	private List<Keyword> keywords = new ArrayList<Keyword>();
	
	@Builder.Default
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tbl_user_article", joinColumns = @JoinColumn(name="USER_ID")
										, inverseJoinColumns = @JoinColumn(name="ARTICLE_ID"))
	private List<Article> articles =new ArrayList<Article>();
	
	public void addKeyword(Keyword keyword) {
		this.keywords.add(keyword);
	}
	
	public void addArticle(Article article) {
		this.articles.add(article);
	}
}
 