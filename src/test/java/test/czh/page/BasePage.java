package test.czh.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import test.czh.util.ProUtil;

public class BasePage {
	public WebDriver driver;
	public BasePage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public WebElement GetElement(String key){

		WebElement Element= driver.findElement(this.GetByLocal(key));
		return Element;
	}
	
	public By GetByLocal(String key){
		ProUtil ProU=new ProUtil("element.properties");
		String Locator=ProU.GetPro(key);
		String LocatorBy=Locator.split(">")[0];
		String LocatorValue=Locator.split(">")[1];
		if(LocatorBy.equals("id")){
		return	By.id(LocatorValue);
		}
		else if (LocatorBy.equals("name")){
			return	By.name(LocatorValue);
		}
		else if (LocatorBy.equals("className")){
			return	By.className(LocatorValue);
		}
		else {
			return	By.xpath(LocatorValue);
		}
	}

}
