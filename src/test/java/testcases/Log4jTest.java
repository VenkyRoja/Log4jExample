package testcases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

//import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.LogManager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

public class Log4jTest {
	
	
	public  WebDriver     driver;
	
	Logger log = Logger.getLogger(Log4jTest.class);
			
	//Logger log = LogManager.getLogger(Log4jTest.class.getName());
	
	
	//--------2--------------------
	@BeforeMethod
	public void setUp() {
		
		log.info("****************************** Starting test cases execution  *****************************************");
		
		System.setProperty("webdriver.gecko.driver", "/Volumes/Venky/Dev/Selenium Downloads/Drivers/geckodriver");
        
        FirefoxOptions opts = new FirefoxOptions();
        opts.addArguments("-private");
        driver = new FirefoxDriver(opts);

        
        driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		
		driver.get("https://ui.cogmento.com");
		
		
		log.info("entering application URL");
		log.warn("this just a warning message");
		log.fatal("this is just fatal error message");
		log.debug("this is debug message");

	}
	
	

	//--------3.1--------------------
	@Test
	public void loginPageTitleTest() {
		
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** loginPageTitleTest *****************************************");		
		
		String title = driver.getTitle();
		String expectedTitle = "Cogmento CRM";
		
		log.info("login page title is " + title);
		
		Assert.assertEquals(title, expectedTitle, "Title of Login Page did not match!");
		
		log.info("****************************** ending test case *****************************************");
		log.info("****************************** loginPageTitleTest *****************************************");
	}

	
	//--------3.2--------------------
	@Test
	public void lockIconTest() {		
		WebElement lockicon = driver.findElement(By.xpath("//i[@class='lock icon']"));
		
		boolean  b = lockicon.isDisplayed();
		
		Assert.assertTrue(b, "Lock icon is missing!!");
	}	

	
	//--------3.3--------------------
	@Test
	public void userIconTest() {
		
		WebElement usericon = driver.findElement(By.xpath("//i[@class='user icon']"));
		
		boolean  b = usericon.isDisplayed();
		
		Assert.assertTrue(b, "User icon is missing!!");
	}	
	
	
	//--------4--------------------
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		log.info("****************************** Browser is closed *****************************************");

	}	
	
	

}
