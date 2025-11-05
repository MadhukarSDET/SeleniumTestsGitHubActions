package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.JavaScriptUtils;

public abstract class Page extends JavaScriptUtils {
	protected WebDriver driver;

	public Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement waitForElementToBeClickable(WebDriver driver, WebElement locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public WebElement waitForElementToVisible(WebDriver driver, WebElement locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		return wait.until(ExpectedConditions.visibilityOf(locator));
	}
	
	protected Alert isAlertDisplayed(WebDriver driver) {
		try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        return wait.until(ExpectedConditions.alertIsPresent());
	    } catch (TimeoutException e) {
	        System.out.println("Alert not displayed");
	        return null;
	    }
		
	}
	
	public void clickElement(WebElement locator) {
		locator.click();
	}
	
	public void enterText(WebElement locator,String textToEnter) {
		locator.sendKeys(textToEnter);
	}
	
	public void clearTextBox(WebElement locator) {
		try{
			locator.clear();
		}catch (Exception e) {
			System.out.println("");
		}
	}
	
	public void handleAlert() {
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	
}
