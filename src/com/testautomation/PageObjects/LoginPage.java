package com.testautomation.PageObjects;


import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.aventstack.extentreports.Status;
import com.testautomation.Config.InstanceContainer;
import com.testautomation.PageUI.LoginPageUI;
import com.testautomation.reusableComponents.ReusableComponents;







public class LoginPage extends PageBase{
	
	 Properties properties;
	 public static String application_url=null;
	 String application;
	 String environment;
	 
	 
	public LoginPage(InstanceContainer ic)
	{
		super(ic);
	}
	
	public void openApplication(String applicationName) throws Exception
	{
		properties =  ReusableComponents.loadFromPropertiesFile();
		application = applicationName;
//		environment=properties.getProperty("Environment");	
		environment = System.getProperty("regressionnenv");
		if(application.equalsIgnoreCase("OrangeHRM")) {			
			if(environment.equalsIgnoreCase("TEST")) 
				application_url = properties.getProperty("GWCC_TEST_URL");			
			else if(environment.equalsIgnoreCase("MODL"))
				application_url = properties.getProperty("GWCC_MODL_URL");	
			else if(environment.equalsIgnoreCase("AGILE"))
				application_url = properties.getProperty("GWCC_AGILE_URL");	
		}			
		driver.get(application_url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		if(wh.isElementPresent(LoginPageUI.usernameTxt))
		report.updateTestLog("Open Application", "Application is launched", Status.PASS);
		else
			report.updateTestLog("Open Application", "Application is not launched", Status.FAIL);
	}
	
	public void Login() throws Exception
	{
			String userName = excelData.getCommonData("Username");
			String passWord = excelData.getCommonData("Password");
			wh.enterValue(LoginPageUI.usernameTxt, userName, "Username");		
			wh.enterValue(LoginPageUI.passwordTxt, passWord, "Password");
			wh.clickElement(LoginPageUI.loginBtn,"Login Button");		
				if(wh.isElementPresent(LoginPageUI.homePage)){
					report.updateTestLog("Login", "Login is success", Status.PASS);
				}
				else 
				{
					report.updateTestLog("Login", "Login is not success", Status.FAIL);
				}
		
	}
	public void Logindynamic() throws Exception
	{
		String userName = excelData.getData("TestUserName");
		String passWord = excelData.getData("TestPasword");
			wh.enterValue(LoginPageUI.usernameTxt, userName, "Username");		
			wh.enterValue(LoginPageUI.passwordTxt, passWord, "Password");
			wh.clickElement(LoginPageUI.loginBtn,"Login Button");		
				if(wh.isElementPresent(LoginPageUI.settings)){
					report.updateTestLog("Login", "Login is success", Status.PASS);
				}
				else 
				{
					report.updateTestLog("Login", "Login is not success", Status.FAIL);
				}
		
	}

	public void Logout() throws Exception {
		
	    Thread.sleep(100);
		wh.clickElement(LoginPageUI.settings,"Seting Button");
		wh.clickElement(LoginPageUI.logoutBtn,"Logout Button");
		if(wh.isElementPresent(LoginPageUI.usernameTxt)){
			report.updateTestLog("Logout", "Logout is success", Status.PASS);
		}
		else 
		{
			report.updateTestLog("Logout", "Logout is not success", Status.FAIL);
		}
	}
	
	
	
}
