package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShippingPage extends BrowserUtility {

	public ShippingPage(WebDriver driver)
	{
		super(driver);
	}
	
	private static final By TERMS_OF_SERVICE_CHECKBOX_LOCATOR = By.xpath("//label/preceding-sibling::div[@id='uniform-cgv']");
	
	private static final By SHIPPING_CHECKOUT_BUTTON = By.xpath("//p//button[contains(@name,'processCarrier')]");
	
	public ShippingPage checkTermsAndConditions()
	{
		clickOn(TERMS_OF_SERVICE_CHECKBOX_LOCATOR);
		ShippingPage shippingPage = new ShippingPage(getDriver());
		return shippingPage;
	}
	
	public PaymentPage goToPaymentPage()
	{
		clickOn(SHIPPING_CHECKOUT_BUTTON);
		PaymentPage paymentPage = new PaymentPage(getDriver());
		return paymentPage;
	}
	
}
