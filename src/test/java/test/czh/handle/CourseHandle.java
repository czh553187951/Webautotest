package test.czh.handle;

import org.apache.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import test.czh.page.CoursePage;

public class CourseHandle {
	static Logger logger=Logger.getLogger(ByHandle.class);
	public CoursePage coursePage;
	public WebDriver driver;
	
	public CourseHandle(WebDriver driver){
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
	
	public int GetCarnum() {
		int CartNum;
		try {
			CartNum=Integer.parseInt(coursePage.GetCarnumtElement().getText());
		}catch(Exception e) {
			CartNum=0;
		}
		return CartNum;
	
	}
	
	public String Gettitle() {
		
		return driver.getTitle();
	

	}
	
	public void SetCookie() {
		 String value="UzODAyM2MyYmM4MWFlYjk4YTg2NDZkNzUwM2Y0OGYAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAOTY2Nzc4OAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAGEyMjVlYmNlODc5Yzc1YmQ5OGEzZDM0NGRjY2Y2YmNmmkY7YJpGO2A%3DMj";
		 driver.manage().deleteAllCookies();
		 Cookie cookie=new Cookie("apsid",value,".imooc.com","/",null);
		 driver.manage().addCookie(cookie);

	}
}
