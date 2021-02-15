package test.czh;

import org.testng.annotations.Test;

import junit.framework.Assert;
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
	  driver.findElement(By.id("password")).sendKeys("111111111");
	  //Assert.assertEquals(1, 2);
	  logger.error("错误密码信息");

	  System.out.println("第四个case");

  }
  @Test
  public void f5() {
	  driver.findElement(By.id("password")).sendKeys("111111111");

	  System.out.println("第五个case");

  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
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

		  driver.close();
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
