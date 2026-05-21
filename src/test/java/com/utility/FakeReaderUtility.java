package com.utility;

import com.github.javafaker.Faker;
import com.ui.pojos.AddressPOJO;

public class FakeReaderUtility {

	
	public static	AddressPOJO getAddress()
	{
		Faker faker = new Faker();
		AddressPOJO addressPojo = new AddressPOJO(faker.company().name(), faker.address().buildingNumber(),
				faker.address().streetAddress(), faker.address().city(), "5" , faker.numerify("#####"), faker.phoneNumber().cellPhone(),
				faker.phoneNumber().cellPhone() ,"other" , "Office address");
		
		return addressPojo;
	}
}
