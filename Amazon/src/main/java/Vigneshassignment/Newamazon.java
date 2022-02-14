package Vigneshassignment;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Newamazon {

	WebDriver driver;

	@BeforeClass
	public void driverInstance1() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String URL = "https://www.amazon.in/";
		driver.navigate().to(URL);
	}
	@Test
	@Parameters("search")
	public void test1(String search) {
		Actions actions = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		actions.click(we).perform();
		
		
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(search);
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		
	    driver.findElement(By.xpath("//span[text()='Hauser XO Ball Pen (Pack of 50), Blue,black,red']")).click();
		
		String handle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		handles.remove(handle);
		String newhandle1 = handles.iterator().next();
		driver.switchTo().window(newhandle1);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		WebElement we2=driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));   
		js1.executeScript("arguments[0].scrollIntoView();",we2);
		we2.click();
	}
	@AfterClass
	public void driverInstance2() {
		driver.quit();
	}
}

