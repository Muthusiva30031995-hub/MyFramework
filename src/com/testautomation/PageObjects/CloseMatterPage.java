package com.testautomation.PageObjects;

import java.io.IOException;

import com.testautomation.Config.InstanceContainer;
import com.testautomation.PageUI.CloseMatterPageUI;

public class CloseMatterPage extends PageBase{

	public CloseMatterPage(InstanceContainer ic) {
		super(ic);		
	}

	
	public void closeMatter() throws Exception
	{
		String matterNoteText = excelData.getCommonData("MatterNoteText");
		wh.clickElement(CloseMatterPageUI.litigationLink, "Litigation Link");
		wh.waitForElementPresent(CloseMatterPageUI.matterLink);
		wh.clickElement(CloseMatterPageUI.matterLink, "Matter Link");
		wh.clickElement(CloseMatterPageUI.closeMatterBtn, "Close Matter button");
		wh.waitForElementPresent(CloseMatterPageUI.noteText);
		wh.enterValue(CloseMatterPageUI.noteText, matterNoteText,"Close Matter Note text");
		wh.selectDropdownByVisibleText(CloseMatterPageUI.outcomeList, "Appealed","Outcome");
		wh.clickElement(CloseMatterPageUI.closeCloseMatterBtn, "Close Matter button");
		wh.waitForElementPresent(CloseMatterPageUI.reOpenMatterBtn);
	}
}
