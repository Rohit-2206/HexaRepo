package com.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Products {
	
	WebDriver driver;
	//Declaration
	
	@FindBy(name="products-orderby")
	WebElement sortList;
	
	@FindBy(linkText="Simple Computer")
	WebElement selectProduct;
	
	//Initialization
	
	public Products(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	//Utilization

	public void sortList()
	{
		Select sel = new Select(driver.findElement(By.id("products-orderby")));
		sel.selectByVisibleText("Price: Low to High");
	}
	
	public void selectProduct() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Simple Computer')]")); 
        js.executeScript("arguments[0].scrollIntoView();", element);
        Thread.sleep(3000);
        
        driver.findElement(By.linkText("Simple Computer")).click();
	}
	
	
}
