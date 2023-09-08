package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import core.BasePage;

public class FormSubmittedPage extends BasePage {

	public FormSubmittedPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Locators
	//Mensaje de from submitted
	WebElement mesg = driver.findElement(By.id("message"));
	
	//Methods
	
	public boolean isMessagePresent() {
		return mesg.isDisplayed();
	}

}
