package com.testautomation.PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.testautomation.Config.InstanceContainer;
import com.testautomation.PageUI.ExposurePageUI;
import com.testautomation.PageUI.MSPDetailsPageUI;
import com.testautomation.reusableComponents.ReusableComponents;

public class MSPDetailsPage extends PageBase{

	public MSPDetailsPage(InstanceContainer ic) {
		super(ic);
		
	}

	public void addMSPDetails(String exposureName) throws Exception
	{
		String insuranceType = excelData.getCommonData("MSPInsuranceType");
		String insuranceLimit = excelData.getCommonData("InsuranceLimit");
		String claimStatus = excelData.getCommonData("ClaimStatus");
		String cmsAction = excelData.getCommonData("CMSAction");
		String stopProcessingDesc = excelData.getCommonData("StropProcessingDescription");
		
		wh.clickElement(ExposurePageUI.ExposureLink, "Exposure Link");
		if(exposureName.equalsIgnoreCase("Bodily Injury"))
		{
			wh.clickElement(ExposurePageUI.bodilyInjuryLink, "Bodily injury exposure link");
		}
		else if(exposureName.equalsIgnoreCase("Med Pay"))
		{
			wh.clickElement(ExposurePageUI.medPayLink, "Med Pay exposure link");
		}
		
		wh.clickElement(MSPDetailsPageUI.editLink, "MSP Details Edit Link");
		wh.clickElement(MSPDetailsPageUI.MSPDetailsTab, "MSP Details Tab");
		wh.selectDropDownValue(MSPDetailsPageUI.insuranceType, insuranceType, "Insurance Type");
		wh.waitForElementPresent(MSPDetailsPageUI.noFaultInsuranceLimit);
		wh.enterValue(MSPDetailsPageUI.noFaultInsuranceLimit, insuranceLimit, "No Fault insurance Limit");
		wh.selectDropDownValue(MSPDetailsPageUI.claimStatus, claimStatus, "Claim Status");
		wh.selectDropDownValue(MSPDetailsPageUI.cmsActionList, cmsAction, "CMS Action");
		driver.findElement(MSPDetailsPageUI.mspUpdate).click();
		wh.waitForElementPresent(MSPDetailsPageUI.stopProcessingDesc);
		wh.enterValue(MSPDetailsPageUI.stopProcessingDesc, stopProcessingDesc, "Stop Processing Description");
		wh.clickElement(MSPDetailsPageUI.mspUpdate, "MSP Details Update Button");		
		
	}
	
public void addMSPDetails1(String exposureName, String ssnStatus, String mbiStatus) throws Exception {
		
		String ssnID = excelData.getCommonData("SSNID");
		String mbiID = excelData.getCommonData("MBIID");
		String tpocDate = ReusableComponents.getCurrentDate();
		String tpocAmount = excelData.getCommonData("TPOCAmount");
		String icdCode = excelData.getCommonData("ICDCode");
		String dob = excelData.getCommonData("InjuredDOB");
		
		
		wh.clickElement(ExposurePageUI.ExposureLink, "Exposure Link");
		if(exposureName.equalsIgnoreCase("Bodily Injury"))
		{
			wh.clickElement(ExposurePageUI.bodilyInjuryLink, "Bodily injury exposure link");
		}
		else if(exposureName.equalsIgnoreCase("Med Pay"))
		{
			wh.clickElement(ExposurePageUI.medPayLink, "Med Pay exposure link");
		}
		
		wh.clickElement(MSPDetailsPageUI.editLink, "MSP Details Edit Link");
		wh.clickElement(MSPDetailsPageUI.MSPDetailsTab, "MSP Details Tab");
		wh.clickElement(MSPDetailsPageUI.tpocAddBtn, "TPOC Add");
		wh.enterValue(MSPDetailsPageUI.tpocDate, tpocDate, "TPOCDate");
		wh.enterValue(MSPDetailsPageUI.tpocAmount, tpocAmount, "TPOC amount");
		wh.selectDropDownValue(MSPDetailsPageUI.closeFuture, "Yes", "Close Future");
		wh.clickElement(MSPDetailsPageUI.icd, "ICD Add");
		wh.enterValue(MSPDetailsPageUI.icdText, icdCode, "ICD Code");
		driver.findElement(By.xpath("//input[contains(@name,'MSPDetailsDV-proposedsettlementamount')]")).click();
		Thread.sleep(3000);		
		
		wh.waitForElementPresent(MSPDetailsPageUI.MSPDetailsTab);
		if(ssnStatus.equalsIgnoreCase("SSN exists") && mbiStatus.equalsIgnoreCase("MBI not exists"))
		{		
			wh.clickElement(MSPDetailsPageUI.injuredPerson, "Injured person");
			wh.clickElement(MSPDetailsPageUI.contactEditBtn, "Contact Edit");
			wh.enterValue(MSPDetailsPageUI.dobTxt, dob, "Injure Date of Birth");
			wh.selectDropDownValue(MSPDetailsPageUI.gender, "Male", "Gender");
			wh.clickElement(MSPDetailsPageUI.contactOkBtn, "Contact OK");
			wh.waitForElementPresent(MSPDetailsPageUI.MSPDetailsTab);
			
			WebElement mspUpdate = driver.findElement(By.xpath("//div[contains(@id,'ExposureDetail-ExposureDetailScreen-Update')]"));
			
			for(int i=0;i<3;i++)
			{
				try {
					if(mspUpdate.isDisplayed())
					{
						mspUpdate.click();
						Thread.sleep(2000);
					}
				} catch (Exception e) {
					
				}
			}
			
			String ssnIDApplication = wh.getText(MSPDetailsPageUI.ssnID);
			String ssn[] = ssnIDApplication.split("-");
			if(ssnID.contains(ssn[2]))				
			{
				if(wh.isElementNotExists(MSPDetailsPageUI.mbi))
				report.updateTestLog("MSPDetails", "SSN exists and MBI not exists", Status.PASS);
			}
			else
			{
				report.updateTestLog("MSPDetails", "SSN not exists and MBI not exists", Status.FAIL);
			}
			
		}
		
		else if(ssnStatus.equalsIgnoreCase("SSN not exists") && mbiStatus.equalsIgnoreCase("MBI exists"))
		{
			wh.clickElement(MSPDetailsPageUI.injuredPerson, "Injured person");
			wh.clickElement(MSPDetailsPageUI.contactEditBtn, "Contact Edit");
			wh.enterValue(MSPDetailsPageUI.dobTxt, dob, "Injure Date of Birth");
			wh.selectDropDownValue(MSPDetailsPageUI.gender, "Male", "Gender");
			wh.clickElement(MSPDetailsPageUI.taxIDDropdown, "Tax ID dropdown");
			wh.clickElement(MSPDetailsPageUI.taxIDDelete, "Tax ID Delete");
			wh.enterValue(MSPDetailsPageUI.mbiValue, mbiID, "MBI ID");
			wh.clickElement(MSPDetailsPageUI.contactOkBtn, "Contact OK");
			wh.waitForElementPresent(MSPDetailsPageUI.MSPDetailsTab);
			WebElement mspUpdate1 = driver.findElement(By.xpath("//div[contains(@id,'ExposureDetail-ExposureDetailScreen-Update')]"));
			
			for(int i=0;i<3;i++)
			{
				try {
					if(mspUpdate1.isDisplayed())
					{
						mspUpdate1.click();
						Thread.sleep(2000);
					}
				} catch (Exception e) {
					
				}
			}
			String mbiValue = wh.getText(MSPDetailsPageUI.mbi);
			String mbiVal = mbiValue.substring(mbiValue.length()-5);
			if(mbiID.contains(mbiVal))
			{
				if(wh.isElementNotExists(MSPDetailsPageUI.ssnID))
				report.updateTestLog("MSPDetails", "SSN not exists and MBI exists", Status.PASS);
			}
			else
			{
				report.updateTestLog("MSPDetails", "SSN not exists and MBI not exists", Status.FAIL);
			}
		
		
			
		}
		
		
	}
	
}
