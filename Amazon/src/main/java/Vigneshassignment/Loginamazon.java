package Vigneshassignment;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Loginamazon {

	WebDriver driver;
	static WebDriverWait wait;

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
		
		
		
		wait = new WebDriverWait(driver, 10);
		WebElement search1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='twotabsearchtextbox']")));
		search1.sendKeys(search);
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		WebElement pen = wait
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Hauser XO Ball Pen (Pack of 50), Blue,black,red']")));
		pen.click();


		
		String handle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		handles.remove(handle);
		String newhandle1 = handles.iterator().next();
		driver.switchTo().window(newhandle1);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='add-to-cart-button']")));
		js1.executeScript("arguments[0].scrollIntoView();",add);
		add.click();
	}
	@AfterClass
	public void driverInstance2() {
		driver.quit();
	}
}

