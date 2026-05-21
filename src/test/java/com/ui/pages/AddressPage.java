package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.pojos.AddressPOJO;
import com.utility.BrowserUtility;

public class AddressPage extends BrowserUtility{

	public AddressPage(WebDriver driver)
	{
		super(driver);
	}
	
	private static final By COMPANY_TEXTBOX_LOCATOR = By.id("company");
	private static final By ADDRESS1_TEXTBOX_LOCATOR = By.id("address1");
	private static final By ADDRESS2_TEXTBOX_LOCATOR = By.id("address2");
	private static final By CITY_TEXTBOX_LOCATOR = By.id("city");
	private static final By STATE_TEXTBOX_LOCATOR = By.id("id_state");
	private static final By POSTAL_CODE_TEXTBOX_LOCATOR = By.id("postcode");
	private static final By HOME_PHONE_TEXTBOX_LOCATOR = By.id("phone");
	private static final By MOBILE_PHONE_TEXTBOX_LOCATOR = By.id("phone_mobile");
	private static final By ADDITIONAL_INFORMATION_TEXTBOX_LOCATOR = By.id("other");
	private static final By ADDRESS_ALIAS_TEXTBOX_LOCATOR = By.id("alias");
	private static final By SAVE_BUTTON_LOCATOR = By.id("submitAddress");
	private static final By ADDRESS_HEADING_LOCATOR = By.tagName("h3");
	
	public String saveAddress(AddressPOJO addressPojo)
	{
		enterText(COMPANY_TEXTBOX_LOCATOR, addressPojo.getCompany());
		enterText(ADDRESS1_TEXTBOX_LOCATOR , addressPojo.getAddressLine1());
		enterText(ADDRESS2_TEXTBOX_LOCATOR, addressPojo.getAddressLine2());
		enterText(CITY_TEXTBOX_LOCATOR, addressPojo.getCity());
		selectFromDropDown(STATE_TEXTBOX_LOCATOR, addressPojo.getState());
		enterText(POSTAL_CODE_TEXTBOX_LOCATOR, addressPojo.getPostalCode());
		enterText(HOME_PHONE_TEXTBOX_LOCATOR , addressPojo.getHome_Phone());
		enterText(MOBILE_PHONE_TEXTBOX_LOCATOR, addressPojo.getMobile_Phone());
		enterText(ADDITIONAL_INFORMATION_TEXTBOX_LOCATOR , addressPojo.getAdditional_Information());
		clearText(ADDRESS_ALIAS_TEXTBOX_LOCATOR);
		enterText(ADDRESS_ALIAS_TEXTBOX_LOCATOR , addressPojo.getAddress_Alias());
		clickOn(SAVE_BUTTON_LOCATOR);
		String newAddress =	getVisibleText(ADDRESS_HEADING_LOCATOR);
		return newAddress;
	}
	
}
