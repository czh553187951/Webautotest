package test.czh.handle;

import org.openqa.selenium.WebDriver;

import test.czh.page.LoginPage;

public class LoginHandle {
	
	public LoginPage loginpage;
	
	
	public LoginHandle(WebDriver driver){
		loginpage=new LoginPage(driver);
	}
	
	public void Senduser(String user) {
		loginpage.GetUserElement().sendKeys(user);
	}
	
	public void SendPassword(String password) {
		loginpage.GetPassWord().sendKeys(password);
	}
	
/*	public void ClickSenvenBox(){
		loginpage.GetSenvenElement().click();
	}
	*/
	public void ClickLogin(){
		loginpage.GeteLoginButton().click();
	}
	
	
}
