package com.ui.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

public abstract class BrowserUtility {

	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private Logger logger = LoggerUtility.getLogger(this.getClass());
	private WebDriverWait wait;

	public BrowserUtility(WebDriver driver) {

		this.driver.set(driver);
		wait= new WebDriverWait(driver, Duration.ofSeconds(30L));
	}

	public BrowserUtility(Browser browserName, boolean isHeadless) {

		if (browserName.equals(Browser.CHROME)) {

			if (isHeadless) {

				logger.info("Launching the Chrome Browser");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
				wait= new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			} else {

				logger.info("Launching the Chrome Browser");
				driver.set(new ChromeDriver());
				wait= new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}
		}

		else if (browserName.equals(Browser.EDGE)) {

			if (isHeadless) {

				logger.info("Launching the Edge Browser");
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless");
				driver.set(new EdgeDriver(options));
				wait= new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			} else {

				logger.info("Launching the Edge Browser");
				driver.set(new EdgeDriver());
				wait= new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}

		}

		else if (browserName.equals(Browser.FIREFOX)) {

			if (isHeadless) {

				logger.info("Launching the Firefox Browser");
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				driver.set(new FirefoxDriver(options));
				wait= new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			} else {

				logger.info("Launching the Firefox Browser");
				driver.set(new FirefoxDriver());
				wait= new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
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

		logger.info("Entering the the Text for locator: " + locator + " and entring special key: " + text);
		//driver.get().findElement(locator).sendKeys(text);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.sendKeys(text);
	}

	public void enterSpecialKey(By locator, Keys KeytoEnter) {

		logger.info("Finding Text for locator: " + locator + " Using Key " + KeytoEnter);
		//driver.get().findElement(locator).sendKeys(KeytoEnter);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.sendKeys(KeytoEnter);
	}

	public void clickOn(By locator) {

		
		
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		logger.info("Click on the locator: " + locator);
		element.click();
	}
	
	public void clickOn(WebElement element) {

		logger.info("Click on the element: " + element);
		element.click();
	}
	
	public void moveToElement(WebElement element) {
		
		Actions action = new Actions(driver.get());

		//Performing the mouse hover action on the target element.
		action.moveToElement(element).perform();
	}
	
	
	
	public List<String> getAllVisibleText(By locator) {

		logger.info("Find the list of Visibile text from locator: " + locator);
		List<WebElement> elementList =driver.get().findElements(locator);
		
		List<String> visibleTextList = new ArrayList<String>();
		for(WebElement element: elementList) {
			
			
			visibleTextList.add(getVisibleText(element));
			
		}
		
		return visibleTextList;
	}

	public String getVisibleText(By locator) {

		logger.info("Copy the Visibile text from locator: " + locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element.getText();
	}
	
	public String getVisibleText(WebElement element) {

		logger.info("Returning the Visibile text : " + element.getText());
		return element.getText();
	}
	
	public List<WebElement> getWebElementList(By locator) {
		
		logger.info("Getting the list of All webElement from locator: " + locator);
		List<WebElement> elementList =driver.get().findElements(locator);
		
		return elementList;
		
	}
	
	public void selectFromDropDown(By locator, String text) {
		
		logger.info("Find the locator : " + locator +"  select the dropdown");
		Select select = new Select(driver.get().findElement(locator));
		
		logger.info("Selecting the value from drop Down : " + text);
		select.selectByVisibleText(text);
		
	}
	
	public void clearText(By locator) {
		
		logger.info("Find the locator using : " + locator +"  and clearing the text field");
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.clear();
	}
	
	
	
	

	public void quit() {

		logger.info("Quiting the browser ");
		driver.get().quit();
	}

	public String takeScreenshot(String name) {

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver.get();
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy_HH-mm-ss");
		String timeStamp = simpleDateFormat.format(date);

		File srcfile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String path = "./screenshots/" + name + "-" + timeStamp + ".png";

		File file = new File(path);

		try {
			FileUtils.copyFile(srcfile, file);
		} catch (IOException e) {

			e.printStackTrace();
		}

		return path;
	}
}
