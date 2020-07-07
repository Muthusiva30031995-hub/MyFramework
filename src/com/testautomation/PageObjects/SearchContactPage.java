package com.testautomation.PageObjects;

import com.testautomation.Config.InstanceContainer;
import com.testautomation.PageUI.SearchContactPageUI;

public class SearchContactPage extends PageBase{

	public SearchContactPage(InstanceContainer ic) {
		super(ic);		
	}

	
	public void searchContact() throws Exception {
			
		String lastName = excelData.getCommonData("ContactLastName");
		String taxID = excelData.getCommonData("TaxID");
		if(wh.isElementPresent(SearchContactPageUI.reportedByNameIcon)) {
		wh.clickElement(SearchContactPageUI.reportedByNameIcon,"Reported By Icon");
		wh.clickElement(SearchContactPageUI.search,"Search");
			if(wh.isElementPresent(SearchContactPageUI.lastNameTxt)) {
				wh.enterValue(SearchContactPageUI.lastNameTxt, lastName,"Last Name");
				wh.enterValue(SearchContactPageUI.taxIDTxt, taxID,"Tax ID");
				wh.clickElement(SearchContactPageUI.searchBtn,"Contact search");
				wh.clickElement(SearchContactPageUI.selectBtn,"Contact select");
				wh.waitForElementPresent(SearchContactPageUI.reportedByNameIcon);
			}
		}
	}
	
	
	
	
	
}
