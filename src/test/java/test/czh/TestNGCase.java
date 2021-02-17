package test.czh;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterTest;


@Listeners(TestNGListenerScreen.class)
public class TestNGCase {
	private static Logger logger=Logger.getLogger(TestNGCase.class);
	public WebDriver driver;

	
  @Test
  public void f1() {
	  logger.debug("邮箱信息");
	 driver.findElement(By.name("email")).sendKeys("111111111");
	  //Assert.assertEquals(1, 2);
	  System.out.println("第一个case");
  }
  @Test
  public void f2() {
	  logger.debug("邮箱信息");
	driver.findElement(By.name("email")).sendKeys("111111111");
	  System.out.println("第二个case");

  }
  @Test
  public void f3() {
	  driver.findElement(By.name("password")).sendKeys("111111111");
	  System.out.println("第三个case");

  }
  @Test
  public void f4() {
		logger.error("错误的密码");
	  driver.findElement(By.id("password")).sendKeys("111111111");
	  //Assert.assertEquals(1, 2);


	  System.out.println("第四个case");

  }
  @Test
  public void f5() {
	  logger.error("错误的密码D");
	  driver.findElement(By.id("password")).sendKeys("111111111");

	  System.out.println("第五个case");

  }
  
  
  public void SendToEmail(){
	  
	 SimpleEmail email=new SimpleEmail();
	 email.setHostName("smtp.qq.com");
	 email.setAuthentication("553187951@qq.com", "pwdruawuiidnbcde");
	 try {
		email.setFrom("553187951@qq.com");
		email.addTo("553187951@163.com");
		email.setSubject("autoemail");
		email.setMsg("this is test");
		email.send();
		logger.debug("发送成功");
	} catch (EmailException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
	  
	  try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }

  @BeforeClass
  public void beforeClass() {
		PropertyConfigurator.configure("log4j.properties");

	  System.setProperty("webdriver.chrome.driver", "D:\\study\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get("http://www.imooc.com/user/newlogin/from_url/1005/");
  }

  @AfterClass
  public void afterClass() {
	  	SendToEmail();
		  driver.close();
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
