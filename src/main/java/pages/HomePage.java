package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Locators
	
	//Text Input
	WebElement txtBox = driver.findElement(By.name("my-text"));
	
	//Submit button
	WebElement submitButton = driver.findElement(By.cssSelector("button"));
	
	//Password
	WebElement password = driver.findElement(By.name("my-password"));
	
	//Textarea
	WebElement textArea = driver.findElement(By.name("my-textarea"));
		
	
			
	//Methods
	//Enviar texto al elemento Text Input
	public void sendTxtInput(String texto) {
		System.out.println("Trying to enter text "+texto+"...");
		txtBox.sendKeys(texto);
		System.out.println("Text entered!");
	}
	
	//Enviar texto al elemento Password
	public void sendPasswordFromJson(String path, String value) {
		System.out.println("Trying to enter text "+value+"...");
		password.sendKeys(getValueJSON(path, value));
		System.out.println("Password entered!");
	}
		
	//Enviar texto al elemento TextArea
	public void sendTextAreaFromExcel(String path, String value) {
		System.out.println("Trying to enter text "+value+"...");
		textArea.sendKeys(getValueFromExcel(path, value));
		System.out.println("Text area entered!");
	}
		
	//Click en boton de submit
	public void clickSubmitButton() {
		System.out.println("Trying to click Submit button");
		submitButton.click();
		System.out.println("Button Clicked!");
	}

}
