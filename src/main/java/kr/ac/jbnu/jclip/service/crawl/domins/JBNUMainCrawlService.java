/*
 * Author : mklee(lee95292)
 * 
 * Description : kr.ac.jbnu.jclip.config.CrawlDataLoader에서 애플리케이션 시작 시 크롤링 데이터 모음.
 * */
package kr.ac.jbnu.jclip.service.crawl.domins;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import kr.ac.jbnu.jclip.model.Article;

@Service
public class JBNUMainCrawlService implements CrawlService{
	private String host="https://www.jbnu.ac.kr/";
	private String boardURL= host+"kor/?menuID=139&mode=view&no=";
	private String hostName="jbnu_main";
	private List<Article> latestArticles = new ArrayList<Article>();
	
	private int articleNumberUnderbound=40000;
//	private boolean 
	@Override
	public Article getArticle(int articleNumber) {
		Element articleElement =null;
		String articleURL = boardURL+articleNumber;
		try {
			Document totalDocument= Jsoup.connect(articleURL).get();
			articleElement =totalDocument.getElementById("print_area");
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		// 삭제된 게시글
		if(articleElement==null) {
			Article nullArticle = new Article();
			nullArticle.setArticleContent("##");
			return nullArticle;
		}
		Article article = getArticleByElement(articleElement);
		article.setArticleHyperlink(articleURL);
		return article;
	}	
	
	
	/*
	 * 	@Args - element : 아티클 전체에 해당하는 HTML 
	 * */
	@Override
	public Article getArticleByElement(Element element) {
		Article article = new Article();
		String articleName = element.getElementsByClass("subject").last().text();
		String articleContent = element.getElementsByClass("smartOutput").get(0).text();

		article.setArticleName(articleName);
		article.setHostName(hostName);
		article.setArticleContent(articleContent);
		return article;
	}
	
	public int getArticleNumberUnderbound() {
		return this.articleNumberUnderbound;
	}


	@Override
	public List<Article> getLatestArticles() {
		return latestArticles;
	}


	@Override
	public void setLatestArticles(List<Article> latestArticles) {
		// TODO Auto-generated method stub
		
	}
}
