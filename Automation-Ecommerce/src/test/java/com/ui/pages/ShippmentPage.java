package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.utility.BrowserUtility;

public class ShippmentPage extends BrowserUtility {

	private static final By AGREEMENT_CHEECKBOX_LOCATOR = By.xpath("//p[@class=\"checkbox\"]/div");
	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By.name("processCarrier");

	public ShippmentPage(WebDriver driver) {
		super(driver);

	}
	
	
	
	public PaymentMethodPage goToPaymentMethodPage() {
		clickOn(AGREEMENT_CHEECKBOX_LOCATOR);
		clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		
		return new PaymentMethodPage(getDriver());
	}

}
