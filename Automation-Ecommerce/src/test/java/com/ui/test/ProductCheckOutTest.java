package com.ui.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.constants.Size.*;
import com.ui.pages.MyAccount;
import com.ui.pages.SearchResultPage;
import com.ui.utility.FakerUtility;



public class ProductCheckOutTest extends TestBase {
	
	private SearchResultPage searchResultPage;
	private static final String SEARCH_TERM = "Printed Summer Dress";
	
	@BeforeMethod(description=" user logs into the application")
	public void setup() {
		
		 searchResultPage = homepage.goToLogin().loginWith("himowo6910@iridales.com", "12345").searchForProducts(SEARCH_TERM);
		
	}	
	
	@Test(description="Verify if the user logged in able to buy the dress")
	public void checkOutTest() {
		
		;
		
		
		Assert.assertEquals(searchResultPage.selectSearchedProduct(SEARCH_TERM).changeSize(L).addProductToCart().proceedToCheckout().goToConfirmAddressPage().goToShipmentPage()
				.goToPaymentMethodPage().goToOrderSummaryPage().goToOrderConfirmationPage().getSuccessMessage(), "Your order on My Shop is complete.");
	}
	

}
