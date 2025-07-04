package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.ui.utility.BrowserUtility;

public final class MyAccount extends BrowserUtility {
	
	public MyAccount(WebDriver driver) {
		super(driver);
	}
	private static final By MY_ACCOUNT_TEXT = By.xpath("//h1[@class=\"page-heading\"]");
	private static final By SEARCH_TEXT_BOX_LOCATOR= By.id("search_query_top");
	private static final By ADD_NEW_ADDRESS_LINK_LOCATOR = By.xpath("//a[@title=\"Add my first address\"]");
	
	public String getHeaderText() {
		
		return getVisibleText(MY_ACCOUNT_TEXT);
	}
	
	public SearchResultPage searchForProducts(String ProductName) {
		
		enterText(SEARCH_TEXT_BOX_LOCATOR, ProductName);
		enterSpecialKey(SEARCH_TEXT_BOX_LOCATOR, Keys.ENTER);
		return new SearchResultPage(getDriver());
		
	}
	
	public AddressPage goToAddressPage() {
		
		clickOn(ADD_NEW_ADDRESS_LINK_LOCATOR);
		return new AddressPage(getDriver());
	}
}
