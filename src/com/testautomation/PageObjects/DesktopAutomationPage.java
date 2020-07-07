package com.testautomation.PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.testautomation.Config.InstanceContainer;
import com.testautomation.PageUI.DesktopAutomationPageUI;

import winium.elements.desktop.ComboBox;

public class DesktopAutomationPage extends PageBase{

	public DesktopAutomationPage(InstanceContainer ic) {
		super(ic);		
	}

	
	public void enterTextInNotepad(String text) throws Exception {			
		wh.enterValue(DesktopAutomationPageUI.notePageTextArea, text, "Notepad Text area");		
				
	}

	public void clearTextInNotepad() throws Exception {
		wh.clearTextbox(DesktopAutomationPageUI.notePageTextArea, "Notepad entered text");
		
	}

	public void closeTheNotepad() throws IOException
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










}
