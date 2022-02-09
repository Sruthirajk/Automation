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

public class Amazonpara {

	WebDriver driver;

	@BeforeClass
	public void driverInstance1() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String URL = "https://www.amazon.in/";
		driver.navigate().to(URL);
	}

	@Test(priority = 0)
	public void test1() {
		Actions actions = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		actions.click(we).perform();
	}

	@Test(priority = 1)
	@Parameters("search")
	public void test2(String search) {
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(search);
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
	}
	
	@Test(priority = 2)
	public void test3() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
	    driver.findElement(By.xpath("//span[text()='Hauser XO Ball Pen (Pack of 50), Blue,black,red']")).click();
		
	}
	
	@Test(priority = 3)
	public void test4() throws InterruptedException {
		String handle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		handles.remove(handle);
		String newhandle1 = handles.iterator().next();
		driver.switchTo().window(newhandle1);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement we=driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));   
		js.executeScript("arguments[0].scrollIntoView();",we);
		we.click();
		Thread.sleep(5000);
	}
	
	@AfterClass
	public void driverInstance2() {
		driver.quit();
	}
	
}