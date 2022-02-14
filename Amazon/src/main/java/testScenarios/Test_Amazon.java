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
import objects.LoginAmzon;

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
	@Test(priority = 0)
	@Parameters("email")
	public void email(String email) {
		LoginAmzon   obj = new LoginAmzon(driver);
		obj.em(email);
	}

	@Test(priority = 1)
	@Parameters("Password")
	public void password(String Password) {
		LoginAmzon	obj = new LoginAmzon(driver);
		obj.psw(Password);
	}
		
	
	@Test(priority = 2)
	@Parameters("search")
	public void HomePageOperation1(String search) {
		AmazonHomePage page1=new AmazonHomePage(driver);
		page1.SearchInAmazon(search);
	}

	@Test(priority = 3)
	public void HomePageOperation2() {
//		AmazonHomePage page2=new AmazonHomePage(driver);
//		page2.selectProduct();
		objectrepo=new AmazonHomePage(driver);
		objectrepo.selectProduct();
	}
	
	
	@Test(priority = 4)
	public void addToCartOperation() {
		AmazonProductPage page2=new AmazonProductPage(driver);
		page2.addToCart();
	}
	
	@AfterClass
	public void driverInstance2() {
		driver.quit();
	}
}