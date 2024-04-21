package com.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetails {
	
	WebDriver driver;
	
	@FindBy(id="product_attribute_75_5_31_96")
	WebElement processorSelection;
	@FindBy(name="product_attribute_75_6_32")
	WebElement ramSelection;
	@FindBy(name="product_attribute_75_8_35")
	WebElement softwareSelection;
	@FindBy(name="addtocart_75.EnteredQuantity")
	WebElement changeQuantity;
	@FindBy(id="add-to-cart-button-75")
	WebElement addToCart;
	@FindBy(partialLinkText="Shopping cart")
	WebElement shoppingCart;
	
	public ProductDetails(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void processorSelection()
	{
		processorSelection.click();
	}
	
	public void selectRAM()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement element = driver.findElement(By.name("product_attribute_75_6_32")); 
        js.executeScript("arguments[0].scrollIntoView();", element);

		ramSelection.click();
	}
	
	public void softwareSelection()
	{
		softwareSelection.click();
	}
	
	public void changeQuantity(String quantity)
	{
		changeQuantity.clear();
		changeQuantity.sendKeys(quantity);
	}
	
	public void addToCart()
	{
		addToCart.click();
	}
	
	public void shoppingCart()
	{
		shoppingCart.click();
	}
}
