package kr.ac.jbnu.jclip.service.crawl.domins;

import java.util.List;

import org.jsoup.nodes.Element;

import kr.ac.jbnu.jclip.model.Article;

/*
	1. 삭제된 게시글 또는 컨텐츠 텍스트 없는 게시글 처리
*/
public interface CrawlService {
	public Article getArticleByElement(Element row);

	public Article getArticle(int articleNumber);

	public void setLatestArticles(List<Article> latestArticles);

	public List<Article> getLatestArticles();
}
