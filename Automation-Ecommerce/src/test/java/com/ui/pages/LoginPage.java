package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.ui.utility.BrowserUtility;

public final class LoginPage extends BrowserUtility {
	
	public LoginPage(WebDriver driver) {
		
		super(driver);
	}
	
			private static final By EMAIL_ADDRESS = By.id("email");
			private static final By PASSWORD= By.id("passwd");
			private static final By LOGIN_BUTTON= By.id("SubmitLogin");
			
			
			public MyAccount loginWith(String emailAddress, String password) {
				
				enterText(EMAIL_ADDRESS, emailAddress);
				enterText(PASSWORD, password);
				clickOn(LOGIN_BUTTON);
				
				return new MyAccount(getDriver());
			}

}
