package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.utility.BrowserUtility;

public class PaymentMethodPage extends BrowserUtility {

	private static final By PAYMENT_BY_WIRE_BUTTON = By.xpath("//a[@class=\"bankwire\"]");
	public PaymentMethodPage(WebDriver driver) {
		super(driver);
		
	}
	
	public OrderSummaryPage goToOrderSummaryPage() {
		
		clickOn(PAYMENT_BY_WIRE_BUTTON);
		
		return new OrderSummaryPage(getDriver());
	}

}
