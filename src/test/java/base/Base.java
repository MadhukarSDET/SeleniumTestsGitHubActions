package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class Base {
	
	@BeforeMethod
	@Parameters("browser")
	protected void setupBrowser(@Optional("chrome")String browser) {
		DriverFactory.createDriverInstance(browser);
	}
	
	
	@AfterMethod
	public void teardown() {
		DriverFactory.removeDriver();
	}


}
