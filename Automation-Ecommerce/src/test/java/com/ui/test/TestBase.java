package com.ui.test;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


import com.ui.pages.HomePage;

public class TestBase {
	
	protected HomePage homepage;
	
	@Parameters({"browserName","isHeadless"})
	@BeforeMethod
	public void setup(String browserName , boolean isHeadless) {
		
		homepage = new HomePage(browserName, isHeadless);
	}
	
	
	@AfterMethod
	public void tearDown() {
		
		homepage.quit();
	}

}
