package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import core.BaseTest;
import pages.FormSubmittedPage;
import pages.HomePage;

public class HomeGetDataFromExcelTest extends BaseTest {

	@Test
	public void testValueFromExcel() throws InterruptedException{
		
		//Home page object
		HomePage home = new HomePage(getDriver());
		
		String value = "area";
		String path = "C:\\Users\\jandi\\OneDrive\\Escritorio\\CursoSelenium\\selenium\\src\\main\\resources\\selenium\\data.xlsx";
		
		Thread.sleep(1000);
		
		//Operacion de enviar password
		home.sendTextAreaFromExcel(path, value);

		Thread.sleep(1000);
	}

}
