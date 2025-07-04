package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.utility.BrowserUtility;

public final class LoginPage extends BrowserUtility {

	public LoginPage(WebDriver driver) {

		super(driver);
	}

	private static final By EMAIL_ADDRESS_LOCATOR = By.id("email");
	private static final By PASSWORD_LOCATOR = By.id("passwd");
	private static final By LOGIN_BUTTON_LOCATOR = By.id("SubmitLogin");
	private static final By ERROR_MESSAGE_LOCATOR = By.xpath("//div[contains(@class,\"alert-danger\")]/ol/li");

	public MyAccount loginWith(String emailAddress, String password) {

		enterText(EMAIL_ADDRESS_LOCATOR, emailAddress);
		enterText(PASSWORD_LOCATOR, password);
		clickOn(LOGIN_BUTTON_LOCATOR);

		return new MyAccount(getDriver());
	}

	public LoginPage doLoginWithInvalidCredentials(String emailAddress, String password) {

		enterText(EMAIL_ADDRESS_LOCATOR, emailAddress);
		enterText(PASSWORD_LOCATOR, password);
		clickOn(LOGIN_BUTTON_LOCATOR);
		return new LoginPage(getDriver());

	}

	public String getErrorMessage() {

		return getVisibleText(ERROR_MESSAGE_LOCATOR);
	}

}
