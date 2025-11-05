package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.JavaScriptUtils;

public class ContactUsPage extends Page {

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//*[contains(text(),\" Contact us\")]")
	private WebElement contactUSLink;

	@FindBy(xpath = "//h2/following::*[text()='Get In Touch']")
	private WebElement getInTouchText;

	@FindBy(xpath = "//div[@class='status alert alert-success']")
	private WebElement successMSG;

	@FindBy(name = "name")
	private WebElement nameTextBox;

	@FindBy(name = "email")
	private WebElement emailTextBox;

	@FindBy(name = "subject")
	private WebElement subjectTextBox;

	@FindBy(name = "submit")
	private WebElement submitButton;
	
	public boolean isLoginPageLoaded() {
		return waitForPageLoad(driver);
	}
	
	public void clickContactUSLink() {
			contactUSLink.click();
	}

	public boolean isGetInTouchTextVisible() {
		return waitForElementToVisible(driver, getInTouchText).isDisplayed();
	}

	private ContactUsPage enterName(String name) {
		nameTextBox.sendKeys(name);
		return this;
	}

	private ContactUsPage enterEmail(String email) {
		emailTextBox.sendKeys(email);
		return this;
	}

	private ContactUsPage enterSubject(String subject) {
		enterText(subjectTextBox, subject);
		return this;
	}

	private void acceptAlert() {
		if (isAlertDisplayed(driver) != null) {
			isAlertDisplayed(driver).accept();
		}else {
			System.out.println("Alert Not Displayed");
		}
	}

	private ContactUsPage clickSubmit() {
		clickElement(submitButton);
		acceptAlert();
		return this;
	}
	
	public void fillAndSubmitContactUsForm() {
		//Fluent Page Object Model
		//Concept: An extension of POM that makes method calls more readable and chained, 
		//often mimicking natural language.

		//Implementation: Page Object methods return the object of the next page in the 
		//workflow or the current page object (this) after performing an action.

		//Benefit: Enables method chaining, leading to more concise, readable, and 
		//expressive test scripts. 
		//For example: loginPage.enterUsername("user").enterPassword("pass").clickLoginButton().verifyHomePageTitle();	
	enterName("madhukar").enterEmail("mm@gmail.com").enterSubject("test automation").clickSubmit();
	}
	
	public String getSuccessMSG() {
		return successMSG.getText();
	}
}
