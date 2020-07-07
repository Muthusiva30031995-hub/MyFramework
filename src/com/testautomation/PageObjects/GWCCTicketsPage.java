package com.testautomation.PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;


import com.aventstack.extentreports.Status;
import com.testautomation.Config.InstanceContainer;
import com.testautomation.PageUI.GWCCTicketsPageUI;


public class GWCCTicketsPage extends PageBase{
	
	
	public GWCCTicketsPage(InstanceContainer ic) {
		super(ic);
	}

	public void claimSearch(String ClaimNO) throws Exception {
	
		wh.clickElement(GWCCTicketsPageUI.SearchButton,"Search Button");
		wh.clickElement(GWCCTicketsPageUI.AdvanceSearchButton,"Advance Search Button");
		wh.enterValue(GWCCTicketsPageUI.LegacyClaim, ClaimNO,"Claim Number");
		wh.clickElement(GWCCTicketsPageUI.searchBtn, "Seach Button");
	}
	
	
	public void validateErrorMessage(String error) throws IOException
	{
		String xpath = "//div[contains(@id,'ClaimSearch-ClaimSearchScreen-_msgs-0')]/div/div[2]/div/div[2][contains(text(),"+"'"+error+"')]";
		//WebElement ele = driver.findElement(By.xpath(xpath));
		if(wh.isElementNotExists(By.xpath(xpath)))
		{
			report.updateTestLog("validateErrorMessage","Error did not occured and search passed", Status.PASS);
		}
		else 
		{
			report.updateTestLog("validateErrorMessage","Error occured and serch failed" ,Status.FAIL);
		}
	}
	
	
	public void openResultedClaim() throws Exception {
		
		String xpath = "//div[contains(@id,'ClaimSearchResultsLV-0-ClaimNumber_button')]";
		wh.clickElement(By.xpath(xpath),"Search results Claim");
		wh.waitForElementPresent(GWCCTicketsPageUI.summary);
		
	}

	public void policySearch(String policyNo) throws Exception {
		
		wh.clickElement(GWCCTicketsPageUI.SearchButton,"Search Button");
		wh.clickElement(GWCCTicketsPageUI.AdvanceSearchButton,"Advance Search Button");
		wh.enterValue(GWCCTicketsPageUI.policySearch, policyNo, "Policy Number");
		wh.clickElement(GWCCTicketsPageUI.searchBtn, "Seach Button");
		
	}
	
}

