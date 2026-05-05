package com.ui.tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;

public class TestBase {

	HomePage homePage;
	
	private static Boolean isLambdaTest;
	
	@Parameters({"browser" , "isLambdaTest" , "isHeadless"})
	
	@BeforeMethod(description = "Loads the homepage of the website")
	public void setup(
			
			@Optional("chrome")	String browser , 
			@Optional("false") Boolean isLambdaTest , 
			@Optional("true") Boolean isHeadless , ITestResult result)
	{
		
		WebDriver lambdaDriver;
		if(isLambdaTest)
		{
			lambdaDriver =	LambdaTestUtility.initializeLambdaTestSession(browser, result.getMethod().getMethodName());
			
			homePage = new HomePage(lambdaDriver);
		}
		else
		{
			homePage = new HomePage(Browser.valueOf(browser.toUpperCase()) , true);
		}
		
		
	}
	
	public BrowserUtility getInstance()
	{
		return homePage;
	}
	
	
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
