package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.utility.BrowserUtility;

public final class MyAccount extends BrowserUtility {
	
	public MyAccount(WebDriver driver) {
		super(driver);
	}
	private static final By MY_ACCOUNT_TEXT = By.xpath("//h1[@class=\"page-heading\"]");
	
	public String getHeaderText() {
		
		return getVisibleText(MY_ACCOUNT_TEXT);
	}
}
