package test.czh;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import test.czh.handle.ByHandle;

public class Testerro {
	public WebDriver driver;
	public ByHandle byhandle;

	
	@Test
	public void GetCourseTitle() {
		

		System.out.println(byhandle);
		String a=byhandle.GetTitle();
		System.out.println(a);
	}
	
}
