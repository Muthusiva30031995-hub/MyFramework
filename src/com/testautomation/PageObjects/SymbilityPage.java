package com.testautomation.PageObjects;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import com.sun.glass.ui.Robot;
import com.testautomation.Config.InstanceContainer;
import com.testautomation.PageUI.DesktopAutomationPageUI;
import com.testautomation.PageUI.LoginSymbilityPageUI;

import winium.elements.desktop.ComboBox;

public class SymbilityPage extends PageBase{

	public SymbilityPage(InstanceContainer ic) {
		super(ic);		
	}

	
	public void enterTextInNotepad(String text) throws Exception {			
		wh.enterValue(DesktopAutomationPageUI.notePageTextArea, text, "Notepad Text area");		
				
	}

	public void clearTextInNotepad() throws Exception {
		wh.clearTextbox(DesktopAutomationPageUI.notePageTextArea, "Notepad entered text");
		
	}

	public void closeTheNotepad() throws Exception
	{
		wh.clickElement(DesktopAutomationPageUI.notePadClose, "Notepad Close button");		
	}


	public void IE() throws Exception
	{
		
		wh.clickElement(DesktopAutomationPageUI.ieMaximizeBtn, "Maximize");		
		wh.clickElement(DesktopAutomationPageUI.ieToolsBtn, "Tools");
		wh.clickElement(DesktopAutomationPageUI.ieInternetOptions, "InternetOptions");
		wh.clickElement(DesktopAutomationPageUI.ieSecurityTab, "Security tab");
		wh.clickElement(DesktopAutomationPageUI.ieCustomLevel, "Custom level");	
		wh.selectDropDownValue(DesktopAutomationPageUI.ResetTodropdown, "Low", "Reset To");
		wh.clickElement(DesktopAutomationPageUI.okBtn, "OK");
	}



	public void LoginSymbility() throws Exception
	{
		String username = excelData.getCommonData("SymbilityUsername");
		String password = excelData.getCommonData("SymbilityPassword");
		wh.enterValue(LoginSymbilityPageUI.userName, username, "Username");
		wh.enterValue(LoginSymbilityPageUI.password, password, "Password");		
		Thread.sleep(2000);			
		wh.robotMouseLeftClickByOffset(785, 424);		 		
		Thread.sleep(5000);
		if(wh.isElementExists(LoginSymbilityPageUI.synchronizeBtn))
		{
			report.updateTestLog("Login", "Login is success", Status.PASS);
		}
		else
		{
			report.updateTestLog("Login", "Login is not success", Status.FAIL);
		}
	}
	
	public void seachClaim() throws Exception
	{
		wh.clickElement(LoginSymbilityPageUI.synchronizeBtn, "Synchronize Button");
		Thread.sleep(30000);		
		wh.robotMouseLeftClickByOffset(172, 688);
		Thread.sleep(1000);
		wh.enterValue(LoginSymbilityPageUI.searchClaimsTxt, "222066P", "Search Claims Text field");
		wh.robotEnter();
		Thread.sleep(3000);
	}







}
