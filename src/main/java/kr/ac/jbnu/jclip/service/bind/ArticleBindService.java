
package kr.ac.jbnu.jclip.service.bind;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import kr.ac.jbnu.jclip.model.Article;
import kr.ac.jbnu.jclip.model.Keyword;
import kr.ac.jbnu.jclip.model.User;
import kr.ac.jbnu.jclip.repository.KeywordRepository;
import kr.ac.jbnu.jclip.util.CrawlerGroup;

@Service
public class ArticleBindService {

    private KeywordRepository keywordRepository;

    ArticleBindService(KeywordRepository keywordRepository) {
        this.keywordRepository = keywordRepository;
    }

    @Transactional
    public void bindAllKeywordAndLatestArticle(List<Article> articles, String hostname) {
        List<Keyword> bindingKeys = keywordRepository.findByHostName(hostname);

        for (Article article : articles) {
            String title = article.getArticleName();
            String content = article.getArticleContent() + title;
            for (Keyword keyword : bindingKeys) {
                /**
                 * Keyword와 Article이 String match keyword에 article들 bind할지 user에 bind할지 고민해보기
                 */
                if (content.contains(keyword.getWord())) {
                    System.out.println("ArticleBindService matching debug Keyword:" + keyword.getWord() + "And Article:"
                            + article.getArticleName());
                    keyword.addArticle(article);
                }
            }
        }
    }

    @Transactional
    public void bindKeywordAndLatestArticle(List<Article> latestArticle, Keyword keyword) {
        System.out.println("bindKeywordAndLatestArticle debug" + latestArticle.size());
        for (Article article : latestArticle) {
            String title = article.getArticleName();
            String content = article.getArticleContent() + title;
            if (content.contains(keyword.getWord())) {
                keyword.addArticle(article);
            }
        }
    }

    // keyword에 해당하는 article인지? --> TODO: Elastic search 쿼리로 수정 가능!
    public boolean isMatchKeyword(Keyword keyword, Article article) {
        String word = keyword.getWord();

        if (keyword.getHostName() != article.getHostName()) {
            return false;
        }

        if (article.getArticleContent().contains(word)) {
            return true;
        } else if (article.getArticleName().contains(word)) {
            return true;
        } else {
            return false;
        }
    }
}