package test.czh.runcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseCase {

	
	public WebDriver GetDriver(String browser) {
		WebDriver driver;
		if (browser.equalsIgnoreCase("chrome")) {
			 System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
			 driver = new ChromeDriver();
			 
		}else {
			 System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
			 driver = new ChromeDriver();
		}
		
		return driver;
		
	}
}
