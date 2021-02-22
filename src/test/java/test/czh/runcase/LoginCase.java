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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import test.czh.TestNGListenerScreen;
import test.czh.handle.HomeHandle;
import test.czh.handle.LoginHandle;


@Listeners(TestNGListenerScreen.class)

public class LoginCase extends BaseCase {
	static Logger logger=Logger.getLogger(LoginCase.class);
	public WebDriver driver;
	public LoginHandle loginhandle;
	public HomeHandle homeHandle;
	
	@Parameters({"url","exhibitionname","browser"})
	@BeforeClass
	  public void beforeClass(String url,String exhibitionname,String browser) throws Exception {
			 PropertyConfigurator.configure("log4j.properties");
			 driver=GetDriver(browser);
			 logger.info("初始化浏览器");
			 driver.get(url);
			 logger.info("访问首页");
			 Thread.sleep(2000);
			 loginhandle=new LoginHandle(driver);
			 homeHandle= new HomeHandle(driver);
			 homeHandle.Sendexhibition(exhibitionname);
			 homeHandle.Clickchooseexhibition();
			 homeHandle.ClickLoginbutton();
		  /* loginhandle.Sendexhibition("演示");
			 loginhandle.Clickchooseexhibition();
			 loginhandle.ClickLoginbutton();
			 driver.findElement(By.className("ant-input")).sendKeys("演示");
			 driver.findElement(By.className("exhibition-body-titles")).click();
			 driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div[2]/button")).click();*/
			 try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		
	  }
	
	//默认无法从testngxml中取到值时使用@Optional("")来取值
    @Parameters({"user","password"})
	@Test
	public void TestLoginSucccess(String user,String password) throws Exception{
		logger.info("runtest1");
		loginhandle.Senduser(user);
		loginhandle.SendPassword(password);
		loginhandle.ClickLogin();
		Thread.sleep(2000);
		String username=loginhandle.GetUserText();
		Assert.assertEquals(username, "陈镇华1");
	}
	
	@Test
	public void TestLoginuserError() throws Exception{
		logger.info("runtest2");
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
