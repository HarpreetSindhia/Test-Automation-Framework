package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.Env;
import com.utility.JsonUtility;

public class MyRetryAnalyzer implements IRetryAnalyzer {

	private static final int MAX_NUMBER_OF_ATTEMPTS = JsonUtility.readJson(Env.QA).getMAX_NUMBER_OF_ATTEMPTS();
	int current_Attempt = 1;
	
	
	@Override
	public boolean retry(ITestResult result) {
		
		if(current_Attempt <= MAX_NUMBER_OF_ATTEMPTS)
		{
			current_Attempt++;
			return true;
			
		}
		return false;
	}

}
