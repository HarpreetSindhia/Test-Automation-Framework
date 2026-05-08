package com.utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	private JavascriptExecutor js;

	private WebDriverWait wait;

	public WebDriver getDriver()
	{
		return driver.get();
	}

	public void setDriver(WebDriver driverInstance) {
		
		driver.set(driverInstance);
		
	}

	public BrowserUtility(WebDriver driverInstance)
	{
		super();
		driver.set(driverInstance);
		this.js = ((JavascriptExecutor)driverInstance);
	}

	public BrowserUtility(String browserName)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver.set(new ChromeDriver());
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			driver.set(new EdgeDriver());
		}
		else
		{
			System.err.println("Please select from the valid browsers chrome or edge");
		}

	}

	public BrowserUtility(Browser browserName , Boolean isHeadless)
	{
		if(browserName == Browser.CHROME)
		{
			if(isHeadless)
			{
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=Old");
				options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
				
			}
		
		else
		{
			driver.set(new ChromeDriver());
		}
		}
		else if(browserName == Browser.EDGE)
		{
			if(isHeadless)
			{
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=Old");
				options.addArguments("--disable-gpu");
				driver.set(new EdgeDriver(options));
			}
			else
		{
			driver.set(new EdgeDriver());
		}
		}
		else if(browserName == Browser.FIREFOX)
		{
			if(isHeadless)
			{
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=Old");
				options.addArguments("--disbale-gpu");
				driver.set(new FirefoxDriver(options));
			}
			else
		{
			driver.set(new FirefoxDriver());
		}
		}
	}

	public void goToWebsite(String url)
	{
		driver.get().get(url);
	}

	public void maximizeWindow()
	{
		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator)
	{
		WebElement element =	driver.get().findElement(locator);
		element.click();
	}

	public void enterText(By locator , String text)
	{
		WebElement element =	driver.get().findElement(locator);
		element.sendKeys(text);
	}

	public void waitForTheElementToAppear(By locator)
	{ 
		WebDriverWait wait = new WebDriverWait(driver.get() , Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void scrollIntoView(By locator)
	{
		WebElement element =	driver.get().findElement(locator);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}


	public void selectDropDownByValue(By locator , String text)
	{
		WebElement element =	driver.get().findElement(locator);
		Select dropDown = new Select(element);
		dropDown.selectByValue(text);
	}

	public String getVisibleText(By locator)
	{
		WebElement element =	driver.get().findElement(locator);
		return element.getText();
	}

	public static String screenshot(String name)
	{
		File src =	((TakesScreenshot)driver.get()).getScreenshotAs(OutputType.FILE);
		String path =	"./Screenshots/"+name+".png";
		File dest = new File(path);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
	
	
	public void quit()
	{
		driver.get().quit();
	}


}
