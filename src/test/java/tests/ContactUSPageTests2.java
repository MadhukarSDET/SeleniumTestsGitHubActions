package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import base.Base;
import base.DriverFactory;
import pages.ContactUsPage2;

public class ContactUSPageTests2 extends Base {

	ContactUsPage2 contactUSPage2;

	@Test
	public void verifyContactFormSubmission() {
		
		contactUSPage2 = new ContactUsPage2(DriverFactory.getDriver());
		assertTrue(contactUSPage2.isLoginPageLoaded(),"Login Page Failed To Load");
		contactUSPage2.clickContactUSLink();
		assertTrue(contactUSPage2.isGetInTouchTextVisible(), "Get In Touch text not visible");
		contactUSPage2.fillAndSubmitContactUsForm();
		String successMSG = contactUSPage2.getSuccessMSG();
		System.out.println(successMSG);
		assertEquals(successMSG, "Success! Your details have been submitted successfully.",
				"Unable To Submit The Form");
	}

}
