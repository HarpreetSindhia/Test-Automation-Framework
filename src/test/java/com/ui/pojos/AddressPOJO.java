package com.ui.pojos;

public class AddressPOJO {

	private String company;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String postalCode;
	private String home_Phone;
	private String mobile_Phone;
	private String additional_Information;
	private String address_Alias;
	
	@Override
	public String toString() {
		return "AddressPOJO [company=" + company + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
				+ ", city=" + city + ", state=" + state + ", postalCode=" + postalCode + ", home_Phone=" + home_Phone
				+ ", mobile_Phone=" + mobile_Phone + ", additional_Information=" + additional_Information
				+ ", address_Alias=" + address_Alias + "]";
	}

	public String getCompany() {
		return company;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getHome_Phone() {
		return home_Phone;
	}

	public String getMobile_Phone() {
		return mobile_Phone;
	}

	public String getAdditional_Information() {
		return additional_Information;
	}

	public String getAddress_Alias() {
		return address_Alias;
	}

	public AddressPOJO(String company, String addressLine1, String addressLine2, String city, String state,
			String postalCode, String home_Phone, String mobile_Phone, String additional_Information,
			String address_Alias) {
		super();
		this.company = company;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.home_Phone = home_Phone;
		this.mobile_Phone = mobile_Phone;
		this.additional_Information = additional_Information;
		this.address_Alias = address_Alias;
	}
	
	
	
}
