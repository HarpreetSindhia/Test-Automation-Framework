package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class InvalidLoginCredentials extends TestBase {
	
	private static final String EMAIL_ADDRESS = "sapediw118@soppat.com";
	private static final String PASSWORD = "passworf";

	@Test(description = "Verifies if user gets error message entering invalid credentials")
	public void invalidLoginCredentials()
	{
		assertEquals(homePage.goToLoginPage().invalidLoginCredentials(EMAIL_ADDRESS, PASSWORD).getErrorMessage(),"Authentication failed.");
		
	}
	
}
