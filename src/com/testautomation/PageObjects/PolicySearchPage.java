package com.testautomation.PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.aventstack.extentreports.Status;
import com.testautomation.Config.InstanceContainer;
import com.testautomation.PageUI.PolicySearchPageUI;

public class PolicySearchPage extends PageBase{

	public PolicySearchPage(InstanceContainer ic) {
		super(ic);		
	}
	
	public void searchPolicy(String TypeOfClaim) throws Exception
	{
		String policyData = excelData.getData("Policy");
		String DOL = excelData.getData("DOL");		
		wh.clickElement(PolicySearchPageUI.claimBtn,"ClaimTab");
		wh.clickElement(PolicySearchPageUI.newClaim,"New Claim"); 		
		wh.enterValue(PolicySearchPageUI.policyText, policyData,"Policy number");
		if(DOL!=null) {
			wh.clickWebButton(PolicySearchPageUI.lossDateTrue,"Loss Date Radio Button");
		}
		wh.enterValue(PolicySearchPageUI.lossDateText, DOL,"Loss Date");		
		wh.clickElement(PolicySearchPageUI.searchButton,"Search");		
		
		if(wh.isElementPresent(PolicySearchPageUI.nextBtn)) {
			
			if(TypeOfClaim.equalsIgnoreCase("Liability") || TypeOfClaim==null) {
				wh.clickElement(PolicySearchPageUI.liability,"Liability");
			}
			else if(TypeOfClaim.equalsIgnoreCase("Property")) {
				wh.clickElement(PolicySearchPageUI.property,"Property");
			}
			else if(TypeOfClaim.equalsIgnoreCase("Auto")) {
				wh.clickElement(PolicySearchPageUI.auto,"Auto");
			}
			else if(TypeOfClaim.equalsIgnoreCase("Aviation")) {
				wh.clickElement(PolicySearchPageUI.aviation,"Aviation");
			}
		}
		else if(wh.isElementPresent(By.xpath("//div[contains(text(),'The policy search failed')]")))
		{
			report.updateTestLog("searchPolicy", "Policy Seach Failed", Status.FAIL);
			driver.quit();
		}
		
		wh.clickElement(PolicySearchPageUI.nextBtn,"Next");		
			
		
		
	}
	
	public void searchExistingClaim(String claimNo) throws Exception
	{
		wh.clickElement(PolicySearchPageUI.claimBtn,"ClaimTab");
		wh.enterValue(PolicySearchPageUI.existingClaimText, claimNo,"Claim number");
		wh.clickElement(PolicySearchPageUI.claimSearchImage, "Find Claim Button");
//		wh.waitForElementPresent(PolicySearchPageUI.summaryTitle);
	}
	
	public void step2NextBtn() throws IOException
	{
		if(wh.isElementPresent(PolicySearchPageUI.step2NextBtn)) {
			wh.clickElement(PolicySearchPageUI.step2NextBtn,"Next");
			wh.waitForElementPresent(PolicySearchPageUI.finishBtn);
		}
	}
	

}
