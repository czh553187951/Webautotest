package test.czh.handle;

import org.openqa.selenium.WebDriver;

import test.czh.page.HomePage;

public class HomeHandle {

	public HomePage homePage;
	
	public HomeHandle(WebDriver driver){
		homePage=new HomePage(driver);
	}
	
	public void Sendexhibition(String exhibition) {
		homePage.GetInputexhibition().sendKeys(exhibition)
		;
	}
	
	public void Clickchooseexhibition(){
		homePage.Getchooseexhibition().click();
	}
	
	public void ClickLoginbutton(){
		homePage.GetLoginButton().click();
	}
	
}
