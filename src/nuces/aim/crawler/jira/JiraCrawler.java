package nuces.aim.crawler.jira;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class JiraCrawler {
	
	public Data crawlJira() {
	//	Data dataElement;
		WebDriver driver;
		ChromeOptions chromeOptions = new ChromeOptions();
		String[] array = { "--start-maximized" };
		chromeOptions.addArguments(array);
		
		System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
		driver = new ChromeDriver(chromeOptions);
		driver.get("https://issues.apache.org/jira/browse/CAMEL-10597/");

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		List<WebElement> bugType = driver.findElements(By.xpath("//*[@id=\"type-val\"]"));
		List<WebElement> assignee = driver.findElements(By.xpath("//*[@id=\"issue_summary_assignee_davsclaus\"]"));
		List<WebElement> description = driver.findElements(By.className("user-content-block"));
		List<WebElement> date=driver.findElements(By.className("dates"));
		List<WebElement> comments=driver.findElements(By.className("issuePanelContainer"));
		
		//Prints
		Data data=new Data();
	//	for(int i=0;i<bugType.size();i++)
		{
			System.out.println("Bug Type:"+bugType.get(0).getText());
			data.type=bugType.get(0).getText();
			
		}

			System.out.println("Assignee:" + assignee.get(0).getText());
			data.assignee=assignee.get(0).getText();
		
		for(int i=0;i<description.size();i++){
			System.out.println("Description:"+description.get(i).getText());
			data.description+=description.get(0).getText();
		}
		
			System.out.println("Date:"+date.get(0).getText());
			data.dateCreated=date.get(0).getText();
		
		
		for(int i=0;i<comments.size();i++){
			System.out.println("Comments:"+comments.get(i).getText());
			data.comments+=comments.get(i).getText();
		}
		
		driver.close();
		return data;
	}
}