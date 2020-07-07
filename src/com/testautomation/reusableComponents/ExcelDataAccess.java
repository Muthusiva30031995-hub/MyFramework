package com.testautomation.reusableComponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.testautomation.Config.CommonData;
import com.testautomation.Config.ReusableData;
import com.testautomation.TestRunner.TestRunnerUI;




public class ExcelDataAccess {
	
	private static XSSFSheet ExcelWSheet;
	 private static XSSFWorkbook ExcelWBook;
	 private static XSSFCell Cell;
	 private static XSSFRow Row; 	 
	 private String DatafilePath;
	 private String DataSheetName;
	 private String currentTestcase;
	 String CommonDataFilePath;
	 String CommonDataSheetName;
	 private int currentIteration = 0;
	
	 
	 
	  
	 public ExcelDataAccess(String DatafilePath, String DataSheetName,String CommonDataFilePath, String CommonDataSheetName)
	 {		 
		 this.DatafilePath = DatafilePath;
		 this.DataSheetName = DataSheetName;
		 this.CommonDataFilePath = CommonDataFilePath;
		 this.CommonDataSheetName = CommonDataSheetName; 
		 
	 }
	 
	 public void setCurrentRow(String currentTestcase,int currentIteration)
		{
			this.currentTestcase = currentTestcase;
			this.currentIteration = currentIteration;
			
			
		}
	 
	 	private void checkPreRequisites() throws Exception
		{
			if (this.currentTestcase == null) {
				throw new Exception("CraftliteDataTable.currentTestCase is not set!");
			}
			
		}
	 
	 	
	public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {
		String[][] tabArray = null;
		
		try {
			FileInputStream ExcelFile = new FileInputStream(FilePath);
			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			int startRow = 1;
			int startCol = 0;
			int ci, cj;
			int totalRows = ExcelWSheet.getLastRowNum();
			// you can write a function as well to get Column count
			int totalCols = 5;
			tabArray = new String[totalRows][totalCols+1];
			ci = 0;

			for (int i = startRow; i <= totalRows; i++, ci++) {
				cj = 0;
				for (int j = startCol; j <= totalCols; j++, cj++) {
					tabArray[ci][cj] = getCellData(i, j);					
				}
			}
		}

		catch (FileNotFoundException e) {
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		}
		catch (IOException e) {
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		}
		return (tabArray);
	}

	public static String getCellData(int RowNum, int ColNum) throws Exception {
		 
		 try{
			 Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);	 
			 String CellData = Cell.getStringCellValue();
			 return CellData;			 
		 }
		 catch (Exception e)
		 {
			 System.out.println(e.getMessage());
			 throw (e);
		 }
	}
	
	
	
	public synchronized String getData(String fieldName) throws Exception
	{
		checkPreRequisites();
		String FilePath = this.DatafilePath;
		String datasheetName = this.DataSheetName;
		FileInputStream ExcelFile = new FileInputStream(FilePath);
		// Access the required test data sheet
		ExcelWBook = new XSSFWorkbook(ExcelFile);
		ExcelWSheet = ExcelWBook.getSheet(datasheetName);		
		Row = ExcelWSheet.getRow(0);
		int rownum =0;
		int colnum =0;
		String scenario = this.currentTestcase;
		for(int i=1;i<=ExcelWSheet.getLastRowNum();i++)
		{
			String a = ExcelWSheet.getRow(i).getCell(0).getStringCellValue();
			String b = a.substring(a.lastIndexOf("_"));
			a = a.replaceAll(b, "");					
			if(a.equalsIgnoreCase(scenario))
			{		
				
				String c = "TD"+String.valueOf(currentIteration);
				if(b.contains(c)){
					rownum = i;
					break;
				}
			}
		}
		
		for(int j=1;j<=Row.getLastCellNum();j++)
		{
			if(Row.getCell(j).getStringCellValue().equalsIgnoreCase(fieldName))
			{
				colnum = j;
				break;
			}
		}
		
		String value = null;
		try {
			value = getCellData(rownum, colnum);
		} catch (Exception e) {			
			
		}	
		FileOutputStream out = new FileOutputStream(FilePath);
		ExcelWBook.write(out);
		out.close();
		ExcelFile.close();		
		
		return value;
	}
	
	
	public synchronized String getDataIteration(String fieldName) throws Exception
	{
		checkPreRequisites();
		String FilePath = this.DatafilePath;
		String datasheetName = this.DataSheetName;
		FileInputStream ExcelFile = new FileInputStream(FilePath);
		// Access the required test data sheet
		ExcelWBook = new XSSFWorkbook(ExcelFile);
		ExcelWSheet = ExcelWBook.getSheet(datasheetName);		
		Row = ExcelWSheet.getRow(0);
		int rownum =0;
		int colnum =0;
		String scenario = this.currentTestcase;
		for(int i=1;i<=ExcelWSheet.getLastRowNum();i++)
		{
			if(ExcelWSheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase(scenario))
			{
				rownum = i;
				break;
			}
		}
		
		for(int j=1;j<=Row.getLastCellNum();j++)
		{
			if(Row.getCell(j).getStringCellValue().equalsIgnoreCase(fieldName))
			{
				colnum = j;
				break;
			}
		}
		
		String value = null;
		try {
			value = getCellData(rownum, colnum);
		} catch (Exception e) {			
			
		}	
		FileOutputStream out = new FileOutputStream(FilePath);
		ExcelWBook.write(out);
		out.close();
		ExcelFile.close();		
		
		return value;
	}
	
	
	public synchronized String getCommonData(String fieldName) throws Exception
	{
		String FilePath = this.CommonDataFilePath;
		String datasheetName = this.CommonDataSheetName;
		FileInputStream ExcelFile = new FileInputStream(FilePath);		
		ExcelWBook = new XSSFWorkbook(ExcelFile);
		ExcelWSheet = ExcelWBook.getSheet(datasheetName);
		Row = ExcelWSheet.getRow(0);
		int rownum =0;		
		for(int i=1;i<=ExcelWSheet.getLastRowNum();i++)
		{
			if(ExcelWSheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase(fieldName))
			{
				rownum = i;
				break;
			}
		}
				
		String value = getCellData(rownum, 1);	
		FileOutputStream out = new FileOutputStream(FilePath);
		ExcelWBook.write(out);
		out.close();
		ExcelFile.close();
		return value;
		
	}
	
	public void writeDataToExecutionSheet(String columnName, String dataToWrite) throws Exception
	{
		
		String FilePath = ReusableData.currentDir+"\\testData_cucumber\\"+"\\UI\\"+CommonData.projectName+"\\Executionsheet.xlsx";
		String datasheetName = "BDD";
		FileInputStream ExcelFile = new FileInputStream(FilePath);
		// Access the required test data sheet
		ExcelWBook = new XSSFWorkbook(ExcelFile);
		ExcelWSheet = ExcelWBook.getSheet(datasheetName); 		
		Row = ExcelWSheet.getRow(0);
		int rownum =0;
		int colnum =0;
		String scenario =CommonData.scenarioName; 
		for(int i=1;i<=ExcelWSheet.getLastRowNum();i++)
		{
			String a = ExcelWSheet.getRow(i).getCell(0).getStringCellValue();
				
			if(a.equalsIgnoreCase(scenario))
			{	
					rownum = i;
					break;
			}
		}
		
		
		for(int j=1;j<=Row.getLastCellNum();j++)
		{
			if(Row.getCell(j).getStringCellValue().equalsIgnoreCase(columnName))
			{
				colnum = j;
				break;
			}
		}
		Row = ExcelWSheet.getRow(rownum);
		if(Row ==null)
			Row = ExcelWSheet.createRow(rownum);		
		try {
			Cell = ExcelWSheet.getRow(rownum).getCell(colnum);
		} catch (Exception e) {
			
		}
		if(Cell ==null)
			Cell = Row.createCell(colnum);
		Cell.setCellValue(dataToWrite);
		
		FileOutputStream out = new FileOutputStream(FilePath);
		ExcelWBook.write(out);
		out.close();
		ExcelFile.close();
		
	}
	
	public void writeDataToDataRepo(String columnName, String dataToWrite) throws Exception
	{		
		String FilePath = ReusableData.currentDir+"\\testData_cucumber\\"+"\\UI\\"+CommonData.projectName+"\\DataRepo.xlsx";
		String datasheetName = "Data";
		FileInputStream ExcelFile = new FileInputStream(FilePath);
		// Access the required test data sheet
		ExcelWBook = new XSSFWorkbook(ExcelFile);
		ExcelWSheet = ExcelWBook.getSheet(datasheetName); 		
		Row = ExcelWSheet.getRow(0);
		int rownum =0;
		int colnum =0;
		String scenario =CommonData.scenarioName; 
		for(int i=1;i<=ExcelWSheet.getLastRowNum();i++)
		{
			String a = ExcelWSheet.getRow(i).getCell(0).getStringCellValue();
				
			if(a.equalsIgnoreCase(scenario))
			{	
					rownum = i;
					break;
			}
		}
		
		
		for(int j=1;j<=Row.getLastCellNum();j++)
		{
			if(Row.getCell(j).getStringCellValue().equalsIgnoreCase(columnName))
			{
				colnum = j;
				break;
			}
		}
		Row = ExcelWSheet.getRow(rownum);
		if(Row ==null)
			Row = ExcelWSheet.createRow(rownum);		
		try {
			Cell = ExcelWSheet.getRow(rownum).getCell(colnum);
		} catch (Exception e) {
			
		}
		if(Cell ==null)
			Cell = Row.createCell(colnum);
		Cell.setCellValue(dataToWrite);
		
		FileOutputStream out = new FileOutputStream(FilePath);
		ExcelWBook.write(out);
		out.close();
		ExcelFile.close();
		
	}
	
	public synchronized String getDataFromDataRepo(String fieldName) throws Exception
	{
		checkPreRequisites();
		String FilePath = ReusableData.currentDir+"\\testData_cucumber\\"+"\\UI\\"+CommonData.projectName+"\\DataRepo.xlsx";
		String datasheetName = "Data";
		FileInputStream ExcelFile = new FileInputStream(FilePath);
		// Access the required test data sheet
		ExcelWBook = new XSSFWorkbook(ExcelFile);
		ExcelWSheet = ExcelWBook.getSheet(datasheetName);		
		Row = ExcelWSheet.getRow(0);
		int rownum =0;
		int colnum =0;
		String scenario = CommonData.scenarioName;
		for(int i=1;i<=ExcelWSheet.getLastRowNum();i++)
		{
			String a = ExcelWSheet.getRow(i).getCell(0).getStringCellValue();								
			if(a.equalsIgnoreCase(scenario))
			{	
					rownum = i;
					break;
				
			}
		}
		
		scenario = ExcelWSheet.getRow(rownum).getCell(1).getStringCellValue();	
		
		rownum =0;
		
		for(int i=1;i<=ExcelWSheet.getLastRowNum();i++)
		{
			String a = ExcelWSheet.getRow(i).getCell(0).getStringCellValue();								
			if(a.equalsIgnoreCase(scenario))
			{	
					rownum = i;
					break;				
			}
		}
		
		if(fieldName.contains("run_"))
		{
			fieldName = fieldName.substring(fieldName.indexOf("_")+1);
		}
		
		for(int j=1;j<=Row.getLastCellNum();j++)
		{
			if(Row.getCell(j).getStringCellValue().equalsIgnoreCase(fieldName))
			{
				colnum = j;
				break;
			}
		}
		
		String value = null;
		try {
			value = getCellData(rownum, colnum);
		} catch (Exception e) {			
			
		}	
		FileOutputStream out = new FileOutputStream(FilePath);
		ExcelWBook.write(out);
		out.close();
		ExcelFile.close();		
		
		return value;
	}
	
	
}
