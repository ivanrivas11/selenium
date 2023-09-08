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

public class HomeValueFromExcelWithParamTest extends BaseTest {
	
	@Parameters("pathExcel")
	@Test
	public void testValueFromExcel(String pathExcel) throws InterruptedException{
		
		//Home page object
		HomePage home = new HomePage(getDriver());
		
		String value = "area";
		
		Thread.sleep(1000);
		
		//Operacion de enviar password
		home.sendTextAreaFromExcel(pathExcel, value);

		Thread.sleep(1000);
	}

}
