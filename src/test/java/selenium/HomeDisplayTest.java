package selenium;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import core.BaseTest;
import pages.FormSubmittedPage;
import pages.HomePage;

public class HomeDisplayTest extends BaseTest {
	
	@Test
	public void testHome() throws InterruptedException, IOException{
		
		//Variables
		String path = "C:\\Users\\jandi\\OneDrive\\Escritorio\\CursoSelenium\\selenium\\src\\main\\resources\\capturas\\";
		String name = "MessageFrom.jpg";
		
		
		//Home page object
		HomePage home = new HomePage(getDriver());
		
		Thread.sleep(1000);
		
		//Operacion de enviar texto
		home.sendTxtInput("Curso Selenium");

		Thread.sleep(1000);
		
		//Operacion de click
		home.clickSubmitButton();
		
		//FormSubmitted page object
		FormSubmittedPage form = new FormSubmittedPage(getDriver());
		
		//Validacion de mensaje presente
		//Assertion
		Assert.assertTrue(form.isMessagePresent());
		
		//Tomar captura de pantalla
		form.takeScreenShot(path, name);
		
		Thread.sleep(1000);
	}
}
