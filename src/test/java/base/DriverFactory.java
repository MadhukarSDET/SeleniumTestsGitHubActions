package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	
	public static ThreadLocal<WebDriver> threadSafeDriver = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return threadSafeDriver.get();
	}

	public static void setDriver(WebDriver driver) {
		threadSafeDriver.set(driver);
	}
	
	public static void removeDriver() {
        if (getDriver() != null) {
            getDriver().quit();   
            threadSafeDriver.remove(); 
        }
    }

	public static void createDriverInstance(String browser) {

		WebDriver driver;
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
		threadSafeDriver.set(driver);
		threadSafeDriver.get().manage().window().maximize();
		threadSafeDriver.get().get("https://automationexercise.com/");
		
	}

}
