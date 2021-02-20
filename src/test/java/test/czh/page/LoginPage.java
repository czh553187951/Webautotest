package test.czh.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	public WebElement GetUserElement() {
		return GetElement("username");
		
	}
	
	
	public WebElement GetPassWord() {
		return GetElement("password");
		
	}
	
/*	public WebElement GetSenvenElement() {
		return GetElement("senven");
		
	}
	*/
	public WebElement GeteLoginButton() {
		return GetElement("LoginElement");
		
	}

	public WebElement GetUserIPngElement() {
		return GetElement("headpng");
		
	}
	
	public WebElement GetUserInfoElement() {
		return GetElement("UserNameElement");
		
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
