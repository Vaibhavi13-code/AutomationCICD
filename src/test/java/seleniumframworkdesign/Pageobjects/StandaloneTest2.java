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

public class StandaloneTest2 {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		LandingPage lp = new LandingPage(driver);
//		driver.findElement(By.id("userEmail")).sendKeys("swara@gmail.com");
//		driver.findElement(By.id("userPassword")).sendKeys("Swa@1234");
//		driver.findElement(By.id("login")).click();
		lp.loginApp("swara@gmail.com", "Swa@1234");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
//		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		ProdCatlogPage pd = new ProdCatlogPage(driver);
		List<WebElement> products = pd.getproductList();
		String prodList[]= {"ADIDAS ORIGINAL"};
		for (int i=0;i<prodList.length;i++)
		{
			String prodname = prodList[i];
			//System.out.println(prodname);
//		WebElement prod = products.stream().filter(product->
//		product.findElement(By.cssSelector("b")).getText().equals(prodname)).findFirst().orElse(null);
		//prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
			pd.addtoCart(prodname);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
//		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		}
		
		driver.findElement(By.xpath("//button[contains(@routerlink,'cart')]")).click();
		for (int i=0;i<prodList.length;i++)
		{
			String prodname = prodList[i];
		List<WebElement> CartList = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = CartList.stream().anyMatch(CartPrd->CartPrd.getText().equalsIgnoreCase(prodname));
		Assert.assertTrue(match);
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".totalRow button")));
		driver.findElement(By.cssSelector(".totalRow button")).click();
	   
//		driver.findElement(By.cssSelector(".form-group input")).sendKeys("India");
//		driver.findElement(By.xpath("//div[@class='form-group']//span[text()=' India']")).click();
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder= 'Select Country']")),"India").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.xpath("//button[contains(@class,'ta-item')][2]")).click();
		driver.findElement(By.cssSelector(" .actions a")).click();
		String confirmMsg = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirmMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		driver.close();
		
	}
}
