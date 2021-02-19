package test.czh.handle;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import test.czh.page.FirstPage;
import test.czh.page.LoginPage;

public class LoginHandle {
	static Logger logger=Logger.getLogger(LoginHandle.class);

	public LoginPage loginpage;
	public FirstPage firstpage;
	
	
	public LoginHandle(WebDriver driver){
		loginpage=new LoginPage(driver);
	}
	
	public void Senduser(String user) {
		logger.info("你输入账号为"+user);
		loginpage.GetUserElement().sendKeys(user);
	}
	
	public void  SendPassword(String password) {
		logger.info("你输入密码为"+password);

		loginpage.GetPassWord().sendKeys(password);
	}
	

	
	public void ClickLogin(){
		logger.info("你开始点击登录按钮");

		loginpage.GeteLoginButton().click();
	}
	
	public void ClickchooseExhibition() {
		logger.info("你选择了展会");

		firstpage.GetchooseExhibitionElement().click();
	}
	
	public void SendExhibitionInput(String exhibitionInput) {
		logger.info("你输入展会为"+exhibitionInput);

		firstpage.GetExhibitionInputElement().sendKeys(exhibitionInput);
	}
	
	
	public void ClickExhibitionbutton(){
		firstpage.GetchooseExhibitionbuttonElement().click();
	}
	
	public String GetUserText(){
		String username=loginpage.GetUserInfoElement().getText();
		return username;
	}
	
}
