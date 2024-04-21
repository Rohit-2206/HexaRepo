package com.pom;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestDependsOnMethods {
	
	@Test(priority=1) 
	public void login(){
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\ECS FINANCIAL\\eclipse-workspace\\Hexa_Testing\\src\\test\\resources\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://demowebshop.tricentis.com");
	WebDriverWait wait = new WebDriverWait(driver,10);

	wait.until(ExpectedConditions.urlMatches("https://demowebshop.tricentis.com"));
	driver.manage().window().maximize();
	
	LoginPage lp = new LoginPage(driver);

	Products p = new Products(driver);
	ProductDetails pd = new ProductDetails(driver);
	ShoppingCart sc = new ShoppingCart(driver);
	
	lp.buttonLogin();
	lp.userName("mcvg89@gmail.com");
	lp.passWord("123456");
	lp.submit();
	}
	
	@Test(dependsOnMethods="login",priority=2)
	public void productCategory() {
	WebDriver driver = new ChromeDriver();
	Categories c = new Categories(driver);
	driver.get("https://demowebshop.tricentis.com");
	c.computersLink();
	c.categoryDesktop();
	}
	
	@Test(dependsOnMethods="productCategory",priority=3)
	public void productSortingAndSelection() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\ECS FINANCIAL\\eclipse-workspace\\Hexa_Testing\\src\\test\\resources\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://demowebshop.tricentis.com/desktops");

	Products p = new Products(driver);

	p.sortList();
	p.selectProduct();
	}
	
	@Test(dependsOnMethods="productSortingAndSelection",priority=4)
	public void productConfigureAndCart() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\ECS FINANCIAL\\eclipse-workspace\\Hexa_Testing\\src\\test\\resources\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://demowebshop.tricentis.com/simple-computer");

	ProductDetails pd = new ProductDetails(driver);
	
	pd.processorSelection();
	pd.selectRAM();
	pd.softwareSelection();
	pd.changeQuantity("3");
	pd.addToCart();
	pd.shoppingCart();
	}
	
	
	@Test(dependsOnMethods="login",enabled=false,priority=5)
	public void shoppingCart() throws InterruptedException{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\ECS FINANCIAL\\eclipse-workspace\\Hexa_Testing\\src\\test\\resources\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://demowebshop.tricentis.com/cart");

	ShoppingCart sc = new ShoppingCart(driver);
	
	sc.termsCheckBox();
	sc.checkOut();
	sc.newAddress();
	sc.addressCity("MMMM");
	sc.addressLine1("MMMSKAKKA");
	sc.postalCode("991991");
	sc.contact("9191999191");
	sc.submit();
	// sc.pickUpBox();
	sc.submit2();
	sc.submit3();
	sc.submit4();
	sc.submit5();
	sc.submit6();
	sc.submit7();

	}
	
	@Test(dependsOnMethods="login",priority=6)
	
	public void screenshot() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ECS FINANCIAL\\eclipse-workspace\\Hexa_Testing\\src\\test\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/cart");

		ShoppingCart sc = new ShoppingCart(driver);
		
		sc.accountClick();
		sc.orders();
		sc.latestOrder();
		sc.scroll();
		sc.screenShot();
		
	}

}
