package com.testautomation.PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.testautomation.Config.InstanceContainer;
import com.testautomation.PageUI.FNOLPageUI;

public class FNOLPage extends PageBase{

	public FNOLPage(InstanceContainer ic) {
		super(ic);		
	}
	
	
	
	public void enterDetailsInFNOLPage() throws Exception {
		
		String relationToInsured = excelData.getData("RelationToInsured");
		String claimant = excelData.getData("Claimant");		
		String lossDescription = excelData.getCommonData("FNOLLossDescription");
		String lossCause = excelData.getData("LossCause");
		String lossLocation = excelData.getData("LossLocation");
		String notes = excelData.getCommonData("Notes");
		
		
//		if(!(reportedByName.equals("") && !(reportedByName==null))) {
//            wh.selectDropDownValue(FNOLPageUI.reportedByName, reportedByName, "Reported by name");
//            }
            
            wh.selectDropDownValue(FNOLPageUI.relationToInsured, relationToInsured,"Related To insured");
            if(!(claimant.equals("") && !(claimant==null))) {
            wh.selectDropDownValue(FNOLPageUI.claimant, claimant,"Claimant");
            }
            wh.enterValue(FNOLPageUI.description, lossDescription, "Loss Description");
            wh.selectDropDownValue(FNOLPageUI.lossCause, lossCause,"Loss Cause");
            
            wh.enterValue(FNOLPageUI.notes, notes, "Notes");
            WebElement ele = driver.findElement(By.xpath("//input[contains(@name,'QuickClaimDV-ClaimNumber3')]"));                         
            wh.clickElement(ele);
            
                        
            
            if(wh.isElementExists(FNOLPageUI.fourOrMoreVehicle)) {
                  wh.clickWebButton(FNOLPageUI.fourOrMoreVehicle, "4 or more vehicles");
            }
            
            wh.selectDropDownValue(FNOLPageUI.lossLocation, lossLocation,"Loss Location");
            Thread.sleep(2000);           
            
            wh.waitForElementPresent(FNOLPageUI.claimAssignmnet);
            wh.selectDropDownValue(FNOLPageUI.claimAssignmnet, "#2","Claim Assignment");
            System.out.println("Details entered in FNOL page");

		
	}
	
	public void clickFinish() throws Exception {
		
		if(wh.isElementPresent(FNOLPageUI.finishButton)) {
			wh.clickElement(FNOLPageUI.finishButton,"Finish");
			wh.waitForPageToLoad();			
			
			if (driver.findElements(By.xpath("//div[@id='FNOLWizard-FNOLWizard_FindPolicyScreen-_msgs-0']//div[@class='gw-message']")).size() > 0) {
				wh.clickElement(By.xpath("//div[contains(@class,'heading-1')]//*[contains(text(),'Quick Claim')]"), "Quick Claim");				
				
				
			} else {
				int DuplicateClaims = driver.findElements(By.xpath("//div[text()='Possible Duplicate Claims']")).size();
				if (DuplicateClaims>0) {
					wh.clickElement(FNOLPageUI.finishButton,"Finish");
					wh.waitForPageToLoad();
//					wh.waitForElementToAppear(By.xpath("//*[contains(@id,'NewClaimSavedDV-Header')]/div[1]"));
//					DuplicateClaims = driver.findElements(By.xpath("//div[text()='Possible Duplicate Claims']")).size();
				}
			}
			int finishExists = driver.findElements(By.xpath("//*[contains(@id, 'Finish')]")).size();
			if (finishExists>0) {
				wh.waitForElementToAppear(By.xpath("//*[contains(@id, 'Finish')]"));
				wh.clickElement(FNOLPageUI.finishButton,"Finish");
				int DuplicateClaims = driver.findElements(By.xpath("//div[text()='Possible Duplicate Claims']")).size();
				if (DuplicateClaims>0) {
					wh.clickElement(FNOLPageUI.finishButton,"Finish");
					wh.waitForPageToLoad();
					wh.waitForElementToAppear(By.xpath("//*[contains(@id,'NewClaimSavedDV-Header')]/div[1]"));
					DuplicateClaims = driver.findElements(By.xpath("//div[text()='Possible Duplicate Claims']")).size();
				} else {
					wh.waitForElementToAppear(By.xpath("//*[contains(@id,'NewClaimSavedDV-Header')]/div[1]"));
					if(wh.isElementPresent(FNOLPageUI.newClaimSaved)) {						
						wh.clickElement(FNOLPageUI.newClaimSaved,"View Claim");
						System.out.println("Claim is created successfully");
					}
				}
			}
			else {
				wh.waitForElementToAppear(By.xpath("//*[contains(@id,'NewClaimSavedDV-Header')]/div[1]"));
					if(wh.isElementPresent(FNOLPageUI.newClaimSaved)) {						
					wh.clickElement(FNOLPageUI.newClaimSaved,"View Claim");
					System.out.println("Claim is created successfully");
					}
				}
		}
		wh.waitForElementPresent(FNOLPageUI.summaryPage);
		String claim = wh.getText(FNOLPageUI.claimNumber);
		String claimNumber=claim.substring(claim.indexOf("(")+1,claim.indexOf(")"));
		commonData.claimNumber = claimNumber;		
		System.out.println("Claim number is "+commonData.claimNumber);	
			
		}
		
	
	
}
