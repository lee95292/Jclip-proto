package kr.ac.jbnu.jclip.crawl;

import java.io.IOException;

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
	
	@Override
	public Article getArticle(int articleNumber) {
		Element articleElement =null;
		try {
			Document totalDocument= Jsoup.connect(boardURL+articleNumber).get();
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
		return article;
	}	
	
	@Override
	public Article getArticleByElement(Element row) {
		Article article = new Article();
		String articleName = row.getElementsByClass("subject").last().text();
		String articleContent = row.getElementsByClass("smartOutput").get(0).text();
		
		article.setArticleName(articleName);
		article.setHostName(hostName);
		article.setArticleContent(articleContent);
		return article;
	}
}
