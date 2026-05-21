package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Size;
import com.utility.BrowserUtility;

public class ProductDetailPage extends BrowserUtility{

	public ProductDetailPage(WebDriver driver)
	{
		super(driver);
	}
	
	private static final By SIZE_DROPDOWN_LOCATOR = By.id("group_1");
	
	private static final By ADD_TO_CART_BUTTON_LOCATOR = By.xpath("//button[@class='exclusive']");
	
	private static final By POP_UP_PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By.xpath("//div//a[@class='btn btn-default button button-medium']");
	
	public ProductDetailPage selectSize(Size size)
	{
		selectFromDropDownNew(SIZE_DROPDOWN_LOCATOR ,size);
		ProductDetailPage productDetailPage = new ProductDetailPage(getDriver());
		return productDetailPage;	
	}
	
	public ProductDetailPage addProductToCart()
	{
		clickOn(ADD_TO_CART_BUTTON_LOCATOR);
		ProductDetailPage productDetailPage = new ProductDetailPage(getDriver());
		return productDetailPage;
	}
	
	public ShoppingCartPage proceedToCheckout()
	{
		clickOn(POP_UP_PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		ShoppingCartPage shoppingCartPage = new ShoppingCartPage(getDriver());
		return shoppingCartPage;
	}
	
	
}
