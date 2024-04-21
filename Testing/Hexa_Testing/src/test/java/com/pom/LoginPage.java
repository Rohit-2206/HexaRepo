package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(linkText = "Log in")
	WebElement button;
	@FindBy(name="Email")
	WebElement txtEmailId;
	@FindBy(name="Password")
	WebElement txtPassword;
	@FindBy(xpath="//input[@class='button-1 login-button']")
	WebElement submitButton;
	
	//Initialization

	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	
	public void buttonLogin()
	{
		button.click();
	}
	
	public void userName(String str)
	{
		txtEmailId.sendKeys(str);
	}
	
	public void passWord(String str)
	{
		txtPassword.sendKeys(str);
	}
	
	public void submit()
	{
		submitButton.click();
	}
	

	
	
}
