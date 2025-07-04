package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.utility.BrowserUtility;

public class ShoppingCartPage extends BrowserUtility {
	
	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	
	private static final By PROCEED_TO_CHECKOUT_BUTTON = By.xpath("//p[@class=\"cart_navigation clearfix\"]//a[@title=\"Proceed to checkout\"]");
	
	
	public ConfirmAddressPage goToConfirmAddressPage() {
		
		clickOn(PROCEED_TO_CHECKOUT_BUTTON);
		
		return new ConfirmAddressPage(getDriver());
	}
}
