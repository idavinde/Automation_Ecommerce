package com.ui.utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LambdaTestUtility {
	
	private static final String HUB_URL= "https://hub.lambdatest.com/wd/hub";
	private static ThreadLocal<WebDriver> driverLocal = new ThreadLocal<WebDriver>();
	private static ThreadLocal<DesiredCapabilities> capabilitiesLocal= new ThreadLocal<DesiredCapabilities>();
	
	public static WebDriver intializeLambdaSession(String browser, String testName) {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", browser);
		capabilities.setCapability("browserVersion", "127");
		Map<String,Object> ltOptions = new HashMap<String,Object>();
		
		ltOptions.put("user", "davinderraju");
		ltOptions.put("accessKey", "LT_6kZRoGAo1AMKd1yKhKHyAtTlpHaH5yvJv0YXeP78qJtLby7");
		ltOptions.put("build", "selenium 4");
		ltOptions.put("name", testName);
		ltOptions.put("platformName","windows 10");
		ltOptions.put("seCdp", true);
		ltOptions.put("selenium_version", "4.23.0");
		
		capabilities.setCapability("LT:Options", ltOptions);
		capabilitiesLocal.set(capabilities);
		
		
		WebDriver  driver = null;
		
		try {
			driver = new RemoteWebDriver(new URL (HUB_URL), capabilitiesLocal.get());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driverLocal.set(driver);
		
		return driverLocal.get();
	}
	
public static void quitSession() {
		
		if(driverLocal.get()!=null) {
			
			driverLocal.get().quit();
		}
	}

}
