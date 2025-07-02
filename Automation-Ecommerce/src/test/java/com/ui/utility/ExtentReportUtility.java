package com.ui.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
	
	private static ExtentReports extentReports;
	private static ThreadLocal<ExtentTest> extentTestLocal = new ThreadLocal<ExtentTest>();
	
	public static void intializeSparkReporter(String name) {
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(name);
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		
	}
	
	public static void createTest(String testName) {
		
		
		ExtentTest extentTest = extentReports.createTest(testName);
		
		extentTestLocal.set(extentTest);
	}
	
	public static  ExtentTest  getTest() {
		
		return extentTestLocal.get();
	}
	
	public static void flushReport() {
		
		extentReports.flush();
	}
}
