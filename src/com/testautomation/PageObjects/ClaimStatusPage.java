package com.testautomation.PageObjects;

import java.io.IOException;

import com.testautomation.Config.InstanceContainer;
import com.testautomation.PageUI.ClaimStatusPageUI;

public class ClaimStatusPage extends PageBase{

	public ClaimStatusPage(InstanceContainer ic) {
		super(ic);
		
	}

	
	public void claimDateUpdation() throws Exception
	{
		String claimDate = excelData.getData("DOL");		
		wh.clickElement(ClaimStatusPageUI.summaryLink, "Summary Link");
		wh.waitForElementPresent(ClaimStatusPageUI.summaryPageTitle);		
		wh.clickElement(ClaimStatusPageUI.claimStatusLink, "Claim Status Link");
		wh.clickElement(ClaimStatusPageUI.claimStatusEdit, "Edit button");
		wh.enterValue(ClaimStatusPageUI.claimDate, claimDate, "Claim Date");
		wh.clickWebButton(ClaimStatusPageUI.coverageInRadio, "Coverage In Question Radio");
		wh.clickElement(ClaimStatusPageUI.claimStatusUpdate, "Update Button");
		wh.waitForElementPresent(ClaimStatusPageUI.claimStatusTitle);
		
	}
}
