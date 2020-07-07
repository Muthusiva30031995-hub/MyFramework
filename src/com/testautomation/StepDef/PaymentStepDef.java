package com.testautomation.StepDef;

import java.io.IOException;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class PaymentStepDef extends UIBaseStepDef{
	
	@And("^Add \"(.*)\" payment for reserveline \"(.*)\"$")
	public void add_check_payment_for_reserveline_1(String paymentType, String reserveLine) throws Exception
	{
		paymentPage.standardCheckPayment(paymentType, reserveLine);
	}
	
	@Then("^Add manual check payment for reserveline \"(.*)\"$")
	public void add_manual_check_payment_for_reserveline_one(String reserveLine) throws Exception
	{
		paymentPage.manualCheckPayment(reserveLine);
	}
	
	@And("^Recode the check amount$")
	public void recode_the_check_amount() throws Exception
	{
		paymentPage.recodePayment();
	}

	@Then("^transfer the check amount$")
	public void transfer_the_check_amount() throws Exception
	{
		paymentPage.transferCheck();
	}
}
