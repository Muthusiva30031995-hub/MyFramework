package com.testautomation.PageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.testautomation.Config.InstanceContainer;
import com.testautomation.PageUI.ExposurePageUI;

public class ExposurePage extends PageBase{

	public ExposurePage(InstanceContainer ic) {
		super(ic);
		
	}
	
	String lossParty = null;
	String statisticalLine = null;
	String claimant = null;
	String type = null;
	String dwellingIncident = null;
	String damageDescription = null;
	String propertyInfo = null;
	String State_Of_Jurisdiction = null;
	String jurisdictionList = null;
	String KOL = null;
	
	
	public void exposureNavigation(String exposureName,String navigation) throws IOException
	{
		String[] path = navigation.split("-");	
		String item1=null;
		String item2=null;
		String item3 = null;
		String item4 = null;
		String item5 = null;
				
		if(path[0]!=null) {
			item1= path[0].substring(path[0].length()-1);
			if(item1.contentEquals("a"))
				item1 = "0";
			if(item1 .contentEquals("b"))
				item1 = "1";
		}
		if(path[1]!=null) {
			item2 = path[1].substring(path[1].length()-1);
			if(item2.contentEquals("a"))
				item2 = "0";
			if(item2.contentEquals("b"))
				item2 = "1";
			if(item2.contentEquals("c"))
				item2 = "2"; 	
			
		}
		if(path[2]!=null) {
			item3 = path[2].substring(path[2].length()-1);
			if(item3.contentEquals("a"))
				item3 = "0";
			if(item3.contentEquals("b"))
				item3 = "1";
			if(item3.contentEquals("c"))
				item3 = "2";
			if(item3.contentEquals("d"))
				item3 = "3";
			if(item3.contentEquals("e"))
				item3 = "4";
			if(item3.contentEquals("f"))
				item3 = "5";
			if(item3.contentEquals("g"))
				item3 = "6";
			if(item3.contentEquals("h"))
				item3 = "7";
			if(item3.contentEquals("i"))
				item3 = "8"; 
		}
		if(path[3]!=null) {
			item4 = path[3].substring(path[3].length()-1);
			if(item4.contentEquals("a"))
				item4 = "0";
			if(item4.contentEquals("b"))
				item4 = "1";
			if(item4.contentEquals("c"))
				item4 = "2";
			if(item4.contentEquals("d"))
				item4 = "3";
			if(item4.contentEquals("e"))
				item4 = "4";
		}
		if(path[4]!=null) {
			item5 = path[4].substring(path[4].length()-1);
			if(item5.contentEquals("a"))
				item5 = "0";
			if(item5.contentEquals("b"))
				item5 = "1";
			if(item5.contentEquals("c"))
				item5 = "2";
			if(item5.contentEquals("d"))
				item5 = "3";
			if(item5.contentEquals("e"))
				item5 = "4";
		} 	
		
		By xpath1 = By.xpath("//div[@id=\"Claim-ClaimMenuActions-ClaimMenuActions_NewExposure-NewExposureMenuItemSet-"+item1+"-item\"]");
		By xpath2 = By.xpath("//div[@id=\"Claim-ClaimMenuActions-ClaimMenuActions_NewExposure-NewExposureMenuItemSet-"+item1+"-item-"+item2+"-item\"]");
		By xpath3 = By.xpath("//div[@id=\"Claim-ClaimMenuActions-ClaimMenuActions_NewExposure-NewExposureMenuItemSet-"+item1+"-item-"+item2+"-item-"+item3+"-item\"]");	
		By xpath4 = By.xpath("//div[@id=\"Claim-ClaimMenuActions-ClaimMenuActions_NewExposure-NewExposureMenuItemSet-"+item1+"-item-"+item2+"-item-"+item3+"-item-"+item4+"-item\"]");
		By xpath5 = By.xpath("//div[@id=\"Claim-ClaimMenuActions-ClaimMenuActions_NewExposure-NewExposureMenuItemSet-"+item1+"-item-"+item2+"-item-"+item3+"-item-"+item4+"-item-"+item5+"-item\"]");
		
		wh.clickElement(ExposurePageUI.ExposureLink, "Exposure Link");
		wh.waitForElementPresent(ExposurePageUI.ExposureTitle);
		wh.clickElement(ExposurePageUI.actionsLink, "Actions Link");
		wh.waitForElementPresent(ExposurePageUI.newExposureText);
		if((xpath1!=null) && !(xpath1.equals("")))
		{
//		driver.findElement(xpath1).click();
//		driver.findElement(xpath1).click();
			wh.moveToElement(xpath1);
		}
		if((xpath2!=null) && !(xpath2.equals("")))
		{
//		driver.findElement(xpath2).click();
//		driver.findElement(xpath2).click();
		wh.moveToElement(xpath2);
		}
		if((xpath3!=null) && !(xpath3.equals("")))
		{
//		driver.findElement(xpath3).click();
//		driver.findElement(xpath3).click();
		wh.moveToElement(xpath3);
		}
		if((xpath4!=null) && !(xpath4.equals("")))
		{
//		driver.findElement(xpath4).click();
//		driver.findElement(xpath4).click();
		wh.moveToElement(xpath4);
		}
		if((xpath5!=null) && !(xpath5.equals("")))
		{
		wh.clickElement(xpath5, item5+" path");
		}
		System.out.println("Landing on "+ exposureName+ " Page");
	}
	
	
	public void exposureNavigationByName(String exposureName,String navigation) throws IOException
	{
		String[] path = navigation.split("_");	
		String item1=null;	
				
		if(path[0]!=null) {
			item1= path[0].substring(path[0].length()-1);
			if(item1.contentEquals("a"))
				item1 = "0";
			if(item1 .contentEquals("b"))
				item1 = "1";
		}
		
		
		By xpath1 = By.xpath("//div[@id=\"Claim-ClaimMenuActions-ClaimMenuActions_NewExposure-NewExposureMenuItemSet-"+item1+"-item\"]");		
		wh.waitForPageToLoad();		
		By xpath2 = By.xpath("//div[text()="+"'"+path[1]+"'"+"]/..");
		
		wh.clickElement(ExposurePageUI.ExposureLink, "Exposure Link");
		wh.waitForElementPresent(ExposurePageUI.ExposureTitle);
		wh.clickElement(ExposurePageUI.actionsLink, "Actions Link");
		wh.waitForElementPresent(ExposurePageUI.newExposureText); 
		wh.moveToElement(xpath1);		
		wh.clickElement(xpath2, navigation+" Exposure Coverage");
		System.out.println("Landing on "+ exposureName+ " Exposure Page");
	}
	
	
	
	public void ExposureUpdation(String exposure_Order) throws Exception
	{
		if(exposure_Order.equalsIgnoreCase("1")) {		
		lossParty = excelData.getData("LossParty1");	
		statisticalLine = excelData.getData("StatisticalLine1");
		claimant = excelData.getData("Claimant1");
		type = excelData.getData("Type1");		
		damageDescription = excelData.getData("GeneralDamageDescription1");	
		propertyInfo = excelData.getData("PropertyInfo1");
		State_Of_Jurisdiction = excelData.getData("State Of Jurisdiction1");
		jurisdictionList = excelData.getData("Jurisdiction1");
		KOL = excelData.getData("KOL1");		
		}
		else if(exposure_Order.equalsIgnoreCase("2")) {		
			lossParty = excelData.getData("LossParty2");	
			statisticalLine = excelData.getData("StatisticalLine2");
			claimant = excelData.getData("Claimant2");
			type = excelData.getData("Type2");
			damageDescription = excelData.getData("GeneralDamageDescription2");
			propertyInfo = excelData.getData("PropertyInfo2");
			State_Of_Jurisdiction = excelData.getData("State Of Jurisdiction2");
			jurisdictionList = excelData.getData("Jurisdiction2");
			KOL = excelData.getData("KOL2");
			}
		
		if(wh.isElementPresent(ExposurePageUI.newExposureTitle)) {		
			if(wh.isElementPresent(ExposurePageUI.lossParty)) {
				if((lossParty!=null) && !(lossParty.equals(""))) {
				wh.selectDropDownValue(ExposurePageUI.lossParty, lossParty,"Loss party");
			}
		}	
			
		 
		if(wh.isElementPresent(ExposurePageUI.statisticalLine)) {		
		if((statisticalLine!=null) && !(statisticalLine.equals("")))
			{
			wh.selectDropDownValue(ExposurePageUI.statisticalLine, statisticalLine,"Statistical Line");
				
		   }
		}
		if(wh.isElementPresent(ExposurePageUI.claimant)) {
			
				if((claimant!=null) && !(claimant.equals("")))
				{					
				wh.selectDropDownValue(ExposurePageUI.claimant, claimant,"Claimant");
					
				}
			} 
		
		if(wh.isElementPresent(ExposurePageUI.type)) {
		
			if((type!=null) && !(type.equals("")))
			{
				
				wh.selectDropDownValue(ExposurePageUI.type, type,"Type");
				
			}
		} 
		
		
		if(wh.isElementExists(ExposurePageUI.damageDescriptionTxt)) {
			
			if((damageDescription!=null) && !(damageDescription.equals("")))
			{
				
				wh.enterValue(ExposurePageUI.damageDescriptionTxt, damageDescription,"DamageDescription");
				
			}
		} 
		
		if(wh.isElementExists(ExposurePageUI.propertyInfoList)) {
			
			if((propertyInfo!=null) && !(propertyInfo.equals("")))
			{
				
				wh.enterValue(ExposurePageUI.propertyInfoList, propertyInfo,"Property Incident");
				
			}
		} 
		
		if(wh.isElementExists(ExposurePageUI.StateOfJurisdiction)) {
			if((State_Of_Jurisdiction!=null) && !(State_Of_Jurisdiction.equals(""))) {			
			wh.selectDropDownValue(ExposurePageUI.StateOfJurisdiction, State_Of_Jurisdiction,"StateOfJurisdiction");
			}
		}
		
		if(wh.isElementExists(ExposurePageUI.JurisdictionList)) {
			if((jurisdictionList!=null) && !(jurisdictionList.equals(""))) {			
			wh.selectDropDownValue(ExposurePageUI.JurisdictionList, jurisdictionList,"Jurisdiction");
			}
		}
		
		if(wh.isElementExists(ExposurePageUI.KOL)) {
		
			if((KOL!=null) && !(KOL.equals("")))
			{
				
				wh.selectDropDownValue(ExposurePageUI.KOL, KOL,"KOL");
				
			}
		}
		
		
			wh.clickElement(ExposurePageUI.exposureUpdate, "Exposure Update Button");
			wh.waitForElementPresent(ExposurePageUI.ExposureTitle);
			wh.clickElement(ExposurePageUI.ExposureLink, "Exposure Link");
		
		}
			
	}

}
