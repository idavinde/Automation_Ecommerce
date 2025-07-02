package com.ui.listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer {
	
	private static final int MAX_COUNT= 3;
	private static int CURR_COUNT=1;
	
	public boolean retry(ITestResult result) {
		
		if(CURR_COUNT<=MAX_COUNT) {
			
			CURR_COUNT++;
			
			return true;
			
		}
		return false;
	}

}
