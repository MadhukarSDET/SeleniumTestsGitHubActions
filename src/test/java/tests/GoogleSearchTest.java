package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.SearchPage;

public class GoogleSearchTest extends BaseTest {

    @Test
    public void verifyGoogleTitle() {
        String searchPageTitle = new SearchPage(driver).getTitle();
        System.out.println("Page Title is: " + searchPageTitle);
        Assert.assertTrue(searchPageTitle.contains("Automation"));
    }
}
