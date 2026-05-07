package com.ui.tests;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;

public class TestBase {

	HomePage homePage;
	
	private Boolean isLambdaTest;
	
	@Parameters({"browser" , "isLambdaTest" , "isHeadless"})
	
	@BeforeMethod(description = "Loads the homepage of the website")
	public void setup(
			
			@Optional("chrome")	String browser , 
			@Optional("false") Boolean isLambdaTest , 
			@Optional("true") Boolean isHeadless ,
			Method method)
	{
		String testName =	method.getName();	
		
		this.isLambdaTest = isLambdaTest;
		WebDriver lambdaDriver;
		
		String browserValue = (browser == null || browser.startsWith("${"))
	            ? "CHROME"
	            : browser.trim().toUpperCase();
		
		if(isLambdaTest)
		{
			lambdaDriver =	LambdaTestUtility.initializeLambdaTestSession(browserValue, testName);
			
			homePage = new HomePage(lambdaDriver);
		}
		else
		{
			homePage = new HomePage(Browser.valueOf(browserValue), true);
		}
		
		
	}
	
	public BrowserUtility getInstance()
	{
		return homePage;
	}
	
	@AfterMethod(description="Closes the driver session")
	public void tearDown()
	{
		if(isLambdaTest)
		{
			LambdaTestUtility.quitSession();
		}
		else
		{
			homePage.quit();
		}
	}
}
