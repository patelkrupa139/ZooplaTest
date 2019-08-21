package com.zoopla.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy (xpath = "//h1[@class='search-crabs-promo__title search-home-title']")
	WebElement pageHeading;
	
	@FindBy (xpath ="//a[@class='button button--tertiary-dark enquiry-link__text']")
	WebElement myEnquirieslink;
	
	@FindBy (xpath ="//a[@class='button button--tertiary-dark main_header__manage']")
	WebElement viewMyHomeLink;
	
	@FindBy (xpath = "//a[@class='button button--tertiary-dark account-link__text']")
	WebElement SignInButton;
	
	@FindBy (xpath = "//a[@class='mnav__link has-subnav'][contains(text(),'For sale')]")
	WebElement forSaleLink;
	
	@FindBy(xpath = "//li[@id='mn-buy']//a[@class='subnav__link'][contains(text(),'property for sale')]")
	WebElement UKPropertiesForSale;
	
	
	//Initialising page objects
	
	public HomePage() {
		PageFactory.initElements(driver, this);
			}
	
	public boolean verifyPageHeading() {
		return pageHeading.isDisplayed();
		}
	
	public MyEnquiries myEnquiriesPage() {
		myEnquirieslink.click();
		return new MyEnquiries();
			}
	
	public ForSale ForSalePage() {
		forSaleLink.click();
		return new ForSale();
			} 
	
	public PropertiesForSale clickOnPropertiesForSale() {
		Actions action = new Actions(driver);
		action.moveToElement(forSaleLink).build().perform();
		UKPropertiesForSale.click();
		return new PropertiesForSale();
		}

}
