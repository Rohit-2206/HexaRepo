package com.pom;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCart {
	
	WebDriver driver;
	
	@FindBy(id="termsofservice")
	WebElement checkBox;
	@FindBy(id="checkout")
	WebElement checkOut;
	@FindBy(id="BillingNewAddress_City")
	WebElement addressCity;
	@FindBy(id="BillingNewAddress_Address1")
	WebElement addressLine1;
	@FindBy(id="BillingNewAddress_ZipPostalCode")
	WebElement postalCode;
	@FindBy(id="BillingNewAddress_PhoneNumber")
	WebElement contact;
	@FindBy(xpath="//input[@title='Continue']")
	WebElement submit;
	@FindBy(xpath="//label[contains(text(),'In-Store Pickup')]")
	WebElement pickUpCheckBox;
	@FindBy(xpath="(//input[@class='button-1 new-address-next-step-button' and @title='Continue'])[2]")
	WebElement submit2;
	@FindBy(xpath="//input[@class='button-1 shipping-method-next-step-button']")
	WebElement submit3;
	@FindBy(xpath="//input[@class='button-1 payment-method-next-step-button']")
	WebElement submit4;
	@FindBy(xpath="//input[@class='button-1 payment-info-next-step-button']")
	WebElement submit5;
	@FindBy(xpath="//input[@class='button-1 confirm-order-next-step-button']")
	WebElement submit6;
	@FindBy(xpath="//input[@class='button-2 order-completed-continue-button']")
	WebElement submit7;
	@FindBy(partialLinkText="@gmail.com")
	WebElement account;
	@FindBy(linkText="Orders")
	WebElement ordersPage;
	@FindBy(xpath="(//input[@class='button-2 order-details-button'])[1]")
	WebElement latestOrder;
	
	public ShoppingCart(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public void termsCheckBox()
	{
		checkBox.click();
	}
	
	public void checkOut()
	{
		checkOut.click();
	}
	
	public void newAddress() 
	{
		Select obSelect = new Select(driver.findElement(By.id("billing-address-select")));
		obSelect.selectByVisibleText("New Address");
		
		Select sel = new Select(driver.findElement(By.id("BillingNewAddress_CountryId")));
		sel.selectByVisibleText("United States");
	}
	public void addressCity(String str)
	{
		addressCity.sendKeys(str);
	}

	public void addressLine1(String str)
	{
		addressLine1.sendKeys(str);
	}
	
	public void postalCode(String str)
	{
		postalCode.sendKeys(str);
	}
	public void contact(String str) 
	{
		contact.sendKeys(str);
	}
	public void submit()
	{
		submit.click();
	}
	/*
	public void pickUpBox()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		pickUpCheckBox.click();
	}
	*/
	
	public void submit2() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		submit2.click();
	}
	public void submit3()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		submit3.click();
	}
	public void submit4()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		submit4.click();
	}
	public void submit5()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		submit5.click();
	}
	public void submit6()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		submit6.click();
	}
	public void submit7()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		submit7.click();
	}
	
	public void accountClick()
	{
		account.click();
	}
	public void orders()
	{
		ordersPage.click();
	}
	public void latestOrder()
	{
		latestOrder.click();
	}
	public void scroll()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String scrollDown = "window.scrollBy(0,350)";
		js.executeScript(scrollDown);
	}
	
	public void screenShot() throws IOException
	{
		TakesScreenshot t=(TakesScreenshot)driver;
		 
		File src=t.getScreenshotAs(OutputType.FILE);
		 
		File f=new File("C:\\Users\\ECS FINANCIAL\\Desktop\\Rohit\\Orders.jpeg");
		 
		FileUtils.copyFile(src, f);
	}
	
}
