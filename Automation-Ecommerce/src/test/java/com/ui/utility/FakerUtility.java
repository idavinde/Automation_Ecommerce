package com.ui.utility;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.ui.pojo.AddressPojo;

public class FakerUtility {

	public static void main(String[] args) {
		
		getFakerAddress();
	}
		public static AddressPojo getFakerAddress() {
			Faker faker = new Faker(Locale.US);
			AddressPojo addressPojo = new AddressPojo(faker.company().name(),faker.address().buildingNumber(), faker.address().streetAddress(), 
					faker.address().city(), faker.address().state(), faker.numerify("#####"), faker.phoneNumber().cellPhone(),
					faker.phoneNumber().cellPhone(), "other", "Office address");
			
			return addressPojo;
		}
}
