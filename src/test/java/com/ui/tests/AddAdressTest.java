package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;
import com.ui.pojos.AddressPOJO;
import com.utility.FakeReaderUtility;

public class AddAdressTest extends TestBase{
	
	private static final String EMAIL_ADDRESS = "sapediw118@soppat.com";
	private static final String PASSWORD = "password";
	
	private MyAccountPage myAccountPage;
	
	private AddressPOJO addressPojo;

	@BeforeMethod(description = "Verifies if valid user is logged into the application")
	public void setup()
	{
		myAccountPage =	homePage.goToLoginPage().doLoginWith(EMAIL_ADDRESS, PASSWORD);
		addressPojo =	FakeReaderUtility.getAddress();
	}
	
	@Test(description = "Adds new address")
	public void addAddress()
	{
		String newAddress =	myAccountPage.goToAddressPage().saveAddress(addressPojo);
		Assert.assertEquals(newAddress , addressPojo.getAddress_Alias().toUpperCase());
	}
}
