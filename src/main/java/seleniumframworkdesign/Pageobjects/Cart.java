package seleniumframworkdesign.Pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Selenumframework.AbstractComponents.AbstarctComponents;

public class Cart extends AbstarctComponents {

	public Cart(WebDriver driver) {
		super(driver);
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//button[contains(@routerlink,'cart')]")
	WebElement cartbtn;
	
	@FindBy(css =".totalRow button")
	WebElement cartrows;
	
	@FindBy(css =".cartSection h3")
	List<WebElement> CartList;
	
	@FindBy(css ="[placeholder= 'Select Country']")
	WebElement country;
	
	By cartrow = By.cssSelector(".totalRow button");
	By result = By.cssSelector(".ta-results");
	
	@FindBy(xpath ="//button[contains(@class,'ta-item')][2]")
	WebElement CartItem;
	
	@FindBy(css =" .actions a")
	WebElement actions;
	
	@FindBy(css =".hero-primary")
	WebElement Cmsg;
	
	public Boolean ValidateCartproduct(String prodname)
	{
		cartbtn.click();
		Boolean match = CartList.stream().anyMatch(CartPrd->CartPrd.getText().equalsIgnoreCase(prodname));
		return match;
	}
	public String finalcart(String countryName)
	{
		WaitforElement(cartrow);
		cartrows.click();
		Actions a = new Actions(driver);
		a.sendKeys(country,countryName).build().perform();
		WaitforElement(result);
		CartItem.click();
		actions.click();
	   String msg = Cmsg.getText();
		return msg;
	}
	
	
//	Actions a = new Actions(driver);
//	a.sendKeys(driver.findElement(By.cssSelector("[placeholder= 'Select Country']")),"India").build().perform();
//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
//	driver.findElement(By.xpath("//button[contains(@class,'ta-item')][2]")).click();
//	driver.findElement(By.cssSelector(" .actions a")).click();
	//String confirmMsg = driver.findElement(By.cssSelector(".hero-primary")).getText();
}
