package com.day1;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DAY2WaitActionMoveToSelectScreenShotParc {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ECS FINANCIAL\\eclipse-workspace\\Hexa_Testing\\src\\test\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
		driver.get("https://demowebshop.tricentis.com");
		driver.manage().window().maximize();
		
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		wait.until(ExpectedConditions.titleContains("Demo Web Shop"));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Log in']")));
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("Email")));
		driver.findElement(By.id("Email")).sendKeys("mcvg89@gmail.com");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("Password")));
		driver.findElement(By.id("Password")).sendKeys("123456");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='submit'])[2]")));
		driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
		
		Actions a = new Actions(driver);
		WebElement computersLink = driver.findElement(By.xpath("//a[contains(text(),'Computers')]"));

		// Move to the element
		a.moveToElement(computersLink).perform();
		/*
		wait.until(ExpectedConditions.urlMatches("https://demowebshop.tricentis.com/"));
			
		
		// Click on Computers
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[contains(text(),'Computers')])")).click();
		
		// Click on Desktop under computers
		Thread.sleep(2000);	
		driver.findElement(By.xpath("(//a[contains(text(),'Desktops')])[3]")).click();
		
		Select sel = new Select(driver.findElement(By.id("products-orderby")));
		List<WebElement>alloptions = sel.getOptions();
		int count = alloptions.size();
		for(int i=0;i<count;i++) {
			System.out.println(alloptions.get(i).getText());
		}
		
		TakesScreenshot t=(TakesScreenshot)driver;//Downcasting
		 
		File src=t.getScreenshotAs(OutputType.FILE);//will create screenshot in source path
		 
		File f=new File("C:\\Users\\ECS FINANCIAL\\Desktop\\Training\\Screenshot2.jpeg");
		 
		FileUtils.copyFile(src, f);
		*/
		System.out.println(driver.getTitle());
	
				
	}

}
