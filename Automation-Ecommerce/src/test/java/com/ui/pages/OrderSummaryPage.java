package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.utility.BrowserUtility;

public class OrderSummaryPage extends BrowserUtility {

		private static final By CONFORM_ORDER_BUTTON_LOCATOR= By.xpath("//button[contains(@class,\"button btn\")]");
		
	public OrderSummaryPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public OrderConfirmationPage goToOrderConfirmationPage() {
		
		clickOn(CONFORM_ORDER_BUTTON_LOCATOR);
		
		return new OrderConfirmationPage(getDriver());
	}

}
