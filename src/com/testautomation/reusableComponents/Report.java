package com.testautomation.reusableComponents;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.testautomation.Config.CommonData;
import com.testautomation.Config.ReusableData;
import com.testautomation.TestRunner.TestRunnerUI;

import cucumber.api.Scenario;

public class Report {
	
	public static ExtentHtmlReporter htmlReporter;
	 public static ExtentReports extent;
	 public ExtentTest test;	 
	 WebDriver driver;
	 
	 
	 public Report(ExtentTest test) {
		 
		 this.test = test; 
		  
	 }
	 
	public static ExtentReports setup(String reportLocation) {
		htmlReporter = new ExtentHtmlReporter(reportLocation);
		htmlReporter.config().setDocumentTitle("BDD Cucumber Automation");
		htmlReporter.config().setReportName("Automation Test Report");		        
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.start();		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Application", "Guideware-BAU");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", "C11578C");
		return extent;
	}
	
	
	
	public void updateTestLog(String methodName, String description, Status testStatus) throws IOException {
		ExtentTest logInfo;
			if(testStatus.toString().equalsIgnoreCase("FAIL")) { 		
				logInfo = test.createNode(description); 
				logInfo.log(Status.FAIL, description);			
				logInfo.addScreenCaptureFromPath(ReusableComponents.takeFailedScreenshot(methodName));	
				driver.quit();
				
			}
			
			else if(testStatus.toString().equalsIgnoreCase("PASS"))	{		
				logInfo = test.createNode(description); 
				logInfo.log(Status.PASS, description);			
				logInfo.addScreenCaptureFromPath(ReusableComponents.takeScreenshot(methodName));			
			}		
		
		}
	}
	

	
	


