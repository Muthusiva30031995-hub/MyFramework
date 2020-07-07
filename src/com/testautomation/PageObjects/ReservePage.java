package com.testautomation.PageObjects;

import org.openqa.selenium.By;

import com.testautomation.Config.InstanceContainer;
import com.testautomation.PageUI.ReservePageUI;

public class ReservePage extends PageBase{

	public ReservePage(InstanceContainer ic) {
		super(ic);		
	}
	
	public void createReserve(String exposure,String costType, String costCategory) throws Exception
	{
		String amount1 = excelData.getData("ReserveAmount1");		
		String amount2 = excelData.getData("ReserveAmount2");
		String amount3 = excelData.getData("ReserveAmount3");		
		
		wh.clickElement(ReservePageUI.actionLink, "Action Link");
		wh.clickElement(ReservePageUI.reserveLink, "Reserve Link");
		wh.waitForElementPresent(ReservePageUI.reserveTitle);
		Thread.sleep(2000);
		
		if(wh.isElementExists(ReservePageUI.exposureDropDown1))
		{				
			wh.selectDropDownValue(ReservePageUI.exposureDropDown1, exposure,"Exposure");			
			wh.waitForElementPresent(ReservePageUI.costType1);				
			wh.selectDropDownValue(ReservePageUI.costType1, costType,"Cost type");			
			wh.waitForElementPresent(ReservePageUI.costCategory1);
			wh.selectDropDownValue(ReservePageUI.costCategory1, costCategory,"Cost Category");
			wh.waitForElementPresent(ReservePageUI.availableReserve1);
			wh.enterValue(ReservePageUI.availableReserve1, amount1,"Available Reserve");
			wh.clickElement(ReservePageUI.comments1, "Reserve Title");
		}
		else if(wh.isElementExists(ReservePageUI.exposureDropDown2))
		{			
			wh.selectDropDownValue(ReservePageUI.exposureDropDown2, exposure,"Exposure");			
			wh.waitForElementPresent(ReservePageUI.costType2);			
			wh.selectDropDownValue(ReservePageUI.costType2, costType,"Cost type");		
			wh.waitForElementPresent(ReservePageUI.costCategory2);
			wh.selectDropDownValue(ReservePageUI.costCategory2, costCategory,"Cost category");			
			wh.waitForElementPresent(ReservePageUI.availableReserve2);
			wh.enterValue(ReservePageUI.availableReserve2, amount2,"Available Reserve");
			wh.clickElement(ReservePageUI.comments2, "Reserve Title");
		}
		else if(wh.isElementExists(ReservePageUI.exposureDropDown3))
		{			
			wh.selectDropDownValue(ReservePageUI.exposureDropDown3, exposure,"Exposure");			
			wh.waitForElementPresent(ReservePageUI.costType3);			
			wh.selectDropDownValue(ReservePageUI.costType3, costType,"Cost type");			
			wh.waitForElementPresent(ReservePageUI.costCategory3);
			wh.selectDropDownValue(ReservePageUI.costCategory3, costCategory,"Cost category");			
			wh.waitForElementPresent(ReservePageUI.availableReserve3);
			wh.enterValue(ReservePageUI.availableReserve3, amount3,"Available Reserve");
			wh.clickElement(ReservePageUI.comments3, "Reserve Title");
		}
		
		wh.clickElement(ReservePageUI.reserveTitle, "Reserve Title");		
		wh.clickElement(ReservePageUI.saveButton, "Save button in reserve page");
		wh.waitForElementPresent(ReservePageUI.financialTitle);
		
	}

}
