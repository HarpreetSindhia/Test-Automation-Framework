package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ConfirmAddressPage extends BrowserUtility {

	public ConfirmAddressPage(WebDriver driver)
	{
		super(driver);
	}
	
	private static final By PROCESS_ADDRESS_CHECKOUT_BUTTON_LOCATOR = By.xpath("//p//button[contains(@name,'processAddress')]");
	
	public ShippingPage goToShippingPage()
	{
		scrollIntoView(PROCESS_ADDRESS_CHECKOUT_BUTTON_LOCATOR);
		clickOn(PROCESS_ADDRESS_CHECKOUT_BUTTON_LOCATOR);
		ShippingPage shippingPage = new ShippingPage(getDriver());
		return shippingPage;
	}
}
