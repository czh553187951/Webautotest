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

import test.czh.runcase.LoginCase;

public class Rent {
	
	public WebDriver driver;

	  @BeforeClass
	  public void beforeClass() {
			PropertyConfigurator.configure("log4j.properties");

		  System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
			 driver = new ChromeDriver();
	  }

	  @BeforeMethod
	  public void beforeMethod() {
		  LoginCase logint=new LoginCase();
		  
	  }
	  
	  @Test
	  public void test1() {
		  int a=0;
		  int beforenum=0;
		  String CourseTitle=driver.getTitle();
		  if(CourseTitle.contains("Python3+Selenium3开发 Web和接口自动化的分布式测试框架-慕课网")) {
			  System.out.println("获取标题成功");
			  try {
			 beforenum=Integer.parseInt(driver.findElement(By.className("js-cart-num")).getText());
			  }catch(Exception e) {
				  System.out.println("购物车数量为空");

			  }
			  driver.findElement(By.className("js-addcart")).click();
			  try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  String courNum=driver.findElement(By.className("js-cart-num")).getText();
			  int afternum=Integer.parseInt(courNum);
			  a=afternum-beforenum;
			  if(a==1) {
				  System.out.println("添加成功");

			  }
		  }
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
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		  System.out.println("方法执行完毕");
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
