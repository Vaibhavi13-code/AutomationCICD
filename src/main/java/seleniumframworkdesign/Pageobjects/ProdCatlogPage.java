package seleniumframworkdesign.Pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Selenumframework.AbstractComponents.AbstarctComponents;

public class ProdCatlogPage extends AbstarctComponents{
	WebDriver driver;
	public ProdCatlogPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}

	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	
	@FindBy(css =".mb-3")
	List<WebElement> products;
	
	@FindBy(css =".ng-animating")
	WebElement spiner;
	
	By productby = By.cssSelector(".mb-3");
	By AddtoCart = By.cssSelector(".card-body button:last-of-type");
	By toastmsg = By.cssSelector("#toast-container");
	public List<WebElement> getproductList()
	{
		WaitforElement(productby);
		return products;
	}
	public WebElement getproductByname(String prodname)
	{
		WebElement prod = getproductList().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(prodname)).findFirst().orElse(null);
		return prod;
	}
	public void addtoCart(String prodname)
	{
		WebElement prod = getproductByname(prodname);
		prod.findElement(AddtoCart).click();
		WaitforElement(toastmsg);
		WaitforElementtDisappear(spiner);
	}
}
