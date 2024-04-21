package com.day1;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day3Amazon {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ECS FINANCIAL\\eclipse-workspace\\Hexa_Testing\\src\\test\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		wait.until(ExpectedConditions.urlMatches("https://www.amazon.in/"));
		driver.manage().window().maximize();
		
		driver.findElement(By.name("field-keywords")).sendKeys("iphone");
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Apple iPhone 14 (128 GB) - Purple')]")); 
        js.executeScript("arguments[0].scrollIntoView();", element);
        
        String parentWindowHandle = driver.getWindowHandle();
        // driver.findElement(By.xpath("//span[contains(text(),'Add to Cart')]")).click();
        
        driver.findElement(By.xpath("//span[contains(text(),'Apple iPhone 14 (128 GB) - Purple')]")).click();
        Set<String> allWindowHandles = driver.getWindowHandles();
        
        for (String handle : allWindowHandles) {
            // Confirm if the handle does not match the parent window
            if (!handle.equals(parentWindowHandle)) {
                // Switch to the new window context
                driver.switchTo().window(handle);
                
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='add-to-cart-button'])[2]")));
                driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[2]")).click();
                
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='a-button-input'])[23]")));
                driver.findElement(By.xpath("(//input[@class='a-button-input'])[23]")).click();
                
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='proceedToRetailCheckout']")));
                driver.findElement(By.xpath("//input[@name='proceedToRetailCheckout']")).click();
                
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='email']")));
                driver.findElement(By.xpath("//input[@name='email']")).sendKeys("9360577488");
                
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='continue']")));
                driver.findElement(By.xpath("//input[@id='continue']")).click();
                		
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='a-button-input'])[2]")));
                driver.findElement(By.xpath("(//input[@class='a-button-input'])[2]")).click();
            
                Thread.sleep(20000);
                
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='a-button-input']")));
                driver.findElement(By.xpath("//input[@class='a-button-input']")).click();
                
                driver.findElement(By.xpath("(//input[@class='a-button-input'])[2]")).click();
                
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='ppw-instrumentRowSelection']")));
                driver.findElement(By.xpath("//input[@name='ppw-instrumentRowSelection']")).click();
              
                // wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(text(),'Enter card details'))[1]]")));
                // driver.findElement(By.xpath("(//a[contains(text(),'Enter card details'))[1]]")).click();
                
                // wait.until(ExpectedConditions.elementToBeClickable(By.linkText("#")));
                // driver.findElement(By.linkText("#")).click();
              
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@class='apx-add-pm-trigger-common-image']")));
                driver.findElement(By.xpath("//img[@class='apx-add-pm-trigger-common-image']")).click();
              
                driver.switchTo().frame(0);
                
                driver.findElement(By.name("addCreditCardNumber")).sendKeys("12345678900");
                
                driver.findElement(By.xpath("(//span[@class='a-button-inner'])[11]")).click();
            }
        }
		
	}

}
