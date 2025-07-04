package com.ui.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccount;

@Listeners({com.ui.listener.ITestListeners.class})
public class SearchProductTest extends TestBase{
	 
	private MyAccount myAccount;
	private static final String SEARCH_TERM = "Printed Summer Dress";
	
	@BeforeMethod(description="Valid user logs into the application")
	public void setup() {
		
		myAccount= homepage.goToLogin().loginWith("himowo6910@iridales.com", "12345");
	}	
	
	
	@Test(description=" Verify if the logged in user is able to search for a product and correct products search result are displayed", groups= {"e2e","smoke","sanity"})
		public void verifyProductSearchTest() {
			
			
		assertTrue(myAccount.searchForProducts(SEARCH_TERM).isSearchTermPresentInProductLlist(SEARCH_TERM));
			//assertEquals(, "\"PRINTED SUMMER DRESS\"");
		}
	
	
		
}
