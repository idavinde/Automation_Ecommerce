package com.ui.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.MyAccount;
import com.ui.pojo.AddressPojo;
import com.ui.utility.FakerUtility;

public class AddNewAddressTest extends TestBase {

		private MyAccount myAccount;
		private AddressPojo addressPojo;
		
	@BeforeMethod(description="Valid First time user logs into the application")
	public void setup() {
		
		myAccount= homepage.goToLogin().loginWith("himowo6910@iridales.com", "12345");
		addressPojo = FakerUtility.getFakerAddress();
	}	
	
	@Test
	public void addNewAddress(){

		
	
		Assert.assertEquals(myAccount.goToAddressPage().saveAddress(addressPojo), addressPojo.getAddressAlias().toUpperCase());
		
	}
}
