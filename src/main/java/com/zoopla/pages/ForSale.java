package com.zoopla.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.zoopla.base.TestBase;

public class ForSale extends TestBase {

	@FindBy(xpath = "//span[contains(@class,'search-input-location-placeholder-1')]")
	WebElement location;
	@FindBy(xpath ="//select[@id='forsale_price_min']")
	WebElement minprice;	
	@FindBy(xpath = "//select[@id='forsale_price_max']")
	WebElement maxprice;
	@FindBy(xpath = "//select[@id='property_type']")
	WebElement typeofproperty;
	@FindBy(xpath ="//select[@id='beds_min']")
	WebElement noofbedrooms;
	@FindBy(xpath = "//button[@id='search-submit']")
	WebElement searchbtn;
	
	public ForSale() { 
		PageFactory.initElements(driver, this);
		
	}
	public void findaproperty(String loc, String minimumprice, String maximumprice, String propertytype, String minbeds) {
		location.sendKeys(loc);
		Select select = new Select(minprice);
		select.selectByValue(minimumprice);


		searchbtn.click();
		
		
	}
}
