package test.czh;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public WebDriver driver;
	public void IntDriver(){
		System.setProperty("webdriver.chrome.driver", "D:/study/新建文件夹/Czh/包以及驱动/包以及驱动/chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		driver.get("http://www.imooc.com");
		driver.manage().window().maximize();
	}
	public void LoginScript(){
		String username="13129562261";
		String emailElement="email";
		String userBy="id";
		String userpass="czh19930419";
		String passElement="password";
		String buttonElement="btn-red";
		WebElement user=driver.findElement()
	}
	
	public By bystr(String by,String local){
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
