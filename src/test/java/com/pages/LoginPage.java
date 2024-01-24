package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class LoginPage extends BaseClass {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='email']")
	WebElement userNameTextbox;
	
	@FindBy(id = "pass")
	WebElement passwordTextbox;
	
	@FindBy(xpath = "//button[text()='Log in']")
	WebElement logInButton;
	
	
	public void passValueInUserTextBox(String value) {
		putValueInTextBox(userNameTextbox, value);
		
	}
	
	public void passValueInPassTextBox(String value) {
		putValueInTextBox(passwordTextbox, value);
		
	}
	
	public void clickOnLoginButton() {
		clickOnElement(logInButton);
	}
	
	public void loginWithCredentials(String user, String password) {
		putValueInTextBox(userNameTextbox, user);
		putValueInTextBox(passwordTextbox, password);
		clickOnElement(logInButton);
	}
}
