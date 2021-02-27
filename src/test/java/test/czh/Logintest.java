package test.czh;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import test.czh.util.ProUtil;

//测试case 和框架无关
public class Logintest {

	public WebDriver driver;
	public void IntDriver(){
		System.setProperty("webdriver.chrome.driver", "D:\\study\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get("http://www.imooc.com/user/newlogin/from_url/1005/");
//		 driver.get("http://www.baidu.com/");
		
	}
	
	@Test
	public void UserLogin(){
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
		ProUtil pro=new ProUtil("user.properties");
		String username;
		String password;
		String user;

		int Lines=pro.Getlines();
		for(int i=0;i<Lines;i++){
			IntDriver();

		   	user=pro.GetPro("user"+i);
			 username=user.split(">")[0];
			 password=user.split(">")[1];
			
			WebElement userElement=GetElement("username");
			WebElement PasswordElement=GetElement("password");
			WebElement LoginButtonElement=GetElement("LoginElement");
			userElement.sendKeys(username);
			PasswordElement.sendKeys(password);
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
			String usernameinfo=GetElement("UserNameElement").getText();
			if(usernameinfo.equals("慕妹9464969")){
				System.out.println("登录成功");
			}else{
				System.out.println("用户信息不匹配"+username);
			}
			
			
			}catch(Exception e){
				System.out.println("登录失败");
			}
			
			driver.close();
		}
		
		
	}
	
	
	//定位元素方法封装
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


}
