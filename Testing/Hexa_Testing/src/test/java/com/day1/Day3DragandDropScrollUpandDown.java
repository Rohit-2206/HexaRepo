package com.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day3DragandDropScrollUpandDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ECS FINANCIAL\\eclipse-workspace\\Hexa_Testing\\src\\test\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demoqa.com/droppable/");
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		Actions act = new Actions(driver);
		
		WebElement src = driver.findElement(By.xpath("//div[contains(text(),'Drag Me')]"));
		WebElement target = driver.findElement(By.xpath("//p[contains(text(),'Drop here')]"));
		Thread.sleep(4000);
		// act.dragAndDrop(src, target).perform();
		
		
		JavascriptExecutor j = (JavascriptExecutor)driver;
		String scrollDown = "window.scrollBy(0,1000)";
		j.executeScript(scrollDown);
	}

}
