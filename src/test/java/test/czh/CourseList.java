package test.czh;

import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CourseList {
		
	public WebDriver driver;
	
	 @BeforeClass
	  public void beforeClass() throws Exception {
		     System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
			 driver = new ChromeDriver();
			 driver.get("https://zhan.zzxes.com.cn/#/");
			 Thread.sleep(2000);
			 driver.findElement(By.className("ant-input")).sendKeys("演示");
			 driver.findElement(By.className("exhibition-body-titles")).click();
			 driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[2]/div[2]/button[1]")).click();
			 driver.findElement(By.id("username")).sendKeys("13129562261");
			 driver.findElement(By.id("password")).sendKeys("czh123");
			 driver.findElement(By.xpath("//body/div[2]/div[3]/div[5]")).click();
	

			// driver.get("https://coding.imooc.com/");
			 try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	  }
	/* @Test
	  public void f1() throws Exception {
		List<String> listString= ListCourseTitle();
		for(int i=0;i<listString.size();i++){
			
			//String courseTitle=courseName.getText();
			//courseName.click();
			//driver.navigate().back();
			
			driver.findElement(By.xpath("//div[contains(text(),'"+listString.get(i)+"')]")).click();
			Thread.sleep(1000);
			
	    	driver.navigate().back();
			System.out.println(listString.get(i));
			
			Thread.sleep(1000);
				 
		}
		  //Assert.assertEquals(1, 2);
		 
		  System.out.println("第一个case");
	  }
	*/
	 @Test
	 public void test2() throws InterruptedException{
		List<WebElement> courseList =driver.findElements(By.className("new-mian-ui-contain-server-box-rightBox-title"));
		 for(int i=0;i<courseList.size();i++){
			 courseList.get(i).click();
			Thread.sleep(1000);
		    driver.navigate().back();
			Thread.sleep(1000);
		    courseList =driver.findElements(By.className("new-mian-ui-contain-server-box-rightBox-title"));
		 }
	 }
	 
	 public List<String> ListCourseTitle(){
		 List<String> ListCourseTitle=new ArrayList<String>();
		List<WebElement> courseList =driver.findElements(By.className("new-mian-ui-contain-server-box-rightBox-title"));

		 for(WebElement courseName:courseList){
				String courseTitle=courseName.getText();
				 ListCourseTitle.add(courseTitle);
		 }
		return ListCourseTitle;
		 
	 }

	  @BeforeMethod
	  public void beforeMethod() {
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

	  @BeforeTest
	  public void beforeTest() {
	  }

	  @AfterTest
	  public void afterTest() {
	  }

	
	
	
}
