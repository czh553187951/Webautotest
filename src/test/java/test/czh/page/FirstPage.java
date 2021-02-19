package test.czh.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FirstPage  extends BasePage{
	
	
	public FirstPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	public WebElement GetExhibitionInputElement() {
		return GetElement("ExhibitionInput");
		
	}
	
	public WebElement GetchooseExhibitionElement() {
		return GetElement("chooseExhibition");
		
	}
	
	public WebElement GetchooseExhibitionbuttonElement() {
		return GetElement("chooseExhibitionbutton");
		
	}
	
	
}
