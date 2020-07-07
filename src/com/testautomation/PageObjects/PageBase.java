package com.testautomation.PageObjects;
import org.openqa.selenium.WebDriver;

import com.testautomation.Config.CommonData;
import com.testautomation.Config.InstanceContainer;
import com.testautomation.WrapperComponent.WebDriverHelper;
import com.testautomation.reusableComponents.ExcelDataAccess;
import com.testautomation.reusableComponents.Report;




public class PageBase{  	
	public InstanceContainer ic;
	public WebDriverHelper wh;
	public ExcelDataAccess  excelData;
	public Report report;
	public WebDriver driver;
	public CommonData commonData;
	
	public PageBase(InstanceContainer ic)
	{
		this.ic = ic;
		this.wh = ic.wh;	
		this.driver = ic.driver;
		this.excelData = ic.excelData;
		this.report = ic.report;
		this.commonData = ic.commonData;

	}

	
}
