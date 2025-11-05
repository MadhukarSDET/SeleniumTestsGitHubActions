package base;

import org.openqa.selenium.WebDriver;

public class DriverManager {
	
	
	public static ThreadLocal<WebDriver> threadSafeDriver= new ThreadLocal<>();
	
	public static WebDriver getDriver() {
		return threadSafeDriver.get();
	}
	
	public static void setDriver(WebDriver driver) {
		threadSafeDriver.set(driver);
	}

}
