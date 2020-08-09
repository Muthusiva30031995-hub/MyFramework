package com.testautomation.TestRunner;

import org.testng.annotations.DataProvider;

import com.testautomation.Config.ReusableData;
import com.testautomation.reusableComponents.ExcelDataAccess;

public class DataProviderManager {

	static String ExecutionSheetPath = ReusableData.currentDir+"\\testData_cucumber\\"+"\\UI\\BAU_Regression\\Executionsheet.xlsx";
	@DataProvider(parallel=true)
    public static Object[][] testcasesList() throws Exception{
         Object[][] testObjArray = ExcelDataAccess.getTableArray(ExecutionSheetPath, "BDD");
         return (testObjArray);	
	}
}
