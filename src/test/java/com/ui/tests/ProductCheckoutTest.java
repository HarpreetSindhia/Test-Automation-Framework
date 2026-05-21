package com.ui.tests;

import static com.constants.Size.M;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.SearchResultPage;

@Listeners(com.ui.listeners.TestListeners.class)
public class ProductCheckoutTest extends TestBase {
	
	private static final String EMAIL_ADDRESS = "sapediw118@soppat.com";
	private static final String PASSWORD = "password";
	
	private static final String SEARCH_TERM = "Printed Summer Dress";
	
	private SearchResultPage searchResultPage;

	@BeforeMethod(description = "Verifies if user is logged into the application and search for a product")
	public void setup()
	{
		searchResultPage =	homePage.goToLoginPage().doLoginWith(EMAIL_ADDRESS, PASSWORD).searchForAProduct(SEARCH_TERM);
	}
	
	@Test(description = "checkout")
	public void checkOut()
	{
		searchResultPage.clickOnProductAt(4).selectSize(M).addProductToCart().proceedToCheckout().goToAddressPage().goToShippingPage()
		.checkTermsAndConditions().goToPaymentPage();
		
	}
}
