package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.pojo.AddressPojo;
import com.ui.utility.BrowserUtility;

public class AddressPage extends BrowserUtility {
	
	public AddressPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	private static final By COMPANY_LOCATOR = By.id("company");
	private static final By ADDRESS_LOCATOR = By.id("address1");
	private static final By ADDRESS2_LOCATOR  = By.id("address2");
	private static final By CITY_LOCATOR   = By.id("city");
	private static final By STATE_LOCATOR = By.id("id_state");
	private static final By ZIP_LOCATOR = By.id("postcode");
	
	private static final By HOME_PHONE_LOCATOR = By.id("phone");
	private static final By MOBILE_PHONE_LOCATOR = By.id("phone_mobile");
	private static final By ADDITIONAL_INFO_LOCATOR = By.id("other");
	private static final By ADDRESS_TITLE = By.id("alias");
	private static final By SAVE_ADDRESS_LOCAOTR = By.id("submitAddress");
	private static final By ADDRESS_HEADING =By.tagName("h3");
	
	
	public String saveAddress(AddressPojo addressPojo) {
		
		
		enterText(COMPANY_LOCATOR, addressPojo.getCompany());
		enterText(ADDRESS_LOCATOR, addressPojo.getAddress());
		enterText(ADDRESS2_LOCATOR, addressPojo.getAddress2());
		
		enterText(CITY_LOCATOR, addressPojo.getCity());
		
		selectFromDropDown(STATE_LOCATOR, addressPojo.getState());
		
		enterText(ZIP_LOCATOR, addressPojo.getZip());
		enterText(MOBILE_PHONE_LOCATOR, addressPojo.getMobile_phone());
		enterText(HOME_PHONE_LOCATOR, addressPojo.getHome_phone());
		enterText(ADDITIONAL_INFO_LOCATOR, addressPojo.getOtherInformation());
		clearText(ADDRESS_TITLE);
		enterText(ADDRESS_TITLE, addressPojo.getAddressAlias());
		clickOn(SAVE_ADDRESS_LOCAOTR);
		
		return getVisibleText(ADDRESS_HEADING);
		
		
	}

}
