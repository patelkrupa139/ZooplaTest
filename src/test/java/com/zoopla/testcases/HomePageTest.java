package com.zoopla.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.zoopla.base.TestBase;
import com.zoopla.pages.HomePage;
import com.zoopla.pages.MyEnquiries;
import com.zoopla.pages.PropertiesForSale;

public class HomePageTest extends TestBase {

	HomePage homepage;
	MyEnquiries myEnquiries;
	PropertiesForSale propertiesforSale;
	
	
  public HomePageTest() {
	super();
  }
 
  @BeforeMethod
   public void setup() {
	  initConfiguration();
	  homepage = new HomePage();
	  myEnquiries = new MyEnquiries();
	  propertiesforSale = new PropertiesForSale();
	  
	  	  }
  
  @Test(priority=1)
  public void verifyHomePageHeading() {
	  boolean HomePageHeading = homepage.verifyPageHeading();
  	  Assert.assertEquals(HomePageHeading, HomePageHeading);
  	 }
 
  @Test(priority=2)
  public void clickOnMyEnquirieslinkTest() {
	  myEnquiries = homepage.myEnquiriesPage();
	   
	  }
  

  
  @AfterMethod
	public void tearDown(){
		driver.quit();
	}
  
  }