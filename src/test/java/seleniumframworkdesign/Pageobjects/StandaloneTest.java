package seleniumframworkdesign.Pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;
import seleniumframworkdesign.Tests.BaseTest;

public class StandaloneTest {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		LandingPage lp = new LandingPage(driver);
		lp.loginApp("swara@gmail.com", "Swa@1234");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		ProdCatlogPage pd = new ProdCatlogPage(driver);
		Cart C = new Cart(driver);
		List<WebElement> products = pd.getproductList();
		String prodList[]= {"ADIDAS ORIGINAL"};
		for (int i=0;i<prodList.length;i++)
		{
			String prodname = prodList[i];
			pd.addtoCart(prodname);
		}
		
		for (int i=0;i<prodList.length;i++)
		{
		String prodname = prodList[i];
		Boolean match = C.ValidateCartproduct(prodname);
		Assert.assertTrue(match);
		}
		String confirmMsg  = C.finalcart("India");
		
		Assert.assertTrue(confirmMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
//		
		driver.close();
		
	}
}
