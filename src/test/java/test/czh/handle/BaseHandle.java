package test.czh.handle;

import org.openqa.selenium.WebDriver;

public class BaseHandle {

	public WebDriver driver;
	public BaseHandle(WebDriver driver) {
		this.driver = driver;
	}
	
	public String GetTitle() {
		return driver.getTitle();
	}
}
