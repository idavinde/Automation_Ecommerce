package com.ui.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.constants.Browser;

public abstract class BrowserUtility {

	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	Logger  logger = LoggerUtility.getLogger(this.getClass());

	public BrowserUtility(WebDriver driver) {

		this.driver.set(driver);
	}

	public BrowserUtility(Browser browserName, boolean isHeadless) {

		if (browserName.equals(Browser.CHROME)) {

			if (isHeadless) {
				
				logger.info("Launching the Chrome Browser");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
			} else {
				
				logger.info("Launching the Chrome Browser");
				driver.set(new ChromeDriver());
			}
		}

		else if (browserName.equals(Browser.EDGE)) {

			if (isHeadless) {

				logger.info("Launching the Edge Browser");
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless");
				driver.set(new EdgeDriver(options));
			} else {
				
				logger.info("Launching the Edge Browser");
				driver.set(new EdgeDriver());
			}

		}

		else if (browserName.equals(Browser.FIREFOX)) {

			if (isHeadless) {
				
				logger.info("Launching the Firefox Browser");
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				driver.set(new FirefoxDriver(options));
			} else {
				
				logger.info("Launching the Firefox Browser");
				driver.set(new FirefoxDriver());
			}

		}
	}
	
	public WebDriver getDriver() {
		
		return driver.get();
	}
	
	public void gotoWebSite(String URL) {
		
		logger.info("Visiting the the website: " + URL);
		driver.get().get(URL);
	}
	
	public void enterText(By locator, String text) {
		
		logger.info("Entering the the Text for locator: "+ locator + " Using text: " + text);
		driver.get().findElement(locator).sendKeys(text);
	}
	
	public void clickOn(By locator) {
		
		logger.info("Click on the locator: " +locator);
		driver.get().findElement(locator).click();
	}
	
	public String getVisibleText(By locator) {
		
		logger.info("Copy the Visibile text from locator: " + locator);
		return driver.get().findElement(locator).getText();
	}
	
	public void quit() {
		
		logger.info("Quiting the browser ");
		driver.get().quit();
	}
	
	public String takeScreenshot(String name) {
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver.get();
		Date date = new Date();
		SimpleDateFormat  simpleDateFormat= new SimpleDateFormat("MM-dd-yyyy_HH-mm-ss");
		String timeStamp= simpleDateFormat.format(date);
		
		
		
		File  srcfile =takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String path = "./screenshots/"+name+"-"+timeStamp+".png";
		
		File file = new File(path);
		
		try {
			FileUtils.copyFile(srcfile, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return path;
	}
}
