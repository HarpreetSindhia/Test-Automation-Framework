package com.ui.pages;

import static com.constants.Env.QA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.constants.Env;
import com.utility.BrowserUtility;
import com.utility.JsonUtility;

public final class HomePage extends BrowserUtility {

	public HomePage(Browser browserName , Boolean isHeadless)
	{
		super(browserName , isHeadless);
		goToWebsite(JsonUtility.readJson(QA).getURL());
	}

	
	public HomePage(WebDriver driver)
	{
		super(driver);
		goToWebsite(JsonUtility.readJson(QA).getURL());
	}

	private	static final By SIGN_IN_LINK_LOCATOR =	By.xpath("//a[contains(text(),'Sign in')]");

	public LoginPage goToLoginPage()//Page Functions cannot have a void return type
	{
		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}


}

