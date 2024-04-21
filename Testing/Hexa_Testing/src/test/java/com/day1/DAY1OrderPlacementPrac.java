package com.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DAY1OrderPlacementPrac {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ECS FINANCIAL\\eclipse-workspace\\Hexa_Testing\\src\\test\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com");
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		/*
		Register Page :-
		driver.findElement(By.id("gender-male")).click();
		driver.findElement(By.id("FirstName")).sendKeys("HH");
		driver.findElement(By.id("LastName")).sendKeys("Karan");
		driver.findElement(By.id("Email")).sendKeys("mcvg89@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("123456");
		driver.findElement(By.name("ConfirmPassword")).sendKeys("123456");
		
		driver.findElement(By.xpath("//div[@class='buttons']//input[@type='submit']")).click();
		*/
		
		// Click Log-In Button
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		
		// Enter Email ID and Password and click submit button
		Thread.sleep(2000);
		driver.findElement(By.id("Email")).sendKeys("mcvg89@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("123456");
		driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
		
		// Click on Computers
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[contains(text(),'Computers')])")).click();
		
		// Click on Desktop under computers
		Thread.sleep(2000);	
		driver.findElement(By.xpath("(//a[contains(text(),'Desktops')])[3]")).click();
		
		// Click on Build your own expensive computer
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='details']//a[contains(text(),'Build your own expensive computer')]")).click();

		// Change processor to fast from Medium
		Thread.sleep(2000);
		driver.findElement(By.id("product_attribute_74_5_26_82")).click();
		
		// Check Software Check boxes
		Thread.sleep(2000);
		driver.findElement(By.id("product_attribute_74_8_29_88")).click();
		driver.findElement(By.id("product_attribute_74_8_29_90")).click();
		
		// Change quantity from 1 to 2
		Thread.sleep(2000);
		driver.findElement(By.name("addtocart_74.EnteredQuantity")).clear();
		driver.findElement(By.name("addtocart_74.EnteredQuantity")).sendKeys("2");
		
		// Click on add to cart button
		driver.findElement(By.id("add-to-cart-button-74")).click();
		
		
		driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]")).click();
		driver.findElement(By.id("termsofservice")).click();
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Select obSelect = new Select(driver.findElement(By.id("billing-address-select")));
		obSelect.selectByVisibleText("New Address");
		
		Select sel = new Select(driver.findElement(By.id("BillingNewAddress_CountryId")));
		sel.selectByVisibleText("United States");
		
		driver.findElement(By.id("BillingNewAddress_City")).sendKeys("London");
		driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("MM00");
		driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("788919");
		driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("11881919190");
		
		
		driver.findElement(By.xpath("//div[@class='buttons']//input[@type='button' and @title='Continue']")).click();

		Thread.sleep(2000);
		driver.findElement(By.id("PickUpInStore")).click();
		driver.findElement(By.xpath("(//div[@class='buttons']//input[@type='button' and @title='Continue'])[2]")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='button-1 payment-method-next-step-button' and @onclick='PaymentMethod.save()']")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='button-1 payment-info-next-step-button' and @onclick='PaymentInfo.save()']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='button-1 confirm-order-next-step-button' and @onclick='ConfirmOrder.save()']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='buttons']//input[@type='button' and @class='button-2 order-completed-continue-button']")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class = 'accounts']")).click();
			
	}

}
