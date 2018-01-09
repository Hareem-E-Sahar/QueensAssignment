package nuces.aim.crawler;

import java.util.List;

import nuces.aim.crawler.fileWriter.FileHandler;
import nuces.aim.crawler.jira.Data;
import nuces.aim.crawler.jira.JiraCrawler;


public class Driver {

	public static void main(String[] args) {
		
		//Crawling Jira
		JiraCrawler obj = new JiraCrawler();
		Data data=obj.crawlJira();
		FileHandler.generateCSV(data);
		

	}

}
