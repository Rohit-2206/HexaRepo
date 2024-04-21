package com.pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Categories {

	
	//Declaration
	@FindBy(linkText="Computers")
	WebElement computersLink;
	@FindBy(xpath="(//a[contains(text(),'Desktops')])[3]")
	WebElement categoryDesktop;
	
	
	
	//Initialization
	
	public Categories(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Utilization

    public void computersLink() {
    	computersLink.click();
    }
	
	public void categoryDesktop()
	{
		categoryDesktop.click();
	}
}
