package test.czh;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import test.czh.util.ProUtil;

public class Logintest {

	public WebDriver driver;
	public void IntDriver(){
		System.setProperty("webdriver.chrome.driver", "D:\\study\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get("http://www.imooc.com/user/newlogin/from_url/1005/");
//		 driver.get("http://www.baidu.com/");
		
	}
	
	public void UserLogin(String UserName,String PassWord){
		/*System.setProperty("webdriver.chrome.driver", "D:\\study\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 driver.get("http://www.imooc.com/user/newlogin/from_url/1005/");*/
		/*String UserElement ="email";
		String UserGetBy ="name";
		String PassElement ="password";
		String PassGetBy ="name";
		String LoginElement ="moco-btn-red";
		String LoginGetBy ="className";
		String HeadELement="header-avator";
		String HeadGetBy="id";
		String UserNameElement="text-ellipsis";
		String UserNameGet="className";*/
	//	WebElement userElement=driver.findElement(By.name(UserElement));
	//	String UserName ="13129562261";
	//	String PassWord ="czh19930419";
		String usename;
		IntDriver();
		
		WebElement userElement=GetElement("username");
		WebElement PasswordElement=GetElement("password");
		WebElement LoginButtonElement=GetElement("LoginElement");
		userElement.sendKeys(UserName);
		PasswordElement.sendKeys(PassWord);
		LoginButtonElement.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try{
		WebElement UserPng=GetElement("HeadELement");
		Actions MoseAction=new Actions(driver);
		MoseAction.moveToElement(UserPng).perform();
		String username=GetElement("UserNameElement").getText();
		if(username.equals("慕妹9464969")){
			System.out.println("登录成功");
		}else{
			System.out.println("用户信息不匹配"+username);
		}
		
		
		}catch(Exception e){
			System.out.println("登录失败");
		}
		
		driver.close();
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
	
	public void GetBylocator(String key){
		
	}
	public WebElement GetElement(String key){

		WebElement Element= driver.findElement(this.GetByLocal(key));
		return Element;
	}
	public static void main(String[] args){
		// TODO Auto-generated method stub
			
		Logintest lt=new Logintest();
		lt.IntDriver();
		lt.UserLogin("13129562261","");
		
		
	}

}
