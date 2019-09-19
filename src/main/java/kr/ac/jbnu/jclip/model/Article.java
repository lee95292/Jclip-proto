package kr.ac.jbnu.jclip.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Article{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="article_number")
	private int articleNumber;
	
	@CreationTimestamp
	private LocalDate creationTime;
	//jbnu_main,cse, carrer ..etc
	@Column(name="host_name")
	private String hostName;
	
	
	@Column(name="article_name")
	private String articleName;
	
	@Column(name="article_content")
	private String articleContent;

	@Column(name = "article_href")
	private String articleHyperlink;
	
	@Builder.Default
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "articles")
	private List<User> users = new ArrayList<User>();
	@Override
	public String toString() {
		
		return "articleNumber:["+ articleNumber +"] creationTime[" + creationTime +"] hostName["+hostName +"] articleName["+ articleName +"] articleContent["+articleContent+"]";
	}
	
}
