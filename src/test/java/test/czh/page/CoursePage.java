package test.czh.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CoursePage extends BasePage{
	
	public CoursePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public WebElement GetAddCartElement() {
		return GetElement("add");
		
	}
	
	public WebElement GetCarnumtElement() {
		return GetElement("crat_num");
		
	}
	
	public WebElement GetBuynowElement() {
		return GetElement("buynow");
		
	}
	
	public WebElement GetCartElement() {
		return GetElement("cart");
		
	}
	
	public WebElement GetCartSureElement() {
		return GetElement("cart_already");
		
	}

	
	public boolean GetUserIsLogin() {
		return GetCookie("apsid");
		
	}
	

	
}
