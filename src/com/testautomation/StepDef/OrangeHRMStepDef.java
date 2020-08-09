package com.testautomation.StepDef;

import cucumber.api.java.en.And;

public class OrangeHRMStepDef extends UIBaseStepDef{
	
	@And("^Edit skills$")
	public void edit_skills() throws Exception
	{
		orangeHRMPage.EditSkills();
	}
	
	@And("Edit education")
	public void edit_education() throws Exception
	{
		orangeHRMPage.EditEducation();
	}

}
