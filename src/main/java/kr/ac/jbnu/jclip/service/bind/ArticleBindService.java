
package kr.ac.jbnu.jclip.service.bind;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.ac.jbnu.jclip.model.Article;
import kr.ac.jbnu.jclip.model.Keyword;
import kr.ac.jbnu.jclip.model.User;

@Service
public class ArticleBindService {

    public void bindKeywordArticle(Keyword keyword, Article article) {
        if (!isMatchKeyword(keyword, article)) {
            return;
        }

        List<User> users = keyword.getUsers();
        for (User user : users) {
            user.addArticle(article);
        }
    }

    // keyword에 해당하는 article인지? --> TODO: Elastic search 쿼리로 수정 가능!
    public boolean isMatchKeyword(Keyword keyword, Article article) {
        String word = keyword.getWord();

        if (article.getArticleContent().contains(word)) {
            return true;
        } else if (article.getArticleName().contains(word)) {
            return true;
        } else {
            return false;
        }
    }
}