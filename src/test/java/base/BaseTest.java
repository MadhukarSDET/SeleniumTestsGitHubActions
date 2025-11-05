package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	protected WebDriver driver;
	String browser;

	@BeforeMethod
	@Parameters("browser")
	protected void setupBrowser(@Optional("chrome")String browser) {

		// browser = System.getProperty("browser");

		System.out.println("browser name:" + browser);

		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);
			break;
		}

		DriverManager.setDriver(driver);
		DriverManager.getDriver().get("https://automationexercise.com/");
		DriverManager.getDriver().manage().window().maximize();
	}

	@AfterMethod
	protected void closeBrowser() {
		if (DriverManager.getDriver() != null) {
			driver.close();
		}
	}

}
