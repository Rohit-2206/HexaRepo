package com.pom;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Test;
public class DemoWebShopTest {

		@Test
		public void login() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ECS FINANCIAL\\eclipse-workspace\\Hexa_Testing\\src\\test\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com");
		WebDriverWait wait = new WebDriverWait(driver,10);

		wait.until(ExpectedConditions.urlMatches("https://demowebshop.tricentis.com"));
		driver.manage().window().maximize();
		
		LoginPage lp = new LoginPage(driver);
		Categories c = new Categories(driver);
		Products p = new Products(driver);
		ProductDetails pd = new ProductDetails(driver);
		ShoppingCart sc = new ShoppingCart(driver);
		
		lp.buttonLogin();
		lp.userName("mcvg89@gmail.com");
		lp.passWord("123456");
		lp.submit();
		}
		
		@Test
		public void productCategory() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ECS FINANCIAL\\eclipse-workspace\\Hexa_Testing\\src\\test\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com");
		WebDriverWait wait = new WebDriverWait(driver,10);

		wait.until(ExpectedConditions.urlMatches("https://demowebshop.tricentis.com"));
		driver.manage().window().maximize();
		
		LoginPage lp = new LoginPage(driver);
		Categories c = new Categories(driver);
		Products p = new Products(driver);
		ProductDetails pd = new ProductDetails(driver);
		ShoppingCart sc = new ShoppingCart(driver);
		
		lp.buttonLogin();
		lp.userName("mcvg89@gmail.com");
		lp.passWord("123456");
		lp.submit();
		
		c.computersLink();
		c.categoryDesktop();
		
		}
		
		@Test
		public void productSortingAndSelection() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ECS FINANCIAL\\eclipse-workspace\\Hexa_Testing\\src\\test\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com");
		WebDriverWait wait = new WebDriverWait(driver,10);

		wait.until(ExpectedConditions.urlMatches("https://demowebshop.tricentis.com"));
		driver.manage().window().maximize();
		
		LoginPage lp = new LoginPage(driver);
		Categories c = new Categories(driver);
		Products p = new Products(driver);
		ProductDetails pd = new ProductDetails(driver);
		ShoppingCart sc = new ShoppingCart(driver);
		
		lp.buttonLogin();
		lp.userName("mcvg89@gmail.com");
		lp.passWord("123456");
		lp.submit();
		
		c.computersLink();
		c.categoryDesktop();
		
		
		p.sortList();
		p.selectProduct();
		}
		
		@Test
		public void productConfigureAndCart() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ECS FINANCIAL\\eclipse-workspace\\Hexa_Testing\\src\\test\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com");
		WebDriverWait wait = new WebDriverWait(driver,10);

		wait.until(ExpectedConditions.urlMatches("https://demowebshop.tricentis.com"));
		driver.manage().window().maximize();
		
		LoginPage lp = new LoginPage(driver);
		Categories c = new Categories(driver);
		Products p = new Products(driver);
		ProductDetails pd = new ProductDetails(driver);
		ShoppingCart sc = new ShoppingCart(driver);
		
		lp.buttonLogin();
		lp.userName("mcvg89@gmail.com");
		lp.passWord("123456");
		lp.submit();
		
		c.computersLink();
		c.categoryDesktop();
		
		
		p.sortList();
		p.selectProduct();
		
		pd.processorSelection();
		pd.selectRAM();
		pd.softwareSelection();
		pd.changeQuantity("3");
		pd.addToCart();
		pd.shoppingCart();
		}
		
		
		@Test
		public void shoppingCart() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ECS FINANCIAL\\eclipse-workspace\\Hexa_Testing\\src\\test\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com");
		WebDriverWait wait = new WebDriverWait(driver,10);

		wait.until(ExpectedConditions.urlMatches("https://demowebshop.tricentis.com"));
		driver.manage().window().maximize();
		
		LoginPage lp = new LoginPage(driver);
		Categories c = new Categories(driver);
		Products p = new Products(driver);
		ProductDetails pd = new ProductDetails(driver);
		ShoppingCart sc = new ShoppingCart(driver);
		
		lp.buttonLogin();
		lp.userName("mcvg89@gmail.com");
		lp.passWord("123456");
		lp.submit();
		
		c.computersLink();
		c.categoryDesktop();
		
		
		p.sortList();
		p.selectProduct();
		
		pd.processorSelection();
		pd.selectRAM();
		pd.softwareSelection();
		pd.changeQuantity("3");
		pd.addToCart();
		pd.shoppingCart();
		
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
		
		@Test
		public void screenshot() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ECS FINANCIAL\\eclipse-workspace\\Hexa_Testing\\src\\test\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com");
		WebDriverWait wait = new WebDriverWait(driver,10);

		wait.until(ExpectedConditions.urlMatches("https://demowebshop.tricentis.com"));
		driver.manage().window().maximize();
		
		LoginPage lp = new LoginPage(driver);
		Categories c = new Categories(driver);
		Products p = new Products(driver);
		ProductDetails pd = new ProductDetails(driver);
		ShoppingCart sc = new ShoppingCart(driver);
		
		lp.buttonLogin();
		lp.userName("mcvg89@gmail.com");
		lp.passWord("123456");
		lp.submit();
		
		c.computersLink();
		c.categoryDesktop();
		
		
		p.sortList();
		p.selectProduct();
		
		pd.processorSelection();
		pd.selectRAM();
		pd.softwareSelection();
		pd.changeQuantity("3");
		pd.addToCart();
		pd.shoppingCart();
		
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
		
		sc.accountClick();
		sc.orders();
		sc.latestOrder();
		sc.scroll();
		sc.screenShot();
		}
}

