package com.uiautomation.dataprovider;

import org.testng.annotations.DataProvider;

import com.uiautomation.utility.NewExcelLibrary;

public class DataProviders {
	
	NewExcelLibrary obj = new NewExcelLibrary();
	
	@DataProvider(name = "credentials")
	public Object[][] getCredentials(){
		//Total rows count
		int rows = obj.getRowCount("Credentials");
		//Total columns count
		int column = obj.getColumnCount("Credentials");
		
		int actRows = rows - 1;
		
		Object[][] data = new Object[actRows][column];
		
		for(int i = 0 ; i < actRows ; i++) {
			for(int j = 0 ; j < column ; j++) {
				data[i][j] = obj.getCellData("Credentials", j, i+2);
			}
		}
		return data;
	}

}
