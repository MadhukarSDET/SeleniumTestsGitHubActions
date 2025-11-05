package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.ContactUsPage;

public class ContactUSPageTests extends BaseTest {

	ContactUsPage contactUSPage;

	@Test
	public void verifyContactFormSubmission() {
		contactUSPage = new ContactUsPage(driver);
		assertTrue(contactUSPage.isLoginPageLoaded(),"Login Page Failed To Load");
		contactUSPage.clickContactUSLink();
		assertTrue(contactUSPage.isGetInTouchTextVisible(), "Get In Touch text not visible");
		contactUSPage.fillAndSubmitContactUsForm();
		String successMSG = contactUSPage.getSuccessMSG();
		System.out.println(successMSG);
		assertEquals(successMSG, "Success! Your details have been submitted successfully.",
				"Unable To Submit The Form");
	}

}
