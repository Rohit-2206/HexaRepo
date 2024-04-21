package com.day1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DAY2WaitLinkTextandPartialURLMatches {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ECS FINANCIAL\\eclipse-workspace\\Hexa_Testing\\src\\test\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com");
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		wait.until(ExpectedConditions.urlMatches("https://demowebshop.tricentis.com"));
		driver.manage().window().maximize();
		
		// Click Log-In Button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Log in']")));
		// driver.findElement(By.xpath("//a[text()='Log in']")).click();
		driver.findElement(By.linkText("Log in")).click();
		
		
		wait.until(ExpectedConditions.urlMatches("https://demowebshop.tricentis.com/login"));
		// Enter Email ID and Password and click submit button
		driver.findElement(By.id("Email")).sendKeys("mcvg89@gmail.com");
		
		driver.findElement(By.id("Password")).sendKeys("123456");
		
		driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
		
		
		// Click on Computers
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Computers")));
		driver.findElement(By.linkText("Computers")).click();
		// driver.findElement(By.xpath("(//a[contains(text(),'Computers')])")).click();
		
		
		// Click on Desktop under computers
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Desktops")));
		driver.findElement(By.xpath("(//a[contains(text(),'Desktops')])[3]")).click();
		
		
		// Click on Build your own expensive computer
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='details']//a[contains(text(),'Build your own expensive computer')]")));
		driver.findElement(By.xpath("//div[@class='details']//a[contains(text(),'Build your own expensive computer')]")).click();

		
		// Change processor to fast from Medium
		wait.until(ExpectedConditions.elementToBeClickable(By.id("product_attribute_74_5_26_82")));
		driver.findElement(By.id("product_attribute_74_5_26_82")).click();
		
		
		// Check Software Check boxes
		driver.findElement(By.id("product_attribute_74_8_29_88")).click();
		
		driver.findElement(By.id("product_attribute_74_8_29_90")).click();
		
		
		// Change quantity from 1 to 2
		wait.until(ExpectedConditions.elementToBeClickable(By.name("addtocart_74.EnteredQuantity")));
		driver.findElement(By.name("addtocart_74.EnteredQuantity")).clear();
		driver.findElement(By.name("addtocart_74.EnteredQuantity")).sendKeys("2");
		
		
		// Click on add to cart button
		wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button-74")));
		driver.findElement(By.id("add-to-cart-button-74")).click();
		
		wait.until(ExpectedConditions.urlMatches("https://demowebshop.tricentis.com/cart"));
		driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]")).click();
		
		driver.findElement(By.id("termsofservice")).click();
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("billing-address-select")));
		Select obSelect = new Select(driver.findElement(By.id("billing-address-select")));
		obSelect.selectByVisibleText("New Address");
	
		Select sel = new Select(driver.findElement(By.id("BillingNewAddress_CountryId")));
		sel.selectByVisibleText("United States");
		
		driver.findElement(By.id("BillingNewAddress_City")).sendKeys("London");
		
		driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("MM00");
		
		driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("788919");
		
		driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("11881919190");

		driver.findElement(By.xpath("//div[@class='buttons']//input[@type='button' and @title='Continue']")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.id("PickUpInStore")));
		driver.findElement(By.id("PickUpInStore")).click();
		
		driver.findElement(By.xpath("(//div[@class='buttons']//input[@type='button' and @title='Continue'])[2]")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='button-1 payment-method-next-step-button' and @onclick='PaymentMethod.save()']")));
		driver.findElement(By.xpath("//input[@class='button-1 payment-method-next-step-button' and @onclick='PaymentMethod.save()']")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='button-1 payment-info-next-step-button' and @onclick='PaymentInfo.save()']")));
		driver.findElement(By.xpath("//input[@class='button-1 payment-info-next-step-button' and @onclick='PaymentInfo.save()']")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='button-1 confirm-order-next-step-button' and @onclick='ConfirmOrder.save()']")));
		driver.findElement(By.xpath("//input[@class='button-1 confirm-order-next-step-button' and @onclick='ConfirmOrder.save()']")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='buttons']//input[@type='button' and @class='button-2 order-completed-continue-button']")));
		driver.findElement(By.xpath("//div[@class='buttons']//input[@type='button' and @class='button-2 order-completed-continue-button']")).click();
	
		wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("@gmail.com")));
		driver.findElement(By.partialLinkText("@gmail.com")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Orders')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Orders')]")).click();
		
		TakesScreenshot t=(TakesScreenshot)driver;
		 
		File src=t.getScreenshotAs(OutputType.FILE);//will create screenshot in source path
		 
		File f=new File("C:\\Users\\ECS FINANCIAL\\Desktop\\Training\\Screenshot3.jpeg");
		 
		FileUtils.copyFile(src, f);
	}

}
