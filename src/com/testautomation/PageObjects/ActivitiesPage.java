package com.testautomation.PageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.testautomation.Config.InstanceContainer;
import com.testautomation.PageUI.ActivitiesPageUI;

public class ActivitiesPage extends PageBase{

	public ActivitiesPage(InstanceContainer ic) {
		super(ic);
		
	}
	
	public void closeActivities() throws IOException
	{
		wh.clickElement(ActivitiesPageUI.activitiesLink, "Activities Link");
//		wh.clickElement(activitiesPageUI.checkBox, "Activities Check box");
		List<WebElement> li = driver.findElements(By.xpath("//div[contains(@id,'ClaimWorkplan-ClaimWorkplanScreen-WorkplanLV')]//input[@type='checkbox']"));

		System.out.println("Check Table check boxes:" + (li.size() - 1));
		WebElement completeBtn = null;
		String disableCheckFlag ="";
		
		for (int i11 = 1; i11 <li.size(); i11++) 
		{
			li.get(i11).click();
			
			try {
				completeBtn = driver.findElement(By.xpath("(//div[contains(@id,\"ClaimWorkplan-ClaimWorkplanScreen-ClaimWorkplan_CompleteButton\")]/div)[1]"));
				disableCheckFlag=completeBtn.getAttribute("class"); //button_disabled or button
			} catch (Exception e) {				
				disableCheckFlag = "disabled";
			}
			if (disableCheckFlag.contains("disabled")) {
				li.get(i11).click();
			}
		}
		completeBtn.click();
	}
	
	

}
