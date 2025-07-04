package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Size;
import com.ui.utility.BrowserUtility;

public class ProductDetailPage extends BrowserUtility {

	public ProductDetailPage(WebDriver driver) {
		super(driver);
	}

	private static final By PRODUCT_AVAILABILITY = By.id("availability_value");
	private static final By SIZE_DROPDOWN = By.id("group_1");
	private static final By ADD_TO_CART_BUTTON = By.xpath("//p[@id=\"add_to_cart\"]/button");
	private static final By PROCEED_TO_CHECKOUT_BUTTON = By.xpath("//a[@title=\"Proceed to checkout\"]");

	public ProductDetailPage changeSize(Size size) {

		selectFromDropDown(SIZE_DROPDOWN, size.toString());

		return new ProductDetailPage(getDriver());
	}

	public ProductDetailPage addProductToCart() {

		clickOn(ADD_TO_CART_BUTTON);
		return new ProductDetailPage(getDriver());
	}

	public ShoppingCartPage proceedToCheckout() {

		clickOn(PROCEED_TO_CHECKOUT_BUTTON);
		
		return new ShoppingCartPage(getDriver());
	}

}
