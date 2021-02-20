package test.czh.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import test.czh.runcase.LoginCase;
import test.czh.util.ProUtil;

//page定位元素基类
public class BasePage {
	public WebDriver driver;
	static Logger logger=Logger.getLogger(BasePage.class);

	public BasePage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public WebElement GetElement(String key){
		
		WebElement Element= driver.findElement(this.GetByLocal(key));
		return Element;
	}
	
	//通过配置文件中的key值获取对应定位方式和定位值
	public By GetByLocal(String key){
		ProUtil ProU=new ProUtil("element.properties");
		logger.info("你的定位信息的key为"+key);
		String Locator=ProU.GetPro(key);
		String LocatorBy=Locator.split(">")[0];
		String LocatorValue=Locator.split(">")[1];
		logger.info("你的定位信息的方式为"+LocatorBy);
		logger.info("你的定位信息的值为"+LocatorValue);
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

	
	
	public void MoveToElement(WebElement ToElement){
		
		Actions MoseAction=new Actions(driver);
		MoseAction.moveToElement(ToElement).perform();
	}
}
