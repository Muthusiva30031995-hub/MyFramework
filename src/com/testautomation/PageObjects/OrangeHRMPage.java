package com.testautomation.PageObjects;

import com.testautomation.Config.InstanceContainer;
import com.testautomation.PageUI.OrangeHRMPageUI;

public class OrangeHRMPage extends PageBase{

	public OrangeHRMPage(InstanceContainer ic) {
		super(ic);		
	}
	
	public void EditSkills() throws Exception
	{
		wh.mouseMove(OrangeHRMPageUI.adminLink);
		wh.mouseMove(OrangeHRMPageUI.qualificationsLink);
		wh.clickElement(OrangeHRMPageUI.skillsLink, "Skills Link");
		wh.clickElement(OrangeHRMPageUI.GuidewareLink, "Guideware Link");
		wh.enterValue(OrangeHRMPageUI.skillDesc, "1 Year Of Experience", "Skill Description");
		wh.clickElement(OrangeHRMPageUI.saveBtn, "Save Button");
		
	}
	
	public void EditEducation() throws Exception
	{
		wh.mouseMove(OrangeHRMPageUI.adminLink);
		wh.mouseMove(OrangeHRMPageUI.qualificationsLink);
		wh.clickElement(OrangeHRMPageUI.EducationLink, "Education Link");
		wh.enterValue(OrangeHRMPageUI.levelTxt, "UG Graduation", "Level");
		wh.clickElement(OrangeHRMPageUI.saveBtn, "Save Button");
		
	}

}
