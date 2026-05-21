package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;

@Listeners(com.ui.listeners.TestListeners.class)
public class SearchProductTest extends TestBase {
	
	private MyAccountPage myAccountPage;
	private static final String EMAIL_ADDRESS = "sapediw118@soppat.com";
	private static final String PASSWORD = "password";
	
	private static final String SEARCH_TERM  = "Summer Printer Dress";
	
	

	@BeforeMethod(description="Valid user logs into the application")
	public void setup()
	{
		myAccountPage =	homePage.goToLoginPage().doLoginWith(EMAIL_ADDRESS, PASSWORD);
	}
	
	
	
	@Test(description="Verify if the logged in user is able to search for a product "
			+ "and correct search results are displayed" , groups = {"e2e" , "sanity"})
	public void verifySearchProduct()
	{
		Boolean result =	myAccountPage.searchForAProduct(SEARCH_TERM).isSearchItemPresentInTheProductList(SEARCH_TERM);
		Assert.assertEquals(result, true);
	}
}
