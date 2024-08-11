package Selenumframework.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstarctComponents {
		
	protected WebDriver driver;
	WebDriverWait wait;
 protected AbstarctComponents(WebDriver driver) {
		this.driver=driver;
	wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));	
	}

 	
public void WaitforElement(By findby) {
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
}
public void WaitforElementtDisappear(WebElement ele) {
	
	wait.until(ExpectedConditions.invisibilityOf(ele));
}
}
