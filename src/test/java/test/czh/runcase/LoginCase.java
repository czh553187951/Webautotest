package test.czh.runcase;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import test.czh.TestNGListenerScreen;
import test.czh.handle.LoginHandle;


@Listeners(TestNGListenerScreen.class)

public class LoginCase {
	static Logger logger=Logger.getLogger(LoginCase.class);

	
	public WebDriver driver;
	public LoginHandle loginhandle;
	@BeforeClass
	  public void beforeClass() throws Exception {
		
		 	 loginhandle=new LoginHandle(driver);
			 PropertyConfigurator.configure("log4j.properties");
			 logger.info("初始化浏览器");
		     System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
			 driver = new ChromeDriver();
			 logger.info("打开化浏览器");
			 driver.get("https://zhan.zzxes.com.cn/#/");
			 Thread.sleep(2000);
			 loginhandle.SendExhibitionInput("演示");
		//	 driver.findElement(By.className("ant-input")).sendKeys("演示");
			 loginhandle.ClickchooseExhibition();
		//	 driver.findElement(By.className("exhibition-body-titles")).click();
			 loginhandle.ClickExhibitionbutton();
		//	 driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div[2]/button")).click();
			// driver.get("https://coding.imooc.com/");
			 try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 
		
	  }
	
	@Test
	public void TestLoginSucccess() throws Exception{
		 logger.info("开始执行case1");
		loginhandle.Senduser("13129562261");
		loginhandle.SendPassword("czh123");
		loginhandle.ClickLogin();
		Thread.sleep(2000);
		String username=loginhandle.GetUserText();
		Assert.assertEquals(username, "陈镇华1");
	}
	
	@Test
	public void TestLoginuserError() throws Exception{
		logger.info("开始执行case2");
		loginhandle.Senduser("131295622611");
		loginhandle.SendPassword("czh123");
		loginhandle.ClickLogin();
		Thread.sleep(2000);
		String username=loginhandle.GetUserText();
		Assert.assertEquals(username, "陈镇华1");
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
