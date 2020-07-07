package com.testautomation.StepDef;

import cucumber.api.java.en.And;

public class RecoveryPageStepDef extends UIBaseStepDef{
	
	@And("^Create a recovery$")
	public void create_a_recovery() throws Exception
	{
		recoveryPage.createRecovery();
	}

}
