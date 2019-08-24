package com.zoopla.testcases;

import com.zoopla.base.TestBase;
import com.zoopla.pages.ForSalePage;
import com.zoopla.pages.HomePage;
import com.zoopla.util.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ForSalePageTest extends TestBase {

    HomePage homePage;
    ForSalePage forSalePage;
    TestUtil testUtil;
    String sheetName = "FindProperty";

    public ForSalePageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initConfiguration();
        homePage = new HomePage();
        forSalePage = new ForSalePage();
        testUtil = new TestUtil();
    }

    @DataProvider
    public Object[][] propertiesforSaleData() {
        return TestUtil.getTestData(sheetName);
    }

    @Test(priority=1)
    public void clickOnPropertiesforSale() {
        forSalePage = homePage.clickForSalePage();
        // No assertions in this test
    }

    @Test(priority=2, dataProvider="propertiesforSaleData")
    public void userCanSearchPropertiesForSale(String loc, String minimumprice, String maximumprice, String propertytype, String minbeds) {
        forSalePage = homePage.clickForSalePage();
        forSalePage.searchForProperty(loc, minimumprice, maximumprice, propertytype, minbeds);
        // No assertions in this test
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}