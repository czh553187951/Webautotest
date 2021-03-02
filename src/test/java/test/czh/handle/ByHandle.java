package test.czh.handle;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import test.czh.page.CoursePage;
import test.czh.page.LoginPage;

public class ByHandle {
	
	public WebDriver driver;

	public CoursePage coursePage;
	static Logger logger=Logger.getLogger(ByHandle.class);


	public ByHandle(WebDriver driver){
		this.driver=driver;
		coursePage=new CoursePage(driver);
	}
	
	
	public void clickAddcart() {
		
		coursePage.GetAddCartElement().click();

	}

	public void clickbuynow() {
		
		coursePage.GetBuynowElement().click();
	

	}
	
	public void clickCartSure() {
		
		coursePage.GetCartSureElement().click();
	

	}
	public void clickcart() {
		
		coursePage.GetCartElement().click();
	

	}
	
	public String GetCourseTitle() {
		
	return driver.getTitle();
	}
	
	public int GetCarnum() {
		int CartNum;
		try {
			CartNum=Integer.parseInt(coursePage.GetCarnumtElement().getText());
		}catch(Exception e) {
			CartNum=0;
		}
		return CartNum;
	
	}
	
	public void SetCookie() {
		 String value="UzODAyM2MyYmM4MWFlYjk4YTg2NDZkNzUwM2Y0OGYAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAOTY2Nzc4OAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAGEyMjVlYmNlODc5Yzc1YmQ5OGEzZDM0NGRjY2Y2YmNmmkY7YJpGO2A%3DMj";
		 driver.manage().deleteAllCookies();
		 Cookie cookie=new Cookie("apsid",value,".imooc.com","/",null);
		 driver.manage().addCookie(cookie);

	}

}
