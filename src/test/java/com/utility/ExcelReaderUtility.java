package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojos.User;

public class ExcelReaderUtility {

	public static Iterator<User> readExcelFile(String fileName)
	{
		Row row;
		Cell emailAddressCell;
		Cell passwordCell;
		Cell expectedUserName;
		User userData;
		List<User> userList = new ArrayList<>();
		XSSFSheet xssfSheet;
		Iterator<Row> rowIterator;
		
		
		File xlsxFile = new File(System.getProperty("user.dir")+File.separator+"testData"+File.separator+fileName);
		XSSFWorkbook xssfWorkbook = null;
		
		try {
			xssfWorkbook = new XSSFWorkbook(xlsxFile);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		xssfSheet =	xssfWorkbook.getSheet("LoginTestData");
		rowIterator =	xssfSheet.iterator();
		rowIterator.next();
		
		while(rowIterator.hasNext())
		{
			row =	rowIterator.next();
			emailAddressCell =	row.getCell(0);
			passwordCell =	row.getCell(1);	
			expectedUserName =	row.getCell(2);
			userData =	new User(emailAddressCell.toString() , passwordCell.toString() , expectedUserName.toString());
			userList.add(userData);
		}
		
		return userList.iterator();
	}
}
