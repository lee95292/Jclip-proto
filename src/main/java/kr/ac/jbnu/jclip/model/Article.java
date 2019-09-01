package kr.ac.jbnu.jclip.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name="article")
@Entity
public class Article extends BaseEntity{
	public static final int UNDER_LIMIT=40000;
	@Column(name="article_number")
	private int articleNumber;
	@CreationTimestamp
	private LocalDate creationTime;
	
	
	@Column(name="article_name")
	private String articleName;
	@Column(name="article_content")
	private String articleContent;
	
}
