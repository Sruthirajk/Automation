package testScenarios;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import objects.AmazonHomePage;
import objects.AmazonProductPage;

public class Test_Amazon {

	WebDriver driver;
	AmazonHomePage objectrepo;
	
	@BeforeClass
	@Parameters("url")
	public void driverInstance1(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(url);
	}
	
	@Test
	@Parameters("search")
	public void HomePageOperation1(String search) {
		AmazonHomePage page1=new AmazonHomePage(driver);
		page1.SearchInAmazon(search);
	}
	
	@Test
	public void HomePageOperation2() {
//		AmazonHomePage page2=new AmazonHomePage(driver);
//		page2.selectProduct();
		objectrepo=new AmazonHomePage(driver);
		objectrepo.selectProduct();
	}
	
	@Test
	public void addToCartOperation() {
		AmazonProductPage page2=new AmazonProductPage(driver);
		page2.addToCart();
	}
	
	@AfterClass
	public void driverInstance2() {
		driver.quit();
	}
}