package com.ui.test;



import org.testng.annotations.Test;


import com.ui.pojo.User;

public class LoginTest extends TestBase {
	
	
	@Test(dataProviderClass = com.ui.utility.JSONReadUtility.class, dataProvider= "loginTestData")
	public void loginTest(User user) {
		
		homepage.goToLogin().loginWith(user.getEmailAddress(), user.getPassword());
		
		
	}

}
