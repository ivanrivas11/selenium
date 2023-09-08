package core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	//Web Driver
	WebDriver driver;
	
	@BeforeMethod
	public void beforeTest() {
		
		System.out.println("Setting up Selenium Driver...");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println("Driver created!");
		
		//Open browser
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
	}
	
	@AfterMethod
	public void afterTest() {
		//Close driver
		driver.close();
		
		System.out.println("Driver closed@");
	}
	
	//Get Driver
	public WebDriver getDriver() {
		return driver;
	}
}
