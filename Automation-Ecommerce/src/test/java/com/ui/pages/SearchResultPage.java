package com.ui.pages;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ui.utility.BrowserUtility;

public final class SearchResultPage extends BrowserUtility {

	public SearchResultPage(WebDriver driver) {
		super(driver);
	}

	private static final By PRODUCT_LISTING_TITLE_LOCATOR = By
			.xpath("//h1[contains(@class,'page-heading')]//span[@class=\"lighter\"]");
	private static final By ALL_PRODUCT_LISTS_NAME = By.xpath("//h5[@itemprop=\"name\"]/a");
	private static final By MORE_BUTTON = By.xpath("//a[contains(@class,\"lnk_view \")]/span");

	public String getSearchResultTitle() {

		return getVisibleText(PRODUCT_LISTING_TITLE_LOCATOR);
	}

	public boolean isSearchTermPresentInProductLlist(String searchTerm) {

		List<String> keywords = Arrays.asList(searchTerm.toLowerCase().split(" "));

		List<String> productLNamesList = getAllVisibleText(ALL_PRODUCT_LISTS_NAME);

		boolean result = productLNamesList.stream()
				.anyMatch(name -> (keywords.stream().anyMatch(name.toLowerCase()::contains)));

		return result;

	}

	public ProductDetailPage selectSearchedProduct(String searchTerm) {

		List<String> productLNamesList = getAllVisibleText(ALL_PRODUCT_LISTS_NAME);
		List<WebElement> productList = getWebElementList(ALL_PRODUCT_LISTS_NAME);
		List<WebElement> moreButtonList = getWebElementList(MORE_BUTTON);

		for (int i = 0; i < productLNamesList.size(); i++) {
	        if (searchTerm.equalsIgnoreCase(productLNamesList.get(i))) {
	        	moveToElement(productList.get(i));
	        	clickOn(moreButtonList.get(i));
	            return new ProductDetailPage(getDriver());
	        }
	    }
	    
	    throw new NoSuchElementException("Product '" + searchTerm + "' not found in the list.");
	}
}
