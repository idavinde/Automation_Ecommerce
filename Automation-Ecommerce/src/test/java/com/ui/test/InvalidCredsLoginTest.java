package com.ui.test;



import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;

import org.testng.annotations.Test;


import com.ui.pojo.User;
@Listeners(com.ui.listener.ITestListeners.class)
public class InvalidCredsLoginTest extends TestBase {
	

	private static final String INVALID_EMAIL_ADDRESS ="asdbc@gmail.com";
	private static final String INVALID_PASSWORD="dasdf";

	@Test(description= "Verifies if the proper error message is shown for the user when they enter invalid credentials")
	public void loginTest() {
		
		
		assertEquals(homepage.goToLogin().doLoginWithInvalidCredentials(INVALID_EMAIL_ADDRESS, INVALID_PASSWORD).getErrorMessage(), "Authentication failed.");
	}
	
	
	
	

}
