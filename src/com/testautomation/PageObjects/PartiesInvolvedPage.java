package com.testautomation.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.testautomation.Config.InstanceContainer;
import com.testautomation.PageUI.PartiesInvolvedPageUI;

public class PartiesInvolvedPage extends PageBase{

	public PartiesInvolvedPage(InstanceContainer ic) {
		super(ic);
	}
public void updatingContacts(String contactType,String contactName) throws Exception{
	
	String textingcontacts_select_xpath ="//td[contains(@id,'ClaimContacts-ClaimContactsScreen-PeopleInvolvedDetailedListDetail-PeopleInvolvedDetailedLV')]//div[@class='gw-cell-inner']//div[contains(@id,'ClaimContacts-ClaimContactsScreen-PeopleInvolvedDetailedListDetail-PeopleInvolvedDetailedLV')]//div//div[contains(text(),'" + contactName + "')]";
	String mobileNumber = excelData.getCommonData("MobileNumber");
	wh.clickElement(PartiesInvolvedPageUI.partiesInvoluedLink,"Parties Involved Link");
    wh.clickElement((By.xpath(textingcontacts_select_xpath)), "Parties Invouled Contact" );
    wh.clickElement(PartiesInvolvedPageUI.contactEdit,"Contact Edit");
    
    if(contactType.equalsIgnoreCase("Mobile")) {   
    wh.enterValue(PartiesInvolvedPageUI.mobileNumber,mobileNumber,"Mobile Number");
    wh.selectDropDownValue(PartiesInvolvedPageUI.primaryPhone, contactType, "Primary Phone");
    }
    
    try {
		WebElement updateBtn = driver.findElement(By.xpath("//div[contains(@id,'ContactBasicsDV_tb-ContactDetailToolbarButtonSet-Update')]/div"));
		for(int i=0;i<2;i++) {	
			
			if(updateBtn.isDisplayed())
			{
				updateBtn.click();
			}
			else 
				break;
		}
	} catch (Exception e) {
		
	}
    
 }
    
    


public void addingExistingContact(String contactName) throws Exception {
	String contactRole = excelData.getCommonData("ContactRole");
	wh.clickElement(PartiesInvolvedPageUI.partiesInvoluedLink,"Parties Involved Link");
	wh.clickElement(PartiesInvolvedPageUI.addExistingBtn,"Adding Existing Button");
	wh.enterValue(PartiesInvolvedPageUI.lastName,contactName,"Last Name");
	wh.clickElement(PartiesInvolvedPageUI.contactSearch,"Search Button");
	wh.clickElement(PartiesInvolvedPageUI.contactSelect,"Select Button");
	wh.clickElement(PartiesInvolvedPageUI.addBtn,"Add Button");
	wh.selectDropDownValue(PartiesInvolvedPageUI.roleList,contactRole,"Contact Role");
	wh.clickElement(PartiesInvolvedPageUI.contactUpdate,"Contact Update Button");
}
}
