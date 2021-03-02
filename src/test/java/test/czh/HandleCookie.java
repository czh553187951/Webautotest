package test.czh;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandleCookie {
	
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
		/*	 driver.findElement(By.id("js-signin-btn")).click();
			 Thread.sleep(2000);
			 driver.findElement(By.name("email")).sendKeys("13129562261");
			 driver.findElement(By.name("password")).sendKeys("czh19930419");
			 driver.findElement(By.className("moco-btn")).click();
			
*/
				 }
			

	 
	  @Test
	  public void test01() {
		  
		  try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			 Set<Cookie> cookies=driver.manage().getCookies();
			 for(Cookie cookie:cookies) {
				 System.out.println("---->"+cookie);
				 if(cookie.getName().equals("apsid")) {
					 System.out.println("登录成功");
				 } 
			 }
	  }
	  
	  @Test
	  public void test02() {
		  String value="UzODAyM2MyYmM4MWFlYjk4YTg2NDZkNzUwM2Y0OGYAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAOTY2Nzc4OAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAGEyMjVlYmNlODc5Yzc1YmQ5OGEzZDM0NGRjY2Y2YmNmmkY7YJpGO2A%3DMj";
		  System.out.println("登录失败");
			 Set<Cookie> cookies=driver.manage().getCookies();
			 for(Cookie cookie:cookies) {
				 System.out.println("---->"+cookie);
				 if(cookie.getName().equals("apsid")) {
					 System.out.println("登录成功");
				 } 
				 else {
					 Cookie cookie1=new Cookie("apsid",value);
				 }
			 }
	  }
	  
	  
	  @AfterClass
	  public void afterClass() {
			  driver.close();
			  
	  }
}
