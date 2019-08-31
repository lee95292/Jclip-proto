package kr.ac.jbnu.jclip.service;

import java.io.IOException;
import java.util.ArrayList;
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
		//articleRepository.saveAll(getValidArticleList());
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
	
	//코드 이렇게 짜면 안된다.... 리얼서비스 짤때는 갈아엎자.
	public List<Element> getValidArticleList() {
		List<Element> validArticleList = new ArrayList<Element>();
		int topNumber=articleRepository.findTopByOrderByArticleNumberDesc().getArticleNumber();
		for(int pno=1;pno<=3;pno++) {
			List<Element> articleList = getArticleList(pno);
			if(topNumber>getArticleNumber(articleList.get(articleList.size()))) {
				for(Element e : articleList) {
					if(getArticleNumber(e)>topNumber) {
						validArticleList.add(e);
					}else {
						break;
					}
				}
			}else {
				validArticleList.addAll(articleList);
			}
		}
		return validArticleList;
	}
	
	public Integer getArticleNumber(Element e) {
		Element row = e.getElementsByClass("mnom").get(0);
		if(row==null) {
			return -1;
		}
		
		return Integer.parseInt(row.text());
	}
}

