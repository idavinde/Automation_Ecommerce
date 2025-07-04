package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.utility.BrowserUtility;

public class OrderConfirmationPage extends BrowserUtility {
	
	 private static final By SUCCESS_MESSAGE = By.xpath("//p[@class=\"alert alert-success\"]");
	 
	public OrderConfirmationPage(WebDriver driver) {
		super(driver);
		
	}
	
	public String getSuccessMessage() {
		
		return getVisibleText(SUCCESS_MESSAGE);
	}

}
