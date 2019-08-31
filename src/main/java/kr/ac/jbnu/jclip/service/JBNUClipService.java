package kr.ac.jbnu.jclip.service;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.jbnu.jclip.repository.ArticleRepository;

@Service
public class JBNUClipService {
	@Autowired	
	private ArticleRepository articleRepository;
	
	public void updateArticle() {
		
	}
	
	public List<Element> getArticleList(Integer pno){
		List<Element> elList=null;
		try {
			Document totalDocument= Jsoup.connect("https://www.jbnu.ac.kr/kor/?menuID=139&pno="+pno).get();
			elList=totalDocument.select("table.ta_bo>tbody>tr");
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		return elList;
		
	}
	
	public boolean getValidArticleList() {
		int topNumber=articleRepository.findTopByArticleNumber().getArticleNumber();
		for(int pno=1;pno<=3;pno++) {
			List<Element> articleList = getArticleList(pno);
			articleList.get(articleList.size());
		}
		int min = 0;
		for(Element e : articleList) {
			if(e.getElementsByClass(".mnom")==null){
				continue;
			}
			
			Integer.parseInt(e.getElementsByClass(".mnom").text());
		}
		
	}

}
