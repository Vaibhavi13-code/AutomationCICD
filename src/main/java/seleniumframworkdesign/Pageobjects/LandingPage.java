package seleniumframworkdesign.Pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenumframework.AbstractComponents.AbstarctComponents;

public class LandingPage extends AbstarctComponents {
	WebDriver driver;
	 public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}

	//WebElement useremail = driver.findElement(By.id("userEmail"));
	//Page Factory
	@FindBy(id="userEmail")
	WebElement useremail;
	@FindBy(id="userPassword")
	WebElement userPassword;
	@FindBy(id="login")
	WebElement loginbtn;
	
	public void loginApp(String email,String pass)
	{
		useremail.sendKeys(email);
		userPassword.sendKeys(pass);
		loginbtn.click();
	}
	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	
	@FindBy(css =".mb-3")
	List<WebElement> products;
	public void Goto()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
}
