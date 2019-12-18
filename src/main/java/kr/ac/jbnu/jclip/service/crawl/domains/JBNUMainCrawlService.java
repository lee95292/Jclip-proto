/*
 * Author : mklee(lee95292)
 * 
 * Description : kr.ac.jbnu.jclip.config.CrawlDataLoader에서 애플리케이션 시작 시 크롤링 데이터 모음.
 * */
package kr.ac.jbnu.jclip.service.crawl.domains;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.jbnu.jclip.model.Article;
import kr.ac.jbnu.jclip.repository.ArticleRepository;

@Service
public class JBNUMainCrawlService implements CrawlService {
	private List<Article> latestArticles = new ArrayList<Article>();

	private String host = "https://www.jbnu.ac.kr/";
	private String boardURL = host + "kor/?menuID=139&mode=view&no=";
	private String hostName = "jbnu_main";
	private int crawlUnderBound = 42300;

	@Override
	public List<Article> crawlLatestArticles() {
		List<Article> validArticleList = new ArrayList<Article>();
		Article article;

		for (int i = crawlUnderBound; i <= getLatestArticleAtHost(); i++) {
			article = getArticle(i);
			// 더 이상 크롤링할 공지가 없을 경우
			if (article == null || article.getArticleContent() == null) {
				break;
			}

			article.setArticleNumber(i);
			validArticleList.add(article);
		}

		setLatestArticles(validArticleList);
		return validArticleList;
	}

	// int getTopArticleNumber() {
	// Article topArticle =
	// staticArticleRepository.findTopByhostNameOrderByArticleNumberDesc("jbnu_main");

	// if (topArticle == null) {
	// return articleNumberUnderBound;
	// }
	// return topArticle.getArticleNumber();
	// }
	public int getLatestArticleAtHost() {
		String tableURL = "https://www.jbnu.ac.kr/kor/?menuID=139";
		Element LatestNumber = null;
		Document totalDocument;
		try {
			totalDocument = Jsoup.connect(tableURL).get();
			LatestNumber = totalDocument.selectFirst("table > tbody > tr:nth-child(1) > th");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return LatestNumber == null ? crawlUnderBound : Integer.parseInt(LatestNumber.text());
	}

	// private boolean
	@Override
	public Article getArticle(int articleNumber) {
		Element articleElement = null;
		String articleURL = boardURL + articleNumber;
		try {
			Document totalDocument = Jsoup.connect(articleURL).get();
			articleElement = totalDocument.getElementById("print_area");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 삭제된 게시글
		if (articleElement == null) {
			Article nullArticle = new Article();
			nullArticle.setArticleContent("##");
			return nullArticle;
		}

		Article article = getArticleByElement(articleElement);
		if (article.getArticleContent() == null) {
			article.setArticleContent("##");
		}
		article.setArticleHyperlink(articleURL);
		return article;
	}

	/*
	 * @Args - element : 아티클 전체에 해당하는 HTML
	 */
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

	@Override
	public List<Article> getLatestArticles() {
		return latestArticles;
	}

	@Override
	public void setLatestArticles(List<Article> latestArticles) {
		this.latestArticles.addAll(latestArticles);
	}

	@Override
	public void setCrawlUnderBound(int bound) {
		this.crawlUnderBound = bound;
	}
}
