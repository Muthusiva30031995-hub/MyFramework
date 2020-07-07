package com.testautomation.PageObjects;

import java.util.Random;

import com.aventstack.extentreports.Status;
import com.testautomation.Config.InstanceContainer;
import com.testautomation.PageUI.PaymentPageUI;
import com.testautomation.PageUI.RecoveryPageUI;

public class RecoveryPage extends PageBase{

	public RecoveryPage(InstanceContainer ic) {
		super(ic);
		
	}
	
	public void createRecovery() throws Exception
	{
		String payerList = excelData.getData("PayerList");
		String reserve = excelData.getData("RecoveryReserveLine");
		String recoveryCategory = excelData.getData("RecoveryCategory");
		String comments = excelData.getCommonData("RecoveryComments");
		String RecoverycheckNumber = excelData.getCommonData("RecoveryCheckNumber");
		String lineItemCategory = excelData.getData("RecoveryItemCategory");
		String amount = excelData.getData("RecoveryAmount");
		
		wh.clickElement(PaymentPageUI.financialLink, "Financial Link");
		wh.clickElement(RecoveryPageUI.actionLink, "Action Link");
		wh.waitForElementPresent(RecoveryPageUI.otherLink);
		wh.moveToElement(RecoveryPageUI.otherLink);
		wh.clickElement(RecoveryPageUI.recoveryLink, "Recovery Link");		
		wh.waitForElementPresent(RecoveryPageUI.payerList);
		wh.selectDropDownValue(RecoveryPageUI.payerList, payerList,"Payer");
		wh.selectDropDownValue(RecoveryPageUI.reserveLine, reserve,"Reserve Line");		
		//wh.waitForElementPresent(RecoveryPageUI.payerCheckNumberTxt);
		//String RecoverycheckNumber = String.valueOf(getRandomCheckNumber());		
		wh.enterValue(RecoveryPageUI.payerCheckNumberTxt, RecoverycheckNumber,"Check number");
		wh.selectDropDownValue(RecoveryPageUI.RecoveryCategory, recoveryCategory,"Recovery Category");
		wh.enterValue(RecoveryPageUI.recoveryComments, comments,"Comments");
		wh.selectDropDownValue(RecoveryPageUI.lineItemsCategoryList, lineItemCategory,"Category");		
		wh.waitForElementPresent(RecoveryPageUI.lineItemAmount);
		wh.enterValue(RecoveryPageUI.lineItemAmount, amount,"Line item amount");
		
		for(int i=0;i<3;i++)
		{
			if(wh.isElementExists(RecoveryPageUI.recoveryUpdateBtn))
			{
				wh.clickElement(RecoveryPageUI.recoveryUpdateBtn, "Recovery Update Button");
				Thread.sleep(2000);
			}
		}
		
		wh.waitForElementPresent(PaymentPageUI.financialsTransactionsTitle);
		
		
	}
	
	
	private int getRandomCheckNumber()
	{
		Random random = new Random();
		int checkNumber = Math.round(Math.round(Math.random()*(Math.pow(10, 6))));		
		return checkNumber;
	}

}
