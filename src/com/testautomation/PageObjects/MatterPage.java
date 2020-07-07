package com.testautomation.PageObjects;

import java.io.IOException;

import com.testautomation.Config.InstanceContainer;
import com.testautomation.PageUI.MatterPageUI;

public class MatterPage extends PageBase{

	public MatterPage(InstanceContainer ic) {
		super(ic);
	}
	
	public void createMatter() throws Exception
	{
		String matterType = excelData.getData("MatterType");
		String matterName = excelData.getCommonData("MatterName");
		String plantiff = excelData.getData("Plantiff");
		String defendant = excelData.getData("Defendant");
		String relatedExposure = excelData.getData("RelatedExposure");		
		String courtType = excelData.getCommonData("CourtType");
		String courtDistrict = excelData.getData("CourtDistrict");
		String legalSpeciality = excelData.getData("LegalSpeciality");
		String primaryCause = excelData.getData("PrimaryCause");		
		wh.clickElement(MatterPageUI.litigationLink, "Litigation link");
		wh.clickElement(MatterPageUI.newMatterBtn, "New Matter");
		wh.waitForElementPresent(MatterPageUI.matterTitle);
		wh.selectDropDownValue(MatterPageUI.matterTypeList, matterType,"Matter type");
		wh.enterValue(MatterPageUI.matterNameTxt, matterName,"Matter Name");
		wh.clickElement(MatterPageUI.plantiffAddBtn, "Plantiff Add button");
		wh.waitForElementPresent(MatterPageUI.plantiffContactList);
		wh.selectDropDownValue(MatterPageUI.plantiffContactList, plantiff,"Plantiff");
		wh.waitForElementPresent(MatterPageUI.defendantAddBtn);
		wh.clickElement(MatterPageUI.defendantAddBtn, "Defecndant Add button");
		wh.selectDropDownValue(MatterPageUI.defendantContactList, defendant,"Defendant");
		wh.clickElement(MatterPageUI.exposureAddBtn, "Related To Exposure Button");
		wh.waitForElementPresent(MatterPageUI.relatedToExposureList);
		wh.selectDropDownValue(MatterPageUI.relatedToExposureList, relatedExposure,"Related To");
		wh.selectDropDownValue(MatterPageUI.courtTypeList, courtType,"Court type");
		wh.selectDropDownValue(MatterPageUI.courtDistrictDamageList, courtDistrict,"Court district");
		wh.selectDropDownValue(MatterPageUI.legalSpecialityList, legalSpeciality,"Legal speciality");
		wh.selectDropDownValue(MatterPageUI.primaryCauseList, primaryCause,"Primary cause");
		wh.waitForElementPresent(MatterPageUI.matterUpdateBtn);
		wh.clickElement(MatterPageUI.matterUpdateBtn, "Matter Update Button");
		wh.waitForElementPresent(MatterPageUI.closeMatterBtn);
	}
	

}
