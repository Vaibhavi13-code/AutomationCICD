package seleniumframworkdesign.Pageobjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;


import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import junit.framework.Assert;
import seleniumframworkdesign.Tests.BaseTest;

public class SubmitOrder extends BaseTest{

	@Test
	public void submitorder() throws InterruptedException, IOException {
	
//		System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");
//		WebDriver driver = new ChromeDriver(options);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//driver.get("https://rahulshettyacademy.com/client");
		//driver.manage().window().maximize();
		LandingPage lp = launchApplication();
		
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
