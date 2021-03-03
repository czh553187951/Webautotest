package test.czh.runcase;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import test.czh.handle.ByHandle;
import test.czh.handle.CourseHandle;


public class Coursecase extends BaseCase{
	
	static Logger logger=Logger.getLogger(Coursecase.class);
	
	public WebDriver driver;
	CourseHandle coursehandle;
	ByHandle  byHandle;
	@Parameters({"url","browser"})
	@BeforeClass
	  public void beforeClass(String url,String browser) throws Exception {
			 PropertyConfigurator.configure("log4j.properties");
			 
			 logger.info("初始化浏览器");
			 logger.info("访问目标页");
			 driver=GetDriver(browser);
			 driver.get(url);
			
			 Thread.sleep(2000);
			 byHandle=new ByHandle(driver);
			 Thread.sleep(2000);

		
	  }
	
	//默认无法从testngxml中取到值时使用@Optional("")来取值
	@Parameters({"coursename"})
	@Test
	public void TestAddCouseSucccesss(String coursename) throws Exception{
	logger.info("runtest1");
		  String course_title = byHandle.GetTitle();
		  boolean flag = course_title.contains(coursename);
		  Assert.assertEquals(flag, true);
		  byHandle.clickAddcart();
		
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
