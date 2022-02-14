package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginAmzon {	
WebDriver driver;

public LoginAmzon(WebDriver driver) {
	this.driver = driver;
}

By signinButton = By.xpath("(//*[text()='Hello, Sign in'])[1]");
By signin = By.xpath("(//*[text()='Sign in'])[1]");
By emailID = By.xpath("//input[@name='email']");
By continueButton = By.xpath("//input[@id='continue']");
By password = By.xpath("//input[@name='password']");
By submit = By.xpath("//input[@id='signInSubmit']");

public void em(String email) {
	driver.findElement(signinButton).click();
	driver.findElement(emailID).sendKeys(email);
	driver.findElement(continueButton).click();
}

public void psw(String Password) {
	driver.findElement(password).sendKeys(Password);
	driver.findElement(submit).click();

}

}