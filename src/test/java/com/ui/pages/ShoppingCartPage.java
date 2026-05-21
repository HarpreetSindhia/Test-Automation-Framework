package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShoppingCartPage extends BrowserUtility {

	public ShoppingCartPage(WebDriver driver)
	{
		super(driver);
	}
	
	private static final By STANDARD_CHECKOUT_BUTTON = By.xpath("//p//a[contains(@title,'Proceed to checkout')]");
	
	
	public ConfirmAddressPage goToAddressPage()
	{
		scrollIntoView(STANDARD_CHECKOUT_BUTTON);
		clickOn(STANDARD_CHECKOUT_BUTTON);
		ConfirmAddressPage confirmAddressPage = new ConfirmAddressPage(getDriver());
		return confirmAddressPage;
	}
	
}
