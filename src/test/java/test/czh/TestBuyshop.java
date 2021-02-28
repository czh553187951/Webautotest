package test.czh;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestBuyshop {

	  public WebDriver driver;
	  @BeforeClass
	  public void beforeClass() {
		  System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
			 driver = new ChromeDriver();
			 System.out.println("----------------打开浏览器----------------");
	  }
	
	  @BeforeMethod
	  public void beforeMethod() throws Exception {
		  
			 driver.get("https://coding.imooc.com/class/400.html");
			 System.out.println("----------------打开地址----------------");
			 driver.findElement(By.id("js-signin-btn")).click();
			 Thread.sleep(2000);
			 driver.findElement(By.name("email")).sendKeys("13129562261");
			 driver.findElement(By.name("password")).sendKeys("czh19930419");
			 driver.findElement(By.className("moco-btn")).click();
			 Thread.sleep(2000);

	  }
	  
	 @Test
	  public void f1() throws Exception {

		int beforenum=0;

		String CourseTitle=driver.getTitle();
		if(CourseTitle.contains("快速搞定前端JavaScript面试-慕课网")) {
			int a=1;
			System.out.println("获取课程成功！");
			try {
			 beforenum=Integer.parseInt(driver.findElement(By.className("js-cart-num")).getText());

			}catch(Exception e) {
				System.out.println("购物车数量为空!");
			}
			driver.findElement(By.className("addcart")).click();
			Thread.sleep(2000);
			String coursenum=driver.findElement(By.className("js-cart-num")).getText();
			int afternum=Integer.parseInt(coursenum);
			if(a==afternum-beforenum) {
				System.out.println("添加购物车成功！");

			}
	/*		else if(driver.findElement(By.className("alertText")).getText().contains("商品已经在购物车内")){
				System.out.println("商品已经在购物车内");
				

			}*/else {
				System.out.println("添加失败");

			}
		}
		else {
			System.out.println("找不到课程");

		}
	  }

	  @AfterMethod
	  public void afterMethod() {
		  
		  try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  System.out.println("----------------方法执行完毕----------------");

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
