package kr.ac.jbnu.jclip.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table
@Entity
public class Article{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="article_number")
	private int articleNumber;
	
	@CreationTimestamp
	private LocalDate creationTime;
	//jbnu_main,cse,carrer ..etc
	@Column(name="host_name")
	private String hostName;
	
	@Column(name="article_name")
	private String articleName;
	
	@Column(name="article_content")
	private String articleContent;

	@Override
	public String toString() {
		
		return "articleNumber:["+ articleNumber +"] creationTime[" + creationTime +"] hostName["+hostName +"] articleName["+ articleName +"] articleContent["+articleContent+"]";
	}
	
}
