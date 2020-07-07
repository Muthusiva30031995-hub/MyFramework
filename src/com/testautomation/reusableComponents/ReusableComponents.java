package com.testautomation.reusableComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.io.FileHandler;

import com.testautomation.Config.CommonData;
import com.testautomation.Config.InstanceContainer;
import com.testautomation.Config.ReusableData;

import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

import com.testautomation.TestRunner.TestRunnerUI;
import com.testautomation.WrapperComponent.WebDriverHelper;




public class ReusableComponents{
	private static Properties properties;
	public static WebDriver driver;
	public static CommonData commonData;	
	public WebDriverHelper wh;
	public ExcelDataAccess excelData;
	public Report report;
	
	static String ScenarioName = null;
	
	@SuppressWarnings("static-access")
	public ReusableComponents(WebDriver driver,WebDriverHelper wh,ExcelDataAccess excelData,Report report,CommonData commonData) {
		this.driver = driver;
		this.wh = wh;
		this.excelData = excelData;
		this.report = report;		
		this.commonData =commonData;
	}
	
	
	public static Properties loadFromPropertiesFile() throws Exception {
		
		properties = new Properties();
		FileInputStream input = null;
		try {
		    input = new FileInputStream(new File(ReusableData.currentDir
		    		+ReusableData.fileSeparator+"RunConfig.properties"));
		    properties.load(input);	
		}
		    catch (FileNotFoundException e)
			{
				e.printStackTrace();
				throw new Exception("FileNotFoundException while loading the Runconfig file");
			}
			catch (IOException e)
			{
				e.printStackTrace();
				throw new Exception("IOException while loading the Runconfig file");
			}
			
		return properties;
	}
	
	
	
public static String takeScreenshot(String screenshotName) throws IOException {	
	    
		TakesScreenshot ts = (TakesScreenshot)driver;		
		File source = ts.getScreenshotAs(OutputType.FILE);
		String screenShotFolderPath = commonData.screenShotFolder;
		File f = new File(screenShotFolderPath);
		if (f.exists() && f.isDirectory())
			   System.out.println(screenShotFolderPath + " File folder is present");
			else
				new File(screenShotFolderPath).mkdirs(); 
		String destination = screenShotFolderPath+screenshotName+".png";	
		File target = new File(destination);		
		FileHandler.copy(source, target);
		System.out.println("Screenshot Taken");
		return destination;	
	 	
}

public static String takeFailedScreenshot(String screenshotName) throws IOException {	
    
	TakesScreenshot ts = (TakesScreenshot)driver;		
	File source = ts.getScreenshotAs(OutputType.FILE);	
	String failedScreenshotFolder = commonData.failedScreenShotFolder;
	File f = new File(failedScreenshotFolder);
	if (f.exists() && f.isDirectory())
	   System.out.println(failedScreenshotFolder + " File folder is present");
	else
		new File(failedScreenshotFolder).mkdirs();	
	String destination = failedScreenshotFolder+screenshotName+".png";	
	File target = new File(destination);		
	FileHandler.copy(source, target);
	System.out.println("Screenshot Taken");
	return destination;	
 	
}


	
	public static String getCurrentDateAndTime() {
		String str = null;
		
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
			Date date = new Date();
			str = dateFormat.format(date);
			str = str.replace(" ", "_").replaceAll("/", "-").replaceAll(":", "-");
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		return str;
	}
	
	public static String getCurrentDate() {
		String dateValue = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			 Date date = new Date();
			 dateValue = dateFormat.format(date).replaceAll("/","-");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dateValue;
	}
	
	
	public static void runScenario(TestNGCucumberRunner testNGCucumberRunner, String scenarioName) throws Throwable
	{
		ScenarioName = scenarioName.substring(scenarioName.indexOf("_")+1);
		Object[][] data = testNGCucumberRunner.provideScenarios();			
		String featureScenario=null;			
			if(data!= null)
			{
				for (int i=0;i<data.length;i++) {
					PickleEventWrapper pickleeventwrapper = (PickleEventWrapper)data[i][0];
					featureScenario = pickleeventwrapper.toString().trim().replaceAll("\"", "");
					if(featureScenario.contains("TC") || (featureScenario.contains("TS")))
					{
						featureScenario = featureScenario.substring(featureScenario.indexOf("_")+1);
					}
						if(ScenarioName.equalsIgnoreCase(featureScenario)) 
						{								
							System.out.println(pickleeventwrapper.getPickleEvent().uri);
							testNGCucumberRunner.runScenario(pickleeventwrapper.getPickleEvent());
							break;
						}
				
				}
			}
	}
	
}
