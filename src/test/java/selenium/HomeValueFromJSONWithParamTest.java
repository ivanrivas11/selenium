package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import core.BaseTest;
import pages.FormSubmittedPage;
import pages.HomePage;

public class HomeValueFromJSONWithParamTest extends BaseTest {
	
	@Parameters("pathJSON")
	@Test
	public void testValueFromJSON(String pathJSON) throws InterruptedException{
		
		//Home page object
		HomePage home = new HomePage(getDriver());
		String value = "password";
		
		Thread.sleep(1000);
		
		//Operacion de enviar password
		home.sendPasswordFromJson(pathJSON, value);

		Thread.sleep(1000);
	}
}
