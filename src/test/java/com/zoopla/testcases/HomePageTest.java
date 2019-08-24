package com.zoopla.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.zoopla.base.TestBase;
import com.zoopla.pages.HomePage;
import com.zoopla.pages.MyEnquiriesPage;
import com.zoopla.pages.PropertiesForSalePage;

public class HomePageTest extends TestBase {

    HomePage homePage;
    MyEnquiriesPage myEnquiriesPage;
    PropertiesForSalePage propertiesForSalePage;

	public HomePageTest() {
	    super();
    }
 
    @BeforeMethod
    public void setup() {
        initConfiguration();
        homePage = new HomePage();
        myEnquiriesPage = new MyEnquiriesPage();
    	propertiesForSalePage = new PropertiesForSalePage();
    }
  
     @Test(priority=1)
     public void verifyHomePageHeading() {
         boolean HomePageHeading = homePage.verifyPageHeading();
         Assert.assertEquals(HomePageHeading, HomePageHeading); // This line asserts a boolean against itself.
     }
 
     @Test(priority=2)
     public void clickOnMyEnquiriesLink() {
         myEnquiriesPage = homePage.clickMyEnquiriesPage();
         // There is no assertion in this test
     }

     @AfterMethod
     public void tearDown(){
         driver.quit();
     }
}