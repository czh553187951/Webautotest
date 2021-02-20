package test.czh.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
	

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	public WebElement GetInputexhibition() {
		return GetElement("Inputexhibition");
		
	}
	
	
	public WebElement Getchooseexhibition() {
		return GetElement("chooseexhibition");
		
	}
	
	public WebElement GetLoginButton() {
		return GetElement("LoginButton");
		
	}
	

}
