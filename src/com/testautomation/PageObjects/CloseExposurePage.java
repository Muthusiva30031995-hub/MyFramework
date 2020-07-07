package com.testautomation.PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;

import com.aventstack.extentreports.Status;
import com.testautomation.Config.InstanceContainer;
import com.testautomation.PageUI.CloseExposurePageUI;
import com.testautomation.PageUI.ExposurePageUI;

public class CloseExposurePage extends PageBase{

	public CloseExposurePage(InstanceContainer ic) {
		super(ic);
		
	}

	
	public void closeExposure(String exposureName) throws Exception
	{
		wh.clickElement(CloseExposurePageUI.exposureLink, "Exposure Link");
		wh.waitForElementPresent(ExposurePageUI.ExposureTitle);
		
		if(exposureName.equalsIgnoreCase("Dwelling"))
		{
			wh.clickElement(CloseExposurePageUI.DwellingExposureLink, "Dwelling Exposure Link");
			wh.waitForElementPresent(CloseExposurePageUI.closeExposureLink);
			wh.clickElement(CloseExposurePageUI.closeExposureLink, "Close Exposure Link");			
			wh.waitForElementPresent(CloseExposurePageUI.noteText);
			wh.enterValue(CloseExposurePageUI.noteText, "Dwelling Exposure Closed", "Close Exposure Note text");
			wh.selectDropdownByVisibleText(CloseExposurePageUI.outcomeList, "Completed","Outcome");
		}
		else if(exposureName.equalsIgnoreCase("Bodily Injury"))
		{
			wh.clickElement(CloseExposurePageUI.BodilyInjuryExposureLink, "Bodily Injury Exposure Link");
			wh.clickElement(CloseExposurePageUI.exposureAssign, "Exposure Assign Button");
			wh.selectDropDownValue(CloseExposurePageUI.assignmentList, "Claim/Exposure Owner", "Select From List");
			for(int i=0;i<2;i++)
			{
				try {
					if(wh.isElementExists((CloseExposurePageUI.assignBtn)))
					{
						wh.clickElement(CloseExposurePageUI.assignBtn, "Assign Button");
						Thread.sleep(2000);
					}
				} catch (Exception e) {
					
				}
			}
			
			wh.waitForElementPresent(CloseExposurePageUI.closeExposureLink);
			wh.clickElement(CloseExposurePageUI.closeExposureLink, "Close Exposure Link");			
			wh.waitForElementPresent(CloseExposurePageUI.noteText);
			wh.enterValue(CloseExposurePageUI.noteText, "Bodily Injury Exposure Closed", "Close Exposure Note text");
			wh.selectDropdownByVisibleText(CloseExposurePageUI.outcomeList, "Completed","Outcome");
		}
		else if(exposureName.equalsIgnoreCase("Med Pay"))
		{
			wh.clickElement(CloseExposurePageUI.MedPayExposureLink, "Med Pay Exposure Link");			
			wh.clickElement(CloseExposurePageUI.exposureAssign, "Exposure Assign Button");
			wh.selectDropDownValue(CloseExposurePageUI.assignmentList, "Claim/Exposure Owner", "Select From List");
			for(int i=0;i<2;i++)
			{
				try {
					if(wh.isElementExists((CloseExposurePageUI.assignBtn)))
					{
						wh.clickElement(CloseExposurePageUI.assignBtn, "Assign Button");
						Thread.sleep(2000);
					}
				} catch (Exception e) {
					
				}
			}
			wh.waitForElementPresent(CloseExposurePageUI.closeExposureLink);
			wh.clickElement(CloseExposurePageUI.closeExposureLink, "Close Exposure Link");			
			wh.waitForElementPresent(CloseExposurePageUI.noteText);
			wh.enterValue(CloseExposurePageUI.noteText, "Med Pay Exposure Closed", "Close Exposure Note text");
			wh.selectDropdownByVisibleText(CloseExposurePageUI.outcomeList, "Completed","Outcome");
		}
		else if(exposureName.equalsIgnoreCase("Property"))
		{
			wh.clickElement(CloseExposurePageUI.PropertyExposureLink, "Property Exposure Link");
			wh.waitForElementPresent(CloseExposurePageUI.closeExposureLink);
			wh.clickElement(CloseExposurePageUI.closeExposureLink, "Close Exposure Link");			
			wh.waitForElementPresent(CloseExposurePageUI.noteText);
			wh.enterValue(CloseExposurePageUI.noteText, "Property Exposure Closed","Close Exposure Note text");
			wh.selectDropdownByVisibleText(CloseExposurePageUI.outcomeList, "Completed","Outcome");
		}
		
		else if(exposureName.equalsIgnoreCase("General Damage"))
		{
			wh.clickElement(CloseExposurePageUI.GeneralDamageExposureLink, "General Damage Exposure Link");
			wh.waitForElementPresent(CloseExposurePageUI.closeExposureLink);
			wh.clickElement(CloseExposurePageUI.closeExposureLink, "Close Exposure Link");			
			wh.waitForElementPresent(CloseExposurePageUI.noteText);
			wh.enterValue(CloseExposurePageUI.noteText, "General Damage Exposure Closed","Close Exposure Note text");
			wh.selectDropdownByVisibleText(CloseExposurePageUI.outcomeList, "Completed","Outcome");
		}
		
		else if(exposureName.equalsIgnoreCase("Vehicle"))
		{
			wh.clickElement(CloseExposurePageUI.VehicleExposureLink, "Vehicle Exposure Link");
			wh.waitForElementPresent(CloseExposurePageUI.closeExposureLink);
			wh.clickElement(CloseExposurePageUI.closeExposureLink, "Close Exposure Link");			
			wh.waitForElementPresent(CloseExposurePageUI.noteText);
			wh.enterValue(CloseExposurePageUI.noteText, "Vehicle Exposure Closed","Close Exposure Note text");
			wh.selectDropdownByVisibleText(CloseExposurePageUI.outcomeList, "Completed","Outcome");
		}
		
		
		
		for(int i=0;i<2;i++) {	
			try {
			if(wh.isElementExists(CloseExposurePageUI.closeCloseExposure))
			{	 	
			driver.findElement(By.xpath("//div[@id=\"CloseExposurePopup-CloseExposureScreen-Update\"]")).click();			
			wh.acceptPopup(driver);				
			}
			else 
				break;
			}
			catch(Exception e)
			{
				
			}
		}
		
		wh.waitForElementPresent(CloseExposurePageUI.reOpenExposure);
		
		
	}
	
}
