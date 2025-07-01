package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.constants.Env;
import com.ui.utility.BrowserUtility;
import com.ui.utility.JSONEnvriUtility;

public final class HomePage extends BrowserUtility {
	
public HomePage(WebDriver driver) {
		
		super(driver);
		
		gotoWebSite(JSONEnvriUtility.readJSON(Env.QA).getURL());
		
	}
	
	
	public HomePage(String browserName, boolean isHeadless) {
		
		super(Browser.valueOf(browserName.toUpperCase()), isHeadless);
		
		gotoWebSite(JSONEnvriUtility.readJSON(Env.QA).getURL());
	}
	
	private static final By SIGN_IN_LINK_LOCATOR= By.className("login");
	
	public LoginPage goToLogin() {
		
		clickOn(SIGN_IN_LINK_LOCATOR);
		
		return new LoginPage(getDriver());
		
	}

}
