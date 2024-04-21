package com.day1;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day3URL1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ECS FINANCIAL\\eclipse-workspace\\Hexa_Testing\\src\\test\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		
		driver.get("https://www.amazon.in/");

		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.urlMatches("https://www.amazon.in/"));
		driver.manage().window().maximize();

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
		Thread.sleep(2000);

		List<WebElement> suggestionElements = driver.findElements(By.xpath("//div[@class = 's-suggestion-container']"));
		Thread.sleep(4000);

		int count = suggestionElements.size();

		for (int i = 0; i < count; i++) {
			WebElement ele = suggestionElements.get(i);
			Thread.sleep(4000);
			String str = ele.getText();
			Thread.sleep(4000);
			System.out.println(str);
			
			if(str.equals("iphone 15 pro max")) 
			{
				ele.click();
				break;
			}
		}
		
		/*
		Actions a = new Actions(driver);
		a.doubleClick(driver.findElement(By.xpath("//button[contains(text(),'Double-Click Me To See Alert')]"))).perform();
		
		Alert act = driver.switchTo().alert();
		System.out.println(act.getText());
		act.accept();
		
		// Find the WebElement first
		//WebElement element = driver.findElement(By.xpath("//span[contains(text(),'right click me')]"));

		// Perform the right-click action
		a.contextClick(driver.findElement(By.xpath("//span[contains(text(),'right click me')]"))).perform();
	    */
	}

}
