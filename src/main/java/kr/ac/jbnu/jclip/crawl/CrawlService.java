package kr.ac.jbnu.jclip.crawl;

import org.jsoup.nodes.Element;

import kr.ac.jbnu.jclip.model.Article;

public interface CrawlService {
	public Article getArticleByElement(Element row);

	public Article getArticle(int articleNumber);
}
