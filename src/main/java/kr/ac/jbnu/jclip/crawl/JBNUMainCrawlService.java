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
		String articleURL = boardURL+articleNumber;
		try {
			Document totalDocument= Jsoup.connect(articleURL).get();
			articleElement =totalDocument.getElementById("print_area");
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		// ������ �Խñ�
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
	 * 	@Args - element : ��ƼŬ ��ü�� �ش��ϴ� HTML 
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
}
