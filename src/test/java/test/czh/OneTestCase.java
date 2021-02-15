package test.czh;

import org.testng.annotations.Test;

import com.google.common.io.Files;

import test.czh.util.ProUtil;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterTest;


public class OneTestCase {
	
	public WebDriver driver;
  @Test
  public void f() {
	  ProUtil pro=new ProUtil("user.properties");
		String username;
		String password;
		String user;

		int Lines=pro.Getlines();
		for(int i=0;i<Lines;i++){
		
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
			userElement.clear();
			PasswordElement.clear();
		}
  }
  
  public void TakeScreenShot(){
	  //获取当前时间
	  SimpleDateFormat sdf=new SimpleDateFormat("yyyy_mm_dd_HH_mm_ss");
	  String curTime =sdf.format(new Date());
	  //获取当前类名
	  String curClassName=this.getClass().getName();
	  //获取当前路径
	  String curPath=System.getProperty("user.dir");
	  String pngPath = curClassName+"_"+curTime+".png";
	  //截图
	 File ScRFile= ((RemoteWebDriver)driver).getScreenshotAs(OutputType.FILE);
	 try {
		Files.copy(ScRFile, new File(curPath+"\\"+pngPath));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
  }
  
  @BeforeClass
  public void beforeClass() {
	 
	  System.setProperty("webdriver.chrome.driver", "D:\\study\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get("http://www.imooc.com/user/newlogin/from_url/1005/");

  }

  @AfterClass
  public void afterClass() {
	  driver.close();

  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("beforeTest");

	 
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("afterTest");

  }

  @BeforeMethod
  public void BeforeMethod() {
	  System.out.println("BeforeMethod");

  }
  @AfterMethod
  public void AfterMethod() {
	  System.out.println("AfterMethod");

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
}
