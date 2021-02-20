package test.czh.handle;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import test.czh.page.LoginPage;
import test.czh.runcase.LoginCase;

public class LoginHandle {
	
	public LoginPage loginpage;
	static Logger logger=Logger.getLogger(LoginHandle.class);

	
	public LoginHandle(WebDriver driver){
		loginpage=new LoginPage(driver);
	}
	
	public void Senduser(String user) {
		logger.info("你输入的用户名为："+user);
		loginpage.GetUserElement().sendKeys(user)
		;
	}
	
	public void SendPassword(String password) {
		logger.info("你输入的用户密码为："+password);
		loginpage.GetPassWord().sendKeys(password);
	}
	
/*	public void ClickSenvenBox(){
		loginpage.GetSenvenElement().click();
	}
	*/
	public void ClickLogin(){
		logger.info("开始点击点击登录按钮");
		loginpage.GeteLoginButton().click();
	}
	
	public String GetUserText(){
		String username=loginpage.GetUserInfoElement().getText();
		return username;
	}
	
}
