package test.czh;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Logintest {

	public WebDriver driver;
	public void IntDriver(){
		System.setProperty("webdriver.chrome.driver", "D:\\study\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get("http://www.imooc.com/user/newlogin/from_url/1005/");
//		 driver.get("http://www.baidu.com/");
		
	}
	
	public void UserLogin(){
		/*System.setProperty("webdriver.chrome.driver", "D:\\study\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 driver.get("http://www.imooc.com/user/newlogin/from_url/1005/");*/
		String UserElement ="email";
		String UserGetBy ="name";
		String PassElement ="password";
		String PassGetBy ="name";
		String LoginElement ="moco-btn-red";
		String LoginGetBy ="className";
		String UserName ="13129562261";
		String PassWord ="czh19930419";
		String HeadELement="header-avator";
		String HeadGetBy="id";
		String UserNameElement="text-ellipsis";
		String UserNameGet="className";
	//	WebElement userElement=driver.findElement(By.name(UserElement));
		WebElement userElement=GetElement(UserGetBy, UserElement);
		WebElement PasswordElement=GetElement(PassGetBy, PassElement);
		WebElement LoginButtonElement=GetElement(LoginGetBy, LoginElement);
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
		WebElement UserPng=GetElement(HeadGetBy, HeadELement);
		Actions MoseAction=new Actions(driver);
		MoseAction.moveToElement(UserPng).perform();
		String username=GetElement(UserNameGet, UserNameElement).getText();
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
	
	
	
	public By GetByLocal(String getby,String getValue){
		if(getby.equals("id")){
		return	By.id(getValue);
		}
		else if (getby.equals("name")){
			return	By.name(getValue);
		}
		else if (getby.equals("className")){
			return	By.className(getValue);
		}
		else {
			return	By.xpath(getValue);
		}
	}
	
	
	public WebElement GetElement(String getby,String getValue){
		By test=	this.GetByLocal(getby, getValue);
		System.out.println(test);
		System.out.println(driver);

		WebElement Element= driver.findElement(test);
		return Element;
	}
	public static void main(String[] args){
		// TODO Auto-generated method stub
			
		Logintest lt=new Logintest();
		lt.IntDriver();
		lt.UserLogin();
		
		
	}

}
