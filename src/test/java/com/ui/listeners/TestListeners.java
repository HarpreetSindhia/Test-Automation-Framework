package com.ui.listeners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.ui.tests.TestBase;
import com.utility.BrowserUtility;
import com.utility.ExtentReportUtility;
import com.utility.LoggerUtility;

public class TestListeners implements ITestListener {

	Logger logger = LoggerUtility.getLogger(this.getClass());
	@Override
	public void onTestStart(ITestResult result) {
		
		logger.info(result.getMethod().getMethodName());
		logger.info(result.getMethod().getDescription());
		logger.info(Arrays.toString(result.getMethod().getGroups()));
		ExtentReportUtility.createExtentTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		logger.info(result.getMethod().getMethodName() + " " + "Passed");
		ExtentReportUtility.getTest().log(Status.PASS, result.getMethod().getMethodName()+ " " + "PASSED");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		logger.error(result.getMethod().getMethodName() + " " + "Failed");
		logger.error(result.getThrowable().getMessage());
		ExtentReportUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName() + " " + "FAILED");
		ExtentReportUtility.getTest().log(Status.FAIL, result.getThrowable().getMessage());
		
		Object testClass =	result.getInstance();
		
		BrowserUtility browserUtility =	((TestBase)testClass).getInstance();
		
		String screenshotPath =	browserUtility.screenshot(result.getMethod().getMethodName());
		
		ExtentReportUtility.getTest().addScreenCaptureFromPath(screenshotPath);
		
		
		
	}
	

	@Override
	public void onTestSkipped(ITestResult result) {
		
		logger.warn(result.getMethod().getMethodName() + " " + "Skipped");
		ExtentReportUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName() + " " + "SKIPPED");
	}

	@Override
	public void onStart(ITestContext context) {
		
		logger.info("Test suite started");
		ExtentReportUtility.setUpSparkReporter("report.html");
	}

	@Override
	public void onFinish(ITestContext context) {
		
		logger.info("Test suite ended");
		ExtentReportUtility.flushReports();
	}

	
}
