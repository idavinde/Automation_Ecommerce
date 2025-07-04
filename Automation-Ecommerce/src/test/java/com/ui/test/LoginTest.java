package com.ui.test;



import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;

import org.testng.annotations.Test;


import com.ui.pojo.User;
@Listeners(com.ui.listener.ITestListeners.class)
public class LoginTest extends TestBase {
	

	@Test(description= "Verifies with the valid user is able to login into the application" , dataProviderClass = com.ui.utility.JSONReadUtility.class, dataProvider= "loginTestData", retryAnalyzer= com.ui.listener.MyRetryAnalyzer.class)
	public void loginTest(User user) {
		
		
		assertEquals(homepage.goToLogin().loginWith(user.getEmailAddress(), user.getPassword()).getHeaderText(), "MY ACCOUNT");
	}
	
	@Test(dataProviderClass = com.ui.utility.JSONReadUtility.class, dataProvider= "loginTestData", retryAnalyzer= com.ui.listener.MyRetryAnalyzer.class)
	public void loginTestInvalid(User user) {
		
		
		assertEquals(homepage.goToLogin().loginWith(user.getEmailAddress(), user.getPassword()).getHeaderText(), "MY ACCOUNT");
	}
	
	

}
