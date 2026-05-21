package com.ui.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class SearchResultPage extends BrowserUtility {

	public SearchResultPage(WebDriver driver)
	{
		super(driver);
	}
	
	private static final By PRODUCT_LISTING_TITLE_LOCATOR = By.xpath("//h1/span");
	
	
	private static final By ALL_PRODUCT_LIST_NAME = By.xpath("//h5[@itemprop='name']/a");
	
	public String getSearchResultTitle()
	{
		return getVisibleText(PRODUCT_LISTING_TITLE_LOCATOR);
	}
	
	public Boolean isSearchItemPresentInTheProductList(String searchTerm)
	{
		List<String> keywords =	Arrays.asList(searchTerm.toLowerCase().split(" "));
		List<String> productNameList =	getAllVisibleText(ALL_PRODUCT_LIST_NAME);
		Boolean result =	productNameList.stream().anyMatch(name -> (keywords.stream().anyMatch(name.toLowerCase()::contains)));
		return result;
	}
	
	public ProductDetailPage clickOnProductAt(int index)
	{
		clickOnWebElement(getAllProductList(ALL_PRODUCT_LIST_NAME).get(index));
		ProductDetailPage productDetailPage = new ProductDetailPage(getDriver());
		return productDetailPage;
	}
}
