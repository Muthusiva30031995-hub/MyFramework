package com.testautomation.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.testautomation.Config.InstanceContainer;
import com.testautomation.PageUI.CloseClaimPageUI;

public class CloseClaimPage extends PageBase{

	public CloseClaimPage(InstanceContainer ic) {
		super(ic);
		
	}
	
	public void closeClaim() throws Exception
	{
		String closeClaimNoteText = excelData.getCommonData("CloseClaimNoteText");
		wh.clickElement(CloseClaimPageUI.actionLink, "Action Link");
		wh.clickElement(CloseClaimPageUI.closeClaimLink, "Close Claim Button");
		wh.enterValue(CloseClaimPageUI.noteText, closeClaimNoteText,"Close Claim Note text");
		wh.selectDropdownByVisibleText(CloseClaimPageUI.outcomeList, "Completed","Outcome");
		wh.clickElement(CloseClaimPageUI.closeCloseClaim, "Close Claim Button");
		Thread.sleep(2000);
		//WebElement ele = driver.findElement(By.xpath("//div[text()='This claim has open activities. To close the claim, you must first complete or skip all open activities. Please complete or skip these activities before closing the claim.']"));
		
	}

}
