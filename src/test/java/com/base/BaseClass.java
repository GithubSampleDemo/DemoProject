package com.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	public static WebDriver driver;
	

	public  WebDriver launchBrowser(String browserName, String urlOfWebsite) {
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(urlOfWebsite);
		
		return driver;
	}

	public  void putValueInTextBox(WebElement element, String value) {
		if (element.isDisplayed() && element.isEnabled()) {
			element.clear();
			element.sendKeys(value);
		}
	}

	public  void clickOnElement(WebElement element) {
		if (element.isDisplayed() && element.isEnabled()) {
			element.click();
		}
	}

	public  void closeBrowser() {
		driver.quit();
	}

	
	public  String getTitleOfPage() {
		 return driver.getTitle();
	}
}
