package com.ui.test;

import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


import com.ui.pages.HomePage;
import com.ui.utility.BrowserUtility;
import com.ui.utility.LambdaTestUtility;
import com.ui.utility.LoggerUtility;

public class TestBase {
	
	protected HomePage homepage;
	
	private boolean  isLambdaTest ;
	
	Logger logger = LoggerUtility.getLogger(this.getClass());
	
	@Parameters({"browserName","isHeadless","isLambdaTest"})
	@BeforeMethod
	public void setup(String browserName , boolean isHeadless, boolean isLambdaTest, ITestResult result) {
		
		this.isLambdaTest = isLambdaTest;
		
		if(isLambdaTest) {
			logger.info("Load the HomePage of WebSite");
			homepage = new HomePage(LambdaTestUtility.intializeLambdaSession(browserName, result.getMethod().getMethodName()));
		}
		
		else {
			logger.info("Load the HomePage of WebSite");
			homepage = new HomePage(browserName, isHeadless);
		}
	}
	
	
	public BrowserUtility getInstance() {

		return homepage;
	}
	
	@AfterMethod
	public void tearDown() {
		if(isLambdaTest) {
			
			LambdaTestUtility.quitSession();
		}
		else {
			
			homepage.quit();
		}
	}

}
