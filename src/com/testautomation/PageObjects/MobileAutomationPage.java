package com.testautomation.PageObjects;

import java.io.IOException;

import com.testautomation.Config.InstanceContainer;
import com.testautomation.PageUI.MobileAutomationPageUI;

public class MobileAutomationPage extends PageBase{

	public MobileAutomationPage(InstanceContainer ic) {
		super(ic);		
	}

	
	public void calculatorAdd() throws Exception
	{
		wh.clickElement(MobileAutomationPageUI.numberSeven, "Number Seven");
		wh.clickElement(MobileAutomationPageUI.plusSymbol, "Plus Symbol");
		wh.clickElement(MobileAutomationPageUI.numberThree, "Number Three");
		wh.clickElement(MobileAutomationPageUI.equals, "Equal To");
	}
	
	
	public void validateAdditionResult() throws Exception
	{
		String expectedResult = excelData.getData("AdditionResult");
		wh.validateText(MobileAutomationPageUI.additionResult, expectedResult, "Result");
		
	}
	
	public void DialNumber() throws Exception
	{
		wh.clickElement(MobileAutomationPageUI.dialIcon, "Dial Icon");
		wh.clickElement(MobileAutomationPageUI.dialNine, "Dial Nine");
		wh.clickElement(MobileAutomationPageUI.dialZero, "Dial Zero");
		wh.clickElement(MobileAutomationPageUI.dialFour, "Dial Four");
		wh.clickElement(MobileAutomationPageUI.dialSeven, "Dial Seven");
		wh.clickElement(MobileAutomationPageUI.dialNine, "Dial Nine");
		wh.clickElement(MobileAutomationPageUI.dialThree, "Dial Three");
		wh.clickElement(MobileAutomationPageUI.dialNine, "Dial Nine");
		wh.clickElement(MobileAutomationPageUI.dialNine, "Dial Nine");
		wh.clickElement(MobileAutomationPageUI.dialTwo, "Dial Two");
		wh.clickElement(MobileAutomationPageUI.dialFour, "Dial Four");
		wh.waitForElementPresent(MobileAutomationPageUI.callIcon);
		String mobileNumber = wh.getText(MobileAutomationPageUI.mobileNumber);
		excelData.writeDataToDataRepo("MobileNumber", mobileNumber);
		wh.clickElement(MobileAutomationPageUI.callIcon, "Call Icon");		
		wh.waitForElementPresent(MobileAutomationPageUI.endCall);
		if(wh.isElementPresent(MobileAutomationPageUI.endCall))
		{
			wh.clickElement(MobileAutomationPageUI.endCall, "End Call");
		}
		
	}
	
}
