package com.testautomation.Config;

import org.openqa.selenium.WebDriver;

import com.testautomation.WrapperComponent.WebDriverHelper;
import com.testautomation.reusableComponents.ExcelDataAccess;
import com.testautomation.reusableComponents.Report;
import com.testautomation.reusableComponents.ReusableComponents;

public class InstanceContainer {
	
	public WebDriver driver;
	public WebDriverHelper wh;
	public ReusableComponents rc;
	public CommonData commonData;
	public ExcelDataAccess excelData;
	public Report report;
	
	public InstanceContainer(WebDriver driver,WebDriverHelper wh,ReusableComponents rc,CommonData commonData,ExcelDataAccess excelData,Report report) {
		this.driver = driver;
		this.wh = wh;
		this.rc = rc;
		this.commonData = commonData;
		this.excelData=excelData;
		this.report = report;
	}

	
	
	

}
