package test.czh.runcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import test.czh.handle.LoginHandle;
import test.czh.page.LoginPage;

public class LoginCase {
	public WebDriver driver;
	public LoginHandle loginhandle;
	@BeforeClass
	  public void beforeClass() throws Exception {
		     System.setProperty("webdriver.chrome.driver", "D:\\BaiduNetdiskDownload\\chromedriver.exe");
			 driver = new ChromeDriver();
			 driver.get("https://zhan.zzxes.com.cn/#/");
			 Thread.sleep(2000);
			 driver.findElement(By.className("ant-input")).sendKeys("演示");
			 driver.findElement(By.className("exhibition-body-titles")).click();
			 driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div[2]/button")).click();
			// driver.get("https://coding.imooc.com/");
			 try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  loginhandle=new LoginHandle(driver);
		
	  }
	
	@Test
	public void TestLoginSucccess(){
		loginhandle.Senduser("13129562261");
		loginhandle.SendPassword("czh123");
		loginhandle.ClickLogin();
	}
	 @AfterMethod
	  public void afterMethod() {
		  try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	  }



	  @AfterClass
	  public void afterClass() {
			  driver.close();
	  }
	
}
