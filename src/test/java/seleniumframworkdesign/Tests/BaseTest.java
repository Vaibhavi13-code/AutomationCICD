package seleniumframworkdesign.Tests;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import seleniumframworkdesign.Pageobjects.LandingPage;


public class BaseTest {

	public WebDriver driver;
	public WebDriver initializeDriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\seleniumframworkdesign\\ressources\\Globaldata.properties");
		prop.load(fis);
	    String browserName = prop.getProperty("browser");
		
			System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
			 ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		return driver;
	}
	@BeforeTest
	public LandingPage launchApplication() throws IOException
	{
		driver = initializeDriver();
		LandingPage lp = new LandingPage(driver);
		lp.Goto();
		return lp;
	}
   @AfterTest
   public void teardown()
  {
	 driver.close();
  }
}
