package com.time.service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;


@Service
public class StoryScrapper {
	public class Item {
		String title;
		String link;
		public Item() {
			// TODO Auto-generated constructor stub
		}
		public Item(String t,String l) {
			this.title=t;
			this.link=l;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getLink() {
			return link;
		}
		public void setLink(String link) {
			this.link = link;
		}
		
	}
	
	
	
    public List<Item> fetch() {
        String url = "https://time.com/";
        List<Item> list=new ArrayList<>();
        try {
            Document doc = Jsoup.connect(url).get();
            Elements specificClassElements = doc.getElementsByClass("partial latest-stories");
            Elements stories = doc.getElementsByClass("latest-stories__item");
            for (Element story : stories) {
                String title = story.select("a>h3").text();
                String link=story.select("a").attr("href");
                Item i=new Item(title,link);
                list.add(i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
		return list;
    }
}