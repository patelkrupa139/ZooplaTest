package com.zoopla.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.zoopla.base.TestBase;
import com.zoopla.pages.ForSale;
import com.zoopla.pages.HomePage;
import com.zoopla.util.TestUtil;

public class ForSaleTest extends TestBase {
   
	HomePage homepage;
	ForSale forsale;
	TestUtil testutil;
	String sheetName = "FindProperty";
	
	
	public ForSaleTest() {
		super();
	
}
	 @BeforeMethod
	 public void setup() {
		  initConfiguration();
		  homepage = new HomePage();
		  forsale = new ForSale();
		  testutil = new TestUtil();
		  
	 }
	 
	  @Test(priority=1)
	  public void clickOnPropertiesforSale() {
		forsale = homepage.ForSalePage();
	  }
	  
	  @DataProvider
		public Object[][] propertiesforSaleData() throws InvalidFormatException{
		Object [][]data= TestUtil.getTestData(sheetName);
			return data;
	}
				
		@Test(priority=2, dataProvider="propertiesforSaleData")
		public void searchpropertiesforSale(String loc, String minimumprice, String maximumprice, String propertytype, String minbeds) {
			 forsale = homepage.ForSalePage();
			forsale.findaproperty(loc, minimumprice, maximumprice, propertytype, minbeds);
		}


	 @AfterMethod
		public void tearDown(){
			driver.quit();
		}
}