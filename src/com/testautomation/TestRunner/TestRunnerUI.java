package com.testautomation.TestRunner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.naming.AuthenticationException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
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
			features="Features/UI/BAU_Regression",
			glue= {"com.testautomation.StepDef"}			
			)
public class TestRunnerUI{	
	  
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
	 String DataRepoSheetPath = null;
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
	 String masterEmailSubject = "BAU Automation Notification";
	 Email email=new Email();
	 private static List<WebDriver> webDriverPool = Collections.synchronizedList(new ArrayList<WebDriver>());
	 private static ThreadLocal<WebDriver> driverThread;
	 
	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception {
		
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		
	}
	@BeforeTest(alwaysRun=true)
	public void beforeSetup() throws Exception {
		properties = ReusableComponents.loadFromPropertiesFile();
		projectName = "BAU_Regression";
		CommonData.projectName = projectName;
		envPOM=System.getProperty("regressionnenv");
		slavePOM=System.getProperty("regressionslave");
		masteresultPathshort=ReusableData.masteresultPathshort;
		masterFolder = "STP_Automation_" + projectName+ "_" + ReusableComponents.getCurrentDate();
		ExecutionSheetPath = ReusableData.currentDir+"\\testData_cucumber\\"+"\\UI\\"+projectName+"\\Executionsheet.xlsx";
		DataSheetPath= ReusableData.currentDir+"\\testData_cucumber\\"+"\\UI\\"+projectName+"\\Datasheet.xlsx";
		CommonDataSheetPath = ReusableData.currentDir+"\\testData_cucumber\\"+"\\UI\\"+projectName+"\\CommonDataSheet.xlsx";
		DataRepoSheetPath = ReusableData.currentDir+"\\testData_cucumber\\"+"\\Mobile\\"+projectName+"\\DataRepo.xlsx";
		
		initializeDataTable();
		//	Local Report Path
		reportPath = ReusableData.currentDir+ReusableData.fileSeparator+"Reports"+"\\"+ "UI";
		
		// Share driver Report path
//		reportPath = masteresultPathshort + "\\resultFolder\\" + masterFolder;		
//		screenShotFolderPath = masterFolder;
//		extentReportPathFolder = reportPath + "\\" + slavePOM + "\\" +"ExtentReports";
		
		File f = new File(reportPath);
		if (f.exists() && f.isDirectory())
		   System.out.println(reportPath + " File folder is present");
		else
			new File(reportPath).mkdirs();	
		
//		File f1 = new File(extentReportPathFolder);
//		if (f1.exists() && f1.isDirectory())
//		   System.out.println(extentReportPathFolder + "File folder is present");
//		else
//			new File(extentReportPathFolder).mkdirs();	
		
		//To store reports in Local
		extentReportPath = reportPath + "\\ExtentReports\\" + "ExtentReport" +  ReusableComponents.getCurrentDateAndTime()+ ".html";
		
		//To store Reports in Share drive
//		extentReportPath = extentReportPathFolder + "\\ExtentReports_" +  projectName + "_"+ReusableComponents.getCurrentDateAndTime() + ".html";
		commonData.extentReportPath = extentReportPath;
		extent = Report.setup(extentReportPath);
		
//		Runtime.getRuntime().exec("cmd /c start start_Docker_Grid.bat");
//		Thread.sleep(15000);
//		Runtime.getRuntime().exec("cmd /c start Increase_Chrome.bat");
//		Thread.sleep(15000);
		
		
	}
	
		
	
	@Test(dataProvider = "testcasesList", enabled=true)	
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
//					driverThread = new ThreadLocal<WebDriver>()
//					{
//						@Override
//						protected WebDriver initialValue()
//						{
//							WebDriver driver = null;
//							try {
//								driver = WebDriverFactory.getWebDriver(Browser.toLowerCase());
//							} catch (Exception e) {
//								e.printStackTrace();
//							}
//							webDriverPool.add(driver);
//							return driver;
//						}
//					};
//				driver = driverThread.get();	
				driver = WebDriverFactory.getWebDriver(Browser.toLowerCase());
				excelData.setCurrentRow(ScenarioName,i);
				test = extent.createTest(ScenarioName);	
				report = new Report(test);
				wh = new WebDriverHelper(driver,report,excelData);
				rc = new ReusableComponents(driver,wh,excelData,report,commonData);				 				
				ic = new InstanceContainer(driver, wh, rc, commonData,excelData,report);
//				ExecutorService parallelExecutor = Executors.newFixedThreadPool(2);
//				ParallelRunner testRunner =	new ParallelRunner(ic);
//				parallelExecutor.execute((Runnable) testRunner);
				
				//To store Screenshots in SharePath
				//screenShotFolder= reportPath+"\\"+ScenarioName+"_"+ReusableComponents.getCurrentDateAndTime()+"\\"+"\\Screenshots\\"+"//";;		
//				failedScreenShotFolder = reportPath+"\\"+ScenarioName+"_"+ReusableComponents.getCurrentDateAndTime()+"\\"+"\\Screenshots\\"+"\\"+"\\Failed\\"+"//";;
				
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
			try {
				excelData.writeDataToExecutionSheet("Status", ls_Status);
				if(CommonData.claimNumber!=null)
				{
					excelData.writeDataToExecutionSheet("ClaimNo", CommonData.claimNumber);					
				}
			} catch (Exception e) {				
				
			}
		} 
		else if (ITestResult.SUCCESS == result.getStatus()) 
		{
			status = "Passed";
			ls_Status="PASS";
			try {
				excelData.writeDataToExecutionSheet("Status", ls_Status);
				if(CommonData.claimNumber!=null)
				{
					excelData.writeDataToExecutionSheet("ClaimNo", CommonData.claimNumber);
					
				}
			} catch (Exception e) {
				
			}
			
		}
					
			String snapshotPath;
			String reportExcelPath;
			String htmlmessage;
			
				String subject = masterEmailSubject + " in " + slavePOM + ">" + ls_Status + ">" + CommonData.claimNumber + 
						">" + ScenarioName;
				
				snapshotPath = "file:///" + commonData.screenShotFolder;
				reportExcelPath = "file:///" + commonData.extentReportPath;
				
				htmlmessage = "<html>" +
						"<head><title>"+masterEmailSubject+"</title></head>" +
						"<body>" +
						"<h2>Hi Team,</h2>"+
						"</br>"+
						"<h2>Please find below snapshot folder path and excel report link,</h2>"+
						"</br>"+
						"<h2> Click <a href=\"" + snapshotPath + "\">here</a> to see the <u><b>snapshot</b></u> folder </h2>" +
						"</br>"+
						"<h2> Click <a href=\"" + reportExcelPath + "\">here</a> to see the <u><b>Excel Report</b></u> </h2>" +
						"</br>"+
						"<h2>Thanks & Regards,</h2>"+
						"<h2>QBENA Automation Team</h2>"+
						"</body>" +
						"</html>";
				
				try {
					 
					//Email.sendMailWithbody(subject,htmlmessage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				CommonData.claimNumber="";
				snapshotPath="";
				reportExcelPath = "";
				htmlmessage="";
				
				execute="N";
				extent.flush();
		}
	}
	
//	@AfterTest
//	public void tearDownDocker() throws IOException, InterruptedException
//	{
//		Runtime.getRuntime().exec("cmd /c start stop_Docker_Grid.bat");
//		Thread.sleep(5000);
//		Runtime.getRuntime().exec("taskkill /f /im cmd.exe");
//	}
	
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
		excelData = new ExcelDataAccess(ExecutionSheetPath,"BDD",DataSheetPath, "Test_Data",CommonDataSheetPath,"Common_TestData",DataRepoSheetPath,"Data");
		
	}
}
