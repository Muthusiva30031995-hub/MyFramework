package com.testautomation.PageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.testautomation.Config.InstanceContainer;
import com.testautomation.PageUI.MobileAutomationPageUI;

import io.appium.java_client.android.AndroidElement;

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
	
	public void sendMessage() throws Exception
	{
		String mobileNoToSend = excelData.getData("MobileNumber");
		String messageToSend = excelData.getData("MessageToSend");
		wh.clickElement(MobileAutomationPageUI.newMessage, "New Message");
		wh.enterValue(MobileAutomationPageUI.toNumber, mobileNoToSend, "To");
		Thread.sleep(3000);
		WebElement ele = driver.findElement(MobileAutomationPageUI.toNumber);
		wh.mobileTAB(ele);
		wh.enterValue(MobileAutomationPageUI.messageText, messageToSend, "Message Text Field");
		wh.clickElement(MobileAutomationPageUI.sendMsgSymbol, "Send Message");		
		wh.validateText(MobileAutomationPageUI.messageSent, messageToSend, "Verify Message");	
		
		
	}
	
	
	public void APIDemoOperation1(String text) throws Exception
	{		
		if(wh.isElementExists(MobileAutomationPageUI.licenseOkBtn))
		{
			wh.clickElement(MobileAutomationPageUI.licenseOkBtn, "License Ok Button");
		}
		List<WebElement> list = driver.findElements(By.id("android:id/text1"));
		for(WebElement item:list)
		{
			if(item.getText().contains("API Demos"))
			{
				item.click();
				break;
			}
		}
		AndroidElement list1 = (AndroidElement) driver.findElement(By.id("android:id/text1"));
		wh.mobileScrollToViewAndClick(text);
		
		
		
		
		
	}
	
}
