package com.ui.listener;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.ui.test.TestBase;
import com.ui.utility.BrowserUtility;
import com.ui.utility.ExtentReportUtility;
import com.ui.utility.LoggerUtility;

public class ITestListeners implements ITestListener {
	
	Logger logger = LoggerUtility.getLogger(this.getClass());
	
	public void onStart(ITestContext context) {
		logger.info("Test Suit is Started");
		
		ExtentReportUtility.intializeSparkReporter("report.html");
	}
	
	
	public void onTestStart(ITestResult result) {
		logger.info(result.getMethod().getMethodName());
		logger.info(result.getMethod().getDescription());
		ExtentReportUtility.createTest(result.getMethod().getMethodName());
	}
	
	
	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName()+ " PASSED");
		ExtentReportUtility.getTest().log(Status.PASS, result.getMethod().getMethodName()+" "+"PASSED");
	}
	
	
	public void onTestSkipped(ITestResult result) {
		logger.info(result.getMethod().getMethodName()+ " SKIPPED");
		ExtentReportUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName()+" "+"SKIPPED");
	}
	

	public void onTestFailure(ITestResult result) {
		logger.error(result.getMethod().getMethodName()+ " FAILED");
		ExtentReportUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName()+" "+"FAILED");
		ExtentReportUtility.getTest().log(Status.FAIL, result.getThrowable().getMessage());
		 
	Object testClass =	result.getInstance();
	
		BrowserUtility browserUtility =	((TestBase)testClass).getInstance();
		logger.info("Capturing Screenshot for the failed tests");
		
		String path =browserUtility.takeScreenshot(result.getMethod().getMethodName());
		logger.info("Attaching the screenshot to the HTML file");
		
		ExtentReportUtility.getTest().addScreenCaptureFromPath(path);
	}
	
	
	public void onFinish(ITestContext context) {
		
		logger.info("Test Finished");
		ExtentReportUtility.flushReport();
	}

}
