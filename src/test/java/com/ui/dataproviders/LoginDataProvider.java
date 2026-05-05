package com.ui.dataproviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojos.TestData;
import com.ui.pojos.User;
import com.utility.CSVReaderUtility;
import com.utility.ExcelReaderUtility;

public class LoginDataProvider {

	@DataProvider(name = "LoginTestDataProvider")
	public static Iterator<Object[]> loginTestDataProvider()
	{
		Gson gson = new Gson();
		FileReader fileReader = null;
		File jsonFile = new File(System.getProperty("user.dir")+"\\testData\\LoginData.json");
		try {
			fileReader = new FileReader(jsonFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		TestData data =	gson.fromJson(fileReader,TestData.class);
		
		List<Object[]> dataToReturn = new ArrayList<>();
		
		for(User user : data.getData())
		{
			dataToReturn.add(new Object[] {user});
			
		}
		return dataToReturn.iterator();
	}
	
	@DataProvider(name = "LoginTestCSVDataProvider")
	public static Iterator<User> loginTestCSVDataProvider()
	{
		return	CSVReaderUtility.readCSVFile("LoginData.csv");
	}
	
	@DataProvider(name = "LoginTestExcelDataProvider")
	public static Iterator<User> loginTestExcelDataProvider()
	{
		return ExcelReaderUtility.readExcelFile("LoginData.xlsx");
	}
}
