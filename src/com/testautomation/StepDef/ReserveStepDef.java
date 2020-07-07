package com.testautomation.StepDef;

import cucumber.api.java.en.And;

public class ReserveStepDef extends UIBaseStepDef{
	
	
	@And("^Create reserve for exposure \"(.*)\" with \"(.*)\" and \"(.*)\"$")
	public void create_reserve_for_exposure_one_with_indemnity_and_Loss(String exposure, String costType,String costCategory) throws Exception
	{
		reservePage.createReserve(exposure, costType,costCategory);
	}

}
