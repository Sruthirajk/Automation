package Vigneshassignment;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Allbrowser {

public WebDriver driver;
static WebDriverWait wait1;

@BeforeClass
 public void beforeClass()
 {
 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
  driver = new ChromeDriver();
  driver.manage().window().maximize();
  wait1 = new WebDriverWait(driver,10);
  driver.navigate().to("https://www.amazon.in/");
  WebElement signin= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Sign in'])[2]")));
  signin.click();
  }

@Test
  @Parameters({"userid","password"})//,"sPassword"
 public void f(String Username,String password)//, String Password
 {
wait1 = new WebDriverWait(driver,10);
WebElement mail=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='email']")));
 mail.sendKeys(Username);
 WebElement cont=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@id='continue'])[2]")));
 cont.click();
 WebElement pswd=driver.findElement(By.xpath("//*[@id='ap_password']"));
 pswd.sendKeys(password);
 driver.findElement(By.xpath("//*[@id='signInSubmit']")).click();

 }
  @AfterMethod
  public void afterMethod()
  {
 //driver.close();
  }
}
