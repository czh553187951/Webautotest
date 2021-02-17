package test.czh;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public WebDriver driver;
	public void IntDriver(){
		System.setProperty("webdriver.chrome.driver", "D:\\study\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		driver.get("https://coding.imooc.com/");
		driver.manage().window().maximize();
	}
	public void Lession(){
		
		WebElement user=driver.findElement(By.xpath("/html/body/div[4]/div[1]/ul/li[1]/a/div"));
	}
	
	
	
	


}
