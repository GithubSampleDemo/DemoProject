package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.LoginPage;

public class LoginTest extends LoginPage {
	
	@BeforeMethod
	public void setup() {
		launchBrowser("chrome", "https://www.facebook.com/");
	}
	
	@Test(dataProvider = "loginData")
	
	public void testLoginWithInCorrectCredentials(String testCaseNo, String username, String password) {
		LoginPage p = new LoginPage();
		p.loginWithCredentials(username, password);
		String title = p.getTitleOfPage();
		if (testCaseNo.equals("TC001") || testCaseNo.equals("TC002") || testCaseNo.equals("TC003")) {
			Assert.assertEquals(title, "Log in to Facebook");
		}
		else {
			Assert.assertEquals(title, "Log in to Facebook");
		}
		
	}
	
	@AfterMethod
	public void tearDown() {
		closeBrowser();
	}
	
	
	@DataProvider(name = "loginData")
	public Object[][] loginData(){
		return new Object[][]{{"TC001","dfasf","dfadfdas"},
							  {"TC002","wqewq","ewqewq"},
							  {"TC003","xczxzx","nvbnvb"},
							  {"TC004","uyuujny","wxdww"}};
		
	}
}
