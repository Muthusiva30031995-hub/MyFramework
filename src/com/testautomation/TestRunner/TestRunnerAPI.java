package com.testautomation.TestRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.naming.AuthenticationException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.sun.jersey.api.client.ClientHandlerException;
import com.testautomation.Config.CommonData;
import com.testautomation.Config.InstanceContainer;
import com.testautomation.Config.ReusableData;

import com.testautomation.WrapperComponent.WebDriverHelper;
import com.testautomation.reusableComponents.Email;
import com.testautomation.reusableComponents.ExcelDataAccess;
import com.testautomation.reusableComponents.Report;
import com.testautomation.reusableComponents.ReusableComponents;
import com.testautomation.reusableComponents.WebDriverFactory;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import gherkin.pickles.PickleTag;



@CucumberOptions(
			features="Features/API/RestAssured",
			glue= {"com.testautomation.StepDef"}			
			)
public class TestRunnerAPI{	
	  
	 private TestNGCucumberRunner testNGCucumberRunner;	 
	 public static ExcelDataAccess excelData;
	 public static WebDriver driver;
	 public static CommonData commonData = new CommonData();	 
	 public static InstanceContainer ic;
	 public static WebDriverHelper wh;
	 public static ReusableComponents rc;
	 public static ExtentHtmlReporter htmlReporter;
	 public static ExtentReports extent;
	 public static ExtentTest test;
	 public static Report report;
	 public static Properties properties;	 
	 public static String screenShotFolder= null;
	 public static String screenShotFolderPath =null;
	 public static String failedScreenShotFolder = null;
	 String ExecutionSheetPath=null;
	 String projectName=null;
	 String DataSheetPath=null;
	 String CommonDataSheetPath = null;
	 String CommonDataPath= null;
	 String reportPath= null;
	 String extentReportPathFolder= null;
	 String extentReportPath=null;	 
	 String envPOM = null;
	 String slavePOM = null;
	 String Browser=null;
	 String execute = null;
	 String ScenarioName = null;
	 String slaveno= null;
	 int iterationCount = 0;
	 List<String> scenarioList = new ArrayList<String>();
	 String masteresultPathshort=null;
	 String masterFolder = null;
	 
	 String ls_Status = null;
	 String masterEmailSubject = "BBC_AutoSTP_Notification";
	 Email email=new Email();
	 
	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception {
		
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		
	}
	@BeforeTest(alwaysRun=true)
	public void beforeSetup() throws Exception {
		properties = ReusableComponents.loadFromPropertiesFile();
		projectName = "RestAssured";
		CommonData.projectName = projectName;
		envPOM=System.getProperty("regressionnenv");
		slavePOM=System.getProperty("regressionslave");
		masteresultPathshort=ReusableData.masteresultPathshort;
		masterFolder = "STP_Automation_" + projectName+ "_" + ReusableComponents.getCurrentDate();
		ExecutionSheetPath = ReusableData.currentDir+"\\testData_cucumber\\"+"\\API\\"+projectName+"\\Executionsheet.xlsx";
		DataSheetPath= ReusableData.currentDir+"\\testData_cucumber\\"+"\\API\\"+projectName+"\\Datasheet.xlsx";
		CommonDataSheetPath = ReusableData.currentDir+"\\testData_cucumber\\"+"\\API\\"+projectName+"\\CommonDataSheet.xlsx";		
		initializeDataTable();
		//	Local Report Path
		reportPath = ReusableData.currentDir+ReusableData.fileSeparator+"Reports"+"\\"+"API";
	
		
		File f = new File(reportPath);
		if (f.exists() && f.isDirectory())
		   System.out.println(reportPath + " File folder is present");
		else
			new File(reportPath).mkdirs();	
		

		//To store reports in Local
		extentReportPath = reportPath + "\\ExtentReports\\" + "ExtentReport" +  ReusableComponents.getCurrentDateAndTime()+ ".html";
		

		commonData.extentReportPath = extentReportPath;
		extent = Report.setup(extentReportPath);
	}
	
	@Test(dataProvider = "testcasesList", enabled=true, alwaysRun=true)
	public void main_method(String scenarioName, String iteration, String executeFlag, String browser, String slave,String featureFile) throws Throwable
	{ 
		
		ScenarioName = scenarioName.trim().replaceAll("\n","");
		CommonData.scenarioName = ScenarioName;
		execute = executeFlag;
		Browser = browser;		
		slaveno = slave;	
		iterationCount = Integer.parseInt(iteration);
		commonData.iterationCount = iterationCount;
		
		if(execute.trim().replaceAll("\n","").equalsIgnoreCase("Y") && slaveno.trim().replaceAll("\n","").equalsIgnoreCase(slavePOM))
			{
				System.out.println(ScenarioName); 				
				for(int i=1;i<=iterationCount;i++)
				{				
				driver = WebDriverFactory.getWebDriver(Browser.toLowerCase());				
				excelData.setCurrentRow(ScenarioName,i);
				test = extent.createTest(ScenarioName);	
				report = new Report(test);
				wh = new WebDriverHelper(driver,report,excelData);
				rc = new ReusableComponents(driver,wh,excelData,report,commonData);				 				
				ic = new InstanceContainer(driver, wh, rc, commonData,excelData,report);
		
				//To store Screenshots in Local
				screenShotFolder= reportPath+"\\Screenshots\\"+"//"+ScenarioName+ReusableComponents.getCurrentDateAndTime()+"//";
				failedScreenShotFolder= reportPath+"\\Screenshots\\"+"//"+ScenarioName+ReusableComponents.getCurrentDateAndTime()+"\\"+"\\Failed\\"+"//";
				
				commonData.screenShotFolder = screenShotFolder;
				commonData.failedScreenShotFolder =failedScreenShotFolder;
				test.log(Status.PASS, "Test Execution is starting");
				ReusableComponents.runScenario(testNGCucumberRunner,ScenarioName);				
				driver.quit();
				}
										
			}
		
	
	
	}
		

	
	
	@DataProvider()
    public Object[][] testcasesList() throws Exception{
         Object[][] testObjArray = ExcelDataAccess.getTableArray(ExecutionSheetPath, "BDD");
         return (testObjArray);	
	}
	
	
	
	@AfterMethod
	public void tearDownTest(ITestResult result) throws Exception {
		
		String status = "";
		if(execute.trim().replaceAll("\n","").equalsIgnoreCase("Y") && slaveno.trim().replaceAll("\n","").equalsIgnoreCase(slavePOM))
		{
		if (ITestResult.FAILURE == result.getStatus()) 
		{
			status = "Failed";
			ls_Status="FAIL";
			
		} 
		else if (ITestResult.SUCCESS == result.getStatus()) 
		{
			status = "Passed";
			ls_Status="PASS";			
			
		}
					
			
				
				execute="N";
				extent.flush();
		}
	}
	
	@AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        if (testNGCucumberRunner == null) {
            return;
        }
        testNGCucumberRunner.finish();
        driver.quit();
    }
	
	
	private void initializeDataTable()
	{
		excelData = new ExcelDataAccess(DataSheetPath, "Test_Data",CommonDataSheetPath,"Common_TestData");
		
	}
}
