package com.ui.pojo;

public class AddressPojo {
	
	private String company;
	private String address;
	private String address2;
	private String city;
	private String state;
	private String zip;
	private String home_phone;
	private String mobile_phone;
	private String otherInformation;
	private String addressAlias;
	
	
	public AddressPojo(String company, String address, String address2, String city, String state, String zip,
			String home_phone, String mobile_phone, String otherInformation, String addressAlias) {
		super();
		this.company = company;
		this.address = address;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.home_phone = home_phone;
		this.mobile_phone = mobile_phone;
		this.otherInformation = otherInformation;
		this.addressAlias = addressAlias;
	}
	
	
	public String getCompany() {
		return company;
	}
	public String getAddress() {
		return address;
	}
	public String getAddress2() {
		return address2;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getZip() {
		return zip;
	}
	public String getHome_phone() {
		return home_phone;
	}
	public String getMobile_phone() {
		return mobile_phone;
	}
	public String getOtherInformation() {
		return otherInformation;
	}
	public String getAddressAlias() {
		return addressAlias;
	}
	
	@Override
	public String toString() {
		return "AddressPojo [company=" + company + ", address=" + address + ", address2=" + address2 + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + ", home_phone=" + home_phone + ", mobile_phone=" + mobile_phone
				+ ", otherInformation=" + otherInformation + ", addressAlias=" + addressAlias + "]";
	}
	
	

}
