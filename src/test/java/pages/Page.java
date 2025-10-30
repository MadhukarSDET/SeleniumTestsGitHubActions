package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
	protected WebDriver driver;

	public Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void clickElement(WebElement locator) {
		locator.click();
	}
	
	public void clearTextBox(WebElement locator) {
		try{
			locator.clear();
		}catch (Exception e) {
			System.out.println("");
		}
	}
}
