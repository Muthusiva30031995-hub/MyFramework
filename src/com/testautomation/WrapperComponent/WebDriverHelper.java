package com.testautomation.WrapperComponent;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.google.gson.JsonObject;
import com.testautomation.Config.CommonData;
import com.testautomation.Config.InstanceContainer;
import com.testautomation.TestRunner.TestRunnerUI;
import com.testautomation.reusableComponents.ExcelDataAccess;
import com.testautomation.reusableComponents.Report;
import com.testautomation.reusableComponents.ReusableComponents;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import winium.elements.desktop.ComboBox;


public class WebDriverHelper{
	
	public WebDriver driver;
	public Report report;
	public Properties properties;
	
	public ExcelDataAccess excelData;
	public ReusableComponents rc;
	int ImplilicitwaitTime=30;
	int ExplicitWaitTime=50;
	String automationType = null;
	public static String handle = null;
	Set<String> handles = null;
	public static WebDriver popup_driver = null;
	static RequestSpecification httpRequest= null;
	static Response response=null;
	
	
	
	
	public WebDriverHelper(WebDriver driver,Report report,ExcelDataAccess excelData)
	{		
		this.driver = driver;
		this.report = report;		
		this.excelData = excelData;		
		
	}
	/**
	 * Component to Click the button and check the page gets load on the time
	 * @throws Exception 
	 *
	 */
	public void clickElement(By object,String elementName) throws Exception{	
		properties = ReusableComponents.loadFromPropertiesFile();
		automationType = properties.getProperty("AutomationType");
		boolean blnClicked = false;
		if(automationType.equalsIgnoreCase("UI")) {
			try {
				if (isElementPresent(object)) {			
					try {
						System.out.println(object+ " Exits");
						driver.findElement(object).click();
						Thread.sleep(100);
						System.out.println(object+" is clicked successfully");
						report.updateTestLog(elementName, "The element  " + elementName	+ "  is clicked successfully", Status.PASS);
						
					} catch (Exception e) {				
						System.out.println(object+ " not Exits");
						report.updateTestLog(elementName, "Element " + object.toString()+ " is not clicked", Status.FAIL);
					}
					blnClicked = true;
				}
				else
				{
					report.updateTestLog(elementName, "Element " + object.toString()+ " is not displayed", Status.FAIL);
				}
			}
			catch (org.openqa.selenium.NoSuchElementException nsee) {
				report.updateTestLog(elementName, "Element " + object.toString()+ " is not displayed", Status.FAIL);
			}
			catch (Exception e) {
				report.updateTestLog(elementName, "An Exception occured \n <font size=6 color=red> "
						+ e.getMessage().toString().substring(0, e.getMessage().toString().lastIndexOf("\"") + 2) + "<font>", Status.FAIL);
			}
		}
		else if(automationType.equalsIgnoreCase("Desktop")) {
			try {
						
					try {
						System.out.println(object+ " Exits");
						driver.findElement(object).click();
						Thread.sleep(100);
						blnClicked = true;
						System.out.println(object+" is clicked successfully");
						report.updateTestLog(elementName, "The element  " + elementName	+ "  is clicked successfully", Status.PASS);
						
					} catch (Exception e) {				
						System.out.println(object+ " not Exits");
						report.updateTestLog(elementName, "Element " + object.toString()+ " is not clicked", Status.FAIL);
					}
					
				
				
			}
			catch (org.openqa.selenium.NoSuchElementException nsee) {
				report.updateTestLog(elementName, "Element " + object.toString()+ " is not displayed", Status.FAIL);
			}
			catch (Exception e) {
				report.updateTestLog(elementName, "An Exception occured \n <font size=6 color=red> "
						+ e.getMessage().toString().substring(0, e.getMessage().toString().lastIndexOf("\"") + 2) + "<font>", Status.FAIL);
			}
		}
		if(automationType.equalsIgnoreCase("Mobile")) {
			try {
				if (isElementPresent(object)) {			
					try {
						System.out.println(object+ " Exits");
						driver.findElement(object).click();
						Thread.sleep(500);
						System.out.println(object+" is clicked successfully");
						report.updateTestLog(elementName, "The element  " + elementName	+ "  is clicked successfully", Status.PASS);
						
					} catch (Exception e) {				
						System.out.println(object+ " not Exits");
						report.updateTestLog(elementName, "Element " + object.toString()+ " is not clicked", Status.FAIL);
					}
					blnClicked = true;
				}
				else
				{
					report.updateTestLog(elementName, "Element " + object.toString()+ " is not displayed", Status.FAIL);
				}
			}
			catch (org.openqa.selenium.NoSuchElementException nsee) {
				report.updateTestLog(elementName, "Element " + object.toString()+ " is not displayed", Status.FAIL);
			}
			catch (Exception e) {
				report.updateTestLog(elementName, "An Exception occured \n <font size=6 color=red> "
						+ e.getMessage().toString().substring(0, e.getMessage().toString().lastIndexOf("\"") + 2) + "<font>", Status.FAIL);
			}
		}
			
	}
	
	public boolean waitForPageToLoad() {

		try {
			String _clickClass = driver.findElement(By.xpath("//div[contains(@id,'gw-click-overlay')]")).getAttribute("class");			
			Boolean _clickBlocked = _clickClass.contains("gw-disable-click");
			while(_clickBlocked){
				driver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
				return waitForPageToLoad();
			}
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return true;
	}
	
	public void clickElement(WebElement ele) throws IOException{
		
		boolean blnClicked = false;
		if (isElementPresent(ele)) {			
			try {
				ele.click();
				Thread.sleep(100);
			} catch (Exception e) {				
				
			}
			blnClicked = true;
		}
	}
	
	public void clickWebButton(By object,String elementName) throws IOException{

		boolean blnClicked = false;
		try {
			if (isElementPresent(object)) { 		
				try {
					System.out.println(object+ " Exits");
					driver.findElement(object).click();
					Thread.sleep(100);
					System.out.println(object+ " Clicked Successfully");
					report.updateTestLog(elementName, "The element  " + elementName	+ "  is clicked successfully", Status.PASS);
				} catch (Exception e) {
					System.out.println(object+ " not Exits");
					report.updateTestLog(elementName, "Element " + object.toString()+ " is not clicked", Status.FAIL);

				}
				blnClicked = true;
			}
			else
			{
				report.updateTestLog(elementName, "Element " + object.toString()+ " is not displayed", Status.FAIL);
			}
		} catch (org.openqa.selenium.NoSuchElementException nsee) {
			report.updateTestLog(elementName, "Element " + object.toString()+ " is not displayed", Status.FAIL);
		}
		catch (Exception e) {
			report.updateTestLog(elementName, "An Exception occured \n <font size=6 color=red> "
					+ e.getMessage().toString().substring(0, e.getMessage().toString().lastIndexOf("\"") + 2) + "<font>", Status.FAIL);
		}
	}
	
	public void clickCheckBox(By object,String elementName) throws IOException{

		boolean blnClicked = false;
		try {
			if (isElementExists(object)) { 		
				try {
					System.out.println(object+ " Exits");
					driver.findElement(object).click();
					Thread.sleep(100);
					System.out.println(object+ " Clicked Successfully");
					report.updateTestLog(elementName, "The element  " + elementName	+ "  is clicked successfully", Status.PASS);
				} catch (Exception e) {
					System.out.println(object+ " not Exits");
					report.updateTestLog(elementName, "Element " + object.toString()+ " is not clicked", Status.FAIL);

				}
				blnClicked = true;
			}
			else
			{
				report.updateTestLog(elementName, "Element " + object.toString()+ " is not displayed", Status.FAIL);
			}
		} catch (org.openqa.selenium.NoSuchElementException nsee) {
			report.updateTestLog(elementName, "Element " + object.toString()+ " is not displayed", Status.FAIL);
		}
		catch (Exception e) {
			report.updateTestLog(elementName, "An Exception occured \n <font size=6 color=red> "
					+ e.getMessage().toString().substring(0, e.getMessage().toString().lastIndexOf("\"") + 2) + "<font>", Status.FAIL);
		}
	}
	
	public boolean isElementPresent(By object) throws IOException {
		Boolean elementPresent = false;		
		try {
//			waitForPageToLoad();
			WebDriverWait wait = new WebDriverWait(driver,ExplicitWaitTime);
			wait.until(ExpectedConditions.visibilityOfElementLocated(object));
			wait.until(ExpectedConditions.elementToBeClickable(object));
			if(driver.findElement(object).isDisplayed()) {
				return elementPresent = true;				
			}
		} catch (NoSuchElementException nsee) {
			elementPresent = false;		
			
		}
		catch (Exception e) {
			elementPresent = false;
			
		}
		driver.manage().timeouts().implicitlyWait(ImplilicitwaitTime, TimeUnit.SECONDS);
		return elementPresent;
	}	
	
	public void waitForElementPresent(By object) throws IOException {
		try {
			WebDriverWait wait = new WebDriverWait(driver,ExplicitWaitTime);
			wait.until(ExpectedConditions.visibilityOfElementLocated(object));
			wait.until(ExpectedConditions.elementToBeClickable(object));		
			
		} catch (NoSuchElementException nsee) {
			System.out.println(object.toString()+" is not present");
			
		}
		catch (Exception e) {
			System.out.println(object.toString()+" is not present");
			
		}
	}
	
	public  void waitForElementToAppear(By locator) throws TimeoutException {
		boolean webElementPresence = false;
		try {
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).pollingEvery(80, TimeUnit.MILLISECONDS)
					.withTimeout(60, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			fluentWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public void waitForElementPresent(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,ExplicitWaitTime);
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));		
			
		} catch (NoSuchElementException nsee) {
			System.out.println("Element is not present");
		}
		catch (Exception e) {
			System.out.println("Element is not present");
		}
	}
	
	
	public boolean isElementPresent(WebElement element) {
		Boolean elementPresent = false;
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			WebDriverWait wait = new WebDriverWait(driver,ExplicitWaitTime);
			wait.until(ExpectedConditions.visibilityOf(element));					
			wait.until(ExpectedConditions.elementToBeClickable(element));
			if(element.isDisplayed())
				return elementPresent = true;
			
		} catch (NoSuchElementException nsee) {
			elementPresent = false;
		}
		catch (Exception e) {
			elementPresent = false;
		}
		driver.manage().timeouts().implicitlyWait(ImplilicitwaitTime, TimeUnit.SECONDS);
		return elementPresent;
	}
	
	public String getText(By locator) {
		String strReturn = null;
		
		try {
			if(isElementPresent(locator))
			strReturn = driver.findElement(locator).getText().trim();
			else
				System.out.println("Element is not present");
		} catch (NoSuchElementException nsee) {
			strReturn = null;
		}
		catch (Exception e) {
			strReturn = null;
		}
		return strReturn;
	}
	
	public String getText(WebElement element) {
		String strReturn = null;
		
		try {
			if(isElementPresent(element))
			strReturn = element.getText().trim();
			else
				System.out.println("Element is not present");
		} catch (NoSuchElementException nsee) {
			strReturn = null;
		}
		catch (Exception e) {
			strReturn = null;
		}
		return strReturn;
	}
	
	public String getAttribute(By locator) {
		String strReturn = null;
		
		try {
			if(isElementPresent(locator))
			strReturn = driver.findElement(locator).getAttribute("value");
			else
				System.out.println("Element is not present");
		} catch (NoSuchElementException nsee) {
			strReturn = null;
		}
		catch (Exception e) {
			strReturn = null;
		}
		return strReturn;
	}
	
	public String getAttribute(WebElement element) {
		String strReturn = null;
		
		try {
			if(isElementPresent(element))
			strReturn = element.getAttribute("value");
			else
				System.out.println("Element is not present");
		} catch (NoSuchElementException nsee) {
			strReturn = null;
		}
		catch (Exception e) {
			strReturn = null;
		}
		return strReturn;
	}
	
	
	public void enterValue(By object, String strValue, String strLabel) throws Exception {
		properties = ReusableComponents.loadFromPropertiesFile();
		automationType = properties.getProperty("AutomationType");	
			
		if(automationType.equalsIgnoreCase("UI")) {
		
			try {
				if (isElementPresent(object)) {	
					System.out.println(object+ " Exits");
					if(strValue!=null) {				
					driver.findElement(object).click();
					driver.findElement(object).sendKeys(Keys.CONTROL,"a");					
					driver.findElement(object).sendKeys(strValue);
					Thread.sleep(100);
					System.out.println(strValue+ " is entered in "+strLabel );
					report.updateTestLog(strLabel, strValue + " is entered in the " + strLabel+" text field", Status.PASS);
					}
					else
						driver.findElement(object).click();
				} 
	
			} catch (NoSuchElementException nsee) {
				report.updateTestLog(strLabel, "Element " + object.toString()+ " <font>is not displayed", Status.FAIL);
			}  catch (org.openqa.selenium.remote.UnreachableBrowserException ube) {
				report.updateTestLog(strLabel, "Browser closed un-expectedly is not displayed", Status.FAIL);
			} catch (org.openqa.selenium.ElementNotVisibleException env) {
				report.updateTestLog(strLabel, "Element " + object.toString()+ " is hidden or not visible", Status.FAIL);
			}
			catch (Exception e) {
				report.updateTestLog(strLabel, "An Exception occurred \n <font size=6 color=red> "+ e.getMessage().toString().substring(0, e.getMessage().toString().lastIndexOf("\\") + 2) + "<font>", Status.FAIL);
			}
		
		}
		else if(automationType.equalsIgnoreCase("Desktop"))
		{
				try {
					
					System.out.println(object+ " Exits");
					if(strValue!=null) {				
					driver.findElement(object).click();				
					Robot robot = new Robot();
					int[] keys = {KeyEvent.VK_CONTROL, KeyEvent.VK_A, KeyEvent.VK_DELETE};
					robot.keyPress(keys[0]);
					robot.keyPress(keys[1]);
					robot.keyPress(keys[2]);
					robot.keyRelease(keys[0]);
					robot.keyRelease(keys[2]);
					driver.findElement(object).sendKeys(strValue);
					Thread.sleep(100);
					System.out.println(strValue+ " is entered in "+strLabel );
					report.updateTestLog(strLabel, strValue + " is entered in the " + strLabel+" text field", Status.PASS);
					}
					else
					{
						driver.findElement(object).click();
					}
				 
	
				} catch (NoSuchElementException nsee) {
					report.updateTestLog(strLabel, "Element " + object.toString()+ " <font>is not displayed", Status.FAIL);
				}  catch (org.openqa.selenium.remote.UnreachableBrowserException ube) {
					report.updateTestLog(strLabel, "Application closed un-expectedly is not displayed", Status.FAIL);
				} catch (org.openqa.selenium.ElementNotVisibleException env) {
					report.updateTestLog(strLabel, "Element " + object.toString()+ " is hidden or not visible", Status.FAIL);
				}
				catch (Exception e) {
					report.updateTestLog(strLabel, "An Exception occurred \n <font size=6 color=red> "+ e.getMessage().toString().substring(0, e.getMessage().toString().lastIndexOf("\\") + 2) + "<font>", Status.FAIL);
				}
		}
		if(automationType.equalsIgnoreCase("Mobile")) {
			
			try {
				if (isElementPresent(object)) {	
					System.out.println(object+ " Exits");
					if(strValue!=null) {				
					driver.findElement(object).click();
					driver.findElement(object).sendKeys(Keys.CONTROL,"a");					
					driver.findElement(object).sendKeys(strValue);
					Thread.sleep(1000);
					System.out.println(strValue+ " is entered in "+strLabel );
					report.updateTestLog(strLabel, strValue + " is entered in the " + strLabel+" text field", Status.PASS);
					}
					else
						driver.findElement(object).click();
				} 
	
			} catch (NoSuchElementException nsee) {
				report.updateTestLog(strLabel, "Element " + object.toString()+ " <font>is not displayed", Status.FAIL);
			}  catch (org.openqa.selenium.remote.UnreachableBrowserException ube) {
				report.updateTestLog(strLabel, "Browser closed un-expectedly is not displayed", Status.FAIL);
			} catch (org.openqa.selenium.ElementNotVisibleException env) {
				report.updateTestLog(strLabel, "Element " + object.toString()+ " is hidden or not visible", Status.FAIL);
			}
			catch (Exception e) {
				report.updateTestLog(strLabel, "An Exception occurred \n <font size=6 color=red> "+ e.getMessage().toString().substring(0, e.getMessage().toString().lastIndexOf("\\") + 2) + "<font>", Status.FAIL);
			}
		
		}

	}
	
	public boolean isElementExists(By locator) {
		boolean objectExists = false;
		try {
			if (driver.findElement(locator).isDisplayed())
				return true;
		} catch (NoSuchElementException nsee) {
			
		}
		 catch (Exception e) {
			
		}
		return objectExists;

	}
	
	public boolean isElementNotExists(By object) {
		Boolean toReturn = false;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			driver.findElement(object);
		} catch (NoSuchElementException nsee) {
			toReturn = true;
		}
		return toReturn;

	}
	
	
	
	public void selectDropDownValue(By object,String strValue,String strField) throws Exception
	{
		properties = ReusableComponents.loadFromPropertiesFile();
		automationType = properties.getProperty("AutomationType");
		if(automationType.equalsIgnoreCase("UI")) {
		
			if(strValue.substring(0, 1).equals("#")) {
				int valueIndex  = Integer.parseInt(strValue.substring(1, strValue.length()));
				selectDropdownByIndex(object, valueIndex,strField);
			}
			else
			{
				selectDropdownByVisibleText(object, strValue,strField);
			}
		}
		else if(automationType.equalsIgnoreCase("Desktop"))
		{
			try {
				if(isElementPresent(object)) {
					driver.findElement(object).sendKeys(strValue);					
					driver.findElement(object).sendKeys(Keys.TAB);
					report.updateTestLog(strField,strValue + " is selected from the "+strField+ " drop down", Status.PASS);
				}
			 else {
				System.out.println(object+ " not Exits");
				report.updateTestLog(strField, "Element " + object.toString()+ " is not displayed", Status.FAIL);
			}

			} catch (NoSuchElementException nsee) {
				report.updateTestLog(strField, "Element " + object.toString()+ " is not displayed", Status.FAIL);
				
			}  catch (Exception e) {
				report.updateTestLog(strField, "An Exception occurred \n <font size=6 color=red> "+ e.getMessage().toString().substring(0, e.getMessage().toString().lastIndexOf("\\") + 2) + "<font>", Status.FAIL);
			}
			
		}
}
	
	public void selectDropDownValueDesktop(By object1, By object2, String strField) throws IOException
	{
		try {
			if(isElementPresent(object1)) {
				WebElement ele = driver.findElement(object1);
				ComboBox cmb = new ComboBox(ele);
				cmb.expand();
				driver.findElement(object2).click();
				String strValue =cmb.getAttribute("Name"); 
				report.updateTestLog(strField,strValue + " is selected from the "+strField+ " drop down", Status.PASS);
			}
		 else {
			System.out.println(object1+ " not Exits");
			report.updateTestLog(strField, "Element " + object1.toString()+ " is not displayed", Status.FAIL);
		}

		} catch (NoSuchElementException nsee) {
			report.updateTestLog(strField, "Element " + object1.toString()+ " is not displayed", Status.FAIL);
			
		}  catch (Exception e) {
			report.updateTestLog(strField, "An Exception occurred \n <font size=6 color=red> "+ e.getMessage().toString().substring(0, e.getMessage().toString().lastIndexOf("\\") + 2) + "<font>", Status.FAIL);
		}
	}
	
	public void selectDropdownByVisibleText(By object, String strValue, String strField) throws IOException {

		int index = 0;
		int i;
		try {
			if (isElementPresent(object)) {
				System.out.println(object+ " Exits");
				Select selectDropdown = new Select(driver.findElement(object));
				List<WebElement> list = selectDropdown.getOptions();

			    for(i=0;i<list.size();i++){
			        if(list.get(i).getText().contains(strValue.trim())){			            
			            index=i;
			            break;
			            }
			    }
			    selectDropdown.selectByIndex(index);
			    Thread.sleep(100);
			    System.out.println(strValue+ " is value is selected in "+strField);
				report.updateTestLog(strField,strValue + " is selected from the "+strField+ " drop down", Status.PASS);					
				
			}

			else {
				System.out.println(object+ " not Exits");
				report.updateTestLog(strField, "Element " + object.toString()+ " is not displayed", Status.FAIL);
			}

		} catch (NoSuchElementException nsee) {
			report.updateTestLog(strField, "Element " + object.toString()+ " is not displayed", Status.FAIL);
			
		}  catch (Exception e) {
			report.updateTestLog(strField, "An Exception occurred \n <font size=6 color=red> "+ e.getMessage().toString().substring(0, e.getMessage().toString().lastIndexOf("\\") + 2) + "<font>", Status.FAIL);
		}

	}
	
	
	public void selectDropdownByIndex(By object, int indextoSelect,String strField) throws IOException {
		String strValue = null;
		try {
			if (isElementPresent(object)) {
				System.out.println(object+ " Exits");
				Select selectDropdown = new Select(driver.findElement(object));
				selectDropdown.selectByIndex(indextoSelect);
				Thread.sleep(100);
				strValue = driver.findElement(object).getAttribute("value");
				System.out.println(strValue+ " is value is selected in "+strField);
				report.updateTestLog(strField,strValue + " is selected from the "+strField+ " drop down", Status.PASS);
			}

			else {
				System.out.println(object+ " not Exits");
				report.updateTestLog(strField," The value in"+indextoSelect + " is not selected from the,"+strField+ "drop down", Status.FAIL);
			}

		} catch (NoSuchElementException nsee) {
			report.updateTestLog(strField, "Element " + object.toString()+ " is not displayed", Status.FAIL);
			
		}  catch (Exception e) {
			report.updateTestLog(strField, "An Exception occurred \n <font size=6 color=red> "+ e.getMessage().toString().substring(0, e.getMessage().toString().lastIndexOf("\\") + 2) + "<font>", Status.FAIL);
		}

	}
	
	
	
	public void clearTextbox(By object, String strLabel) throws Exception {
		
		properties = ReusableComponents.loadFromPropertiesFile();
		automationType = properties.getProperty("AutomationType");
		
		if(automationType.equalsIgnoreCase("UI")) {
			boolean blnTextEntered = false;
			try {
				if (isElementPresent(object)) {
					driver.findElement(object).clear();
					blnTextEntered = true;
					report.updateTestLog(strLabel, "Element " + object.toString()+ " is cleared", Status.PASS);
					
				} else {
					report.updateTestLog(strLabel, "Element " + object.toString()+ " is not displayed", Status.FAIL);
					blnTextEntered = false;
				}
			} catch (Exception e) {
				report.updateTestLog(strLabel, "Element " + object.toString()+ " is not displayed", Status.FAIL);
			}
			
		}
		else if(automationType.equalsIgnoreCase("Desktop"))
		{
			boolean blnTextEntered = false;
			try {
				
					Robot robot = new Robot();
					int[] keys = {KeyEvent.VK_CONTROL, KeyEvent.VK_A, KeyEvent.VK_DELETE};
					robot.keyPress(keys[0]);
					robot.keyPress(keys[1]);
					robot.keyPress(keys[2]);
					robot.keyRelease(keys[0]);
					robot.keyRelease(keys[2]);
					blnTextEntered = true;
					report.updateTestLog(strLabel, "Element " + object.toString()+ " is cleared", Status.PASS);
					
				} catch (Exception e) {
					blnTextEntered = false;
					report.updateTestLog(strLabel, "Element " + object.toString()+ " is not displayed", Status.FAIL);
			}
		}

	}
	public boolean isAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} // try
		catch (NoAlertPresentException Ex) {
			return false;
		} // catch
	}
	public void acceptPopup(WebDriver driver) {
		try {
			if (isAlertPresent(driver)) {
				Alert alert = driver.switchTo().alert();
				alert.accept();
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			System.out.println("Alert Not appearing");
		}
	}
	
	public void ignorePopup(WebDriver driver) {
		try {
			if (isAlertPresent(driver)) {
				Alert alert = driver.switchTo().alert();
				alert.dismiss();;
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			System.out.println("Alert Not appearing");
		}
	}
	
	public void refresh() {
		driver.navigate().refresh();
	}
	
	public WebElement getElement(By locator)
	{
		WebElement lsElement = null;		
		try {
			lsElement = driver.findElement(locator);
		} catch (Exception e) {			
			
		}
		return lsElement;
	}

	public List<WebElement> getElements(By locator)
	{
		List<WebElement> lstElements = new ArrayList<WebElement>();			
		try {
			lstElements = driver.findElements(locator);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return lstElements;
	}

	public boolean isSelected(By locator)
	{
		try {
			return driver.findElement(locator).isSelected();
		} catch (Exception e) {			
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean isSelected(WebElement element)
	{
		try {
			return element.isSelected();
		} catch (Exception e) {			
			e.printStackTrace();
			return false;
		}
		
	}
	
	public void moveToElement(By locator)
	{
		Actions action = new Actions(driver);
		try {
			WebElement ele = driver.findElement(locator);
			action.moveToElement(ele).build().perform();
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
	public void moveToElement(WebElement ele)
	{
		Actions action = new Actions(driver);
		try {			
			action.moveToElement(ele).build().perform();
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
	public void scrollToView(By locator)
	{
		try {
			JavascriptExecutor js =  (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
		} catch (Exception e) {
			System.out.println("Unable to scroll to view the element");
			e.printStackTrace();
		}
			
	}
	public void scrollToView(WebElement element)
	{
		try {
			JavascriptExecutor js =  (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView();", element);
		} catch (Exception e) {
			System.out.println("Unable to scroll to view the element");
			e.printStackTrace();
		}
			
	}
	
	public void waitForPageLoad() {
		final JavascriptExecutor js =  (JavascriptExecutor)driver;
		try {
			ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {

				public Boolean apply(WebDriver driver) {				
					return js.executeScript("return document.readyState").equals("complete");
				}				
			};
			WebDriverWait wait = new WebDriverWait(driver, ExplicitWaitTime);
			wait.until(pageLoadCondition);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void switchToFrame(By locator)
	{
		try {
			WebElement ele = driver.findElement(locator);
			driver.switchTo().frame(ele);
		} catch (Exception e) {
			System.out.println("Unable to switch to frame");
			e.printStackTrace();
		}
	}
	
	public void switchToDefault()
	{
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			
		}
	}
	
	public void switchToChildWindow()
	{
		try
		{
			handle = driver.getWindowHandle();	//Getting the Parent window handle
		}catch(Exception e)
		{
					
		}	
		try
		{
			handles = driver.getWindowHandles();// To get both parent and child window handle
		}catch(Exception e)
		{
					
		}		
			Iterator<String> windowIterator = handles.iterator();		
			 while(windowIterator.hasNext()) 
			 { 
			   String windowHandle = windowIterator.next();		    		   
			    if (!windowHandle.equals(handle))
			    {
			    	try
			    	{
			    		popup_driver =driver.switchTo().window(windowHandle);
			    		driver.manage().window().maximize();
			    	}catch(Exception e)
			    	{
			    		
			    	}
				 break;
			    }
			  
			 }
	}
	
	public void switchToMainWindow() {
		try
		{
			handle = driver.getWindowHandle();
			driver = popup_driver.switchTo().window(handle);
		}catch(Exception e)
		{
			
		}
	}
	
	public void validateText(By locator, String expectedValue, String strLabel) throws IOException
	{
		try {
		if(isElementPresent(locator)) {
			String actualValue = getText(locator);
			
				if(actualValue!=null)
				{
					if(actualValue.contains(expectedValue))
					{					
						report.updateTestLog(strLabel, strLabel+" "+expectedValue+" is verified", Status.PASS);
					}
					else
					{
						report.updateTestLog(strLabel, strLabel+" "+expectedValue+" is not verified", Status.FAIL);
					}
				}
				else
				{
					report.updateTestLog(strLabel, strLabel+" "+actualValue+" is null", Status.FAIL);
				}
				
			}
			else
			{
				report.updateTestLog(strLabel, locator.toString()+ " is not displayed", Status.FAIL);
			}
		}
	catch (org.openqa.selenium.NoSuchElementException nsee) {
		report.updateTestLog(strLabel, locator.toString()+ " is not displayed", Status.FAIL);
	}
	catch (Exception e) {
		report.updateTestLog(strLabel, "An Exception occured \n"
				+ e.getMessage().toString().substring(0, e.getMessage().toString().lastIndexOf("\"") + 2), Status.FAIL);
	}
		
	}
	
	public Boolean compareText(By locator, String expectedValue) throws IOException
	{
		boolean value = false;
		
		if(isElementPresent(locator)) {
			String actualValue = getText(locator);			
				if(actualValue!=null)
				{
					if(actualValue.contains(expectedValue))
					{					
						value = true;
					}
					else
					{
						value = false;
					}
				}
			}
		return value;	
	
	}
	
	public void mouseMove(By locator) {
		Actions action = new Actions(driver);
		WebElement ele = driver.findElement(locator);
		action.moveToElement(ele).build().perform();
	}
	
	public void TAB(By locator)
	{
		try {
			if(isElementPresent(locator)) {
				driver.findElement(locator).sendKeys(Keys.TAB);
			}
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
	
	public void initializeHTTPRequest(String uri)
	{
		RestAssured.baseURI = uri;		
		httpRequest = RestAssured.given(); 	
		httpRequest.contentType("application/json");
		
	}
	
		
	public Response GET(String url) 
	{		
		return httpRequest.get(url);
	}
	
	public Response GETWithPathParams(String url, Map<String,String> pathparams) 
	{		
		httpRequest.pathParams(pathparams);
		return httpRequest.get(url);
	}
	
	
	public String responseBodyAsString(Response response)
	{			
		return response.getBody().asString();		
	}
	
	public void validateResponseBodyContains(Response response , String expectedValue) throws IOException
	{
		if(response.getBody().asString().contains(expectedValue))
		{
			report.updateTestLog("Response Body", "Response body contains "+expectedValue, Status.PASS);
		}
		else
		{
			report.updateTestLog("Response Body", "Response body not contains "+expectedValue, Status.FAIL);
		}
	}
	
	public void validateStatusCode(Response response, int expectedCode) throws IOException
	{
		int actualStatusCode = response.getStatusCode();
		if(actualStatusCode==expectedCode)	
			report.updateTestLog("Status Code", "Status Code"+" "+expectedCode+" is verified", Status.PASS);
		else
			report.updateTestLog("Status Code", "Status Code"+" "+expectedCode+" is not verified", Status.FAIL);
	}
	
	public void validateStatusLine(Response response, String expectedLine) throws IOException
	{		
		String actualStatusLine = response.getStatusLine();
		if(actualStatusLine.equalsIgnoreCase(expectedLine))	
			report.updateTestLog("Status Line", "Status Line"+" "+expectedLine+" is verified", Status.PASS);
		else
			report.updateTestLog("Status Line", "Status Line"+" "+expectedLine+" is not verified", Status.FAIL);
			
	}
	
	
	public void validateResponseValue(Response response, String key, String expectedValue) throws IOException
	{
		JsonPath jsonPathEval = response.jsonPath();		
		String actualValue = jsonPathEval.get(key);
		if(actualValue.equalsIgnoreCase(expectedValue))	
			report.updateTestLog("Response value", key+" Response value "+expectedValue+" is verified", Status.PASS);
		else
			report.updateTestLog("Response value", key+" Response value "+expectedValue+" is not verified", Status.FAIL);		
		
	}
	
	public void validateHeaderValue(Response response, String headerKey, String expectedValue) throws IOException
	{		
		String actualValue = response.header(headerKey);
		if(actualValue.equalsIgnoreCase(expectedValue))	
			report.updateTestLog("Header value", headerKey+" Header value"+" "+expectedValue+" is verified", Status.PASS);
		else
			report.updateTestLog("Header value", headerKey+" Header value"+" "+expectedValue+" is not verified", Status.FAIL);		
		
	}
	
	
	public Response POSTWithBody(String url,Map<String,String> body) 
	{			
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(body);		
		return httpRequest.post(url);
	} 
	
	public Response POSTWithBodyAndPathParams(String url,Map<String,String> pathParams, Map<String,String> body) 
	{			
		httpRequest.header("Content-Type","application/json");
		httpRequest.pathParams(pathParams);
		httpRequest.body(body);		
		return httpRequest.post(url);
	} 
	
	public Response DELETE(String url)
	{							
		return httpRequest.delete(url);
	}
	
	public Response DELETEWithPathParams(String url, Map<String,String> pathParams)
	{		
		httpRequest.pathParams(pathParams);				
		return httpRequest.delete(url);
	}
	
	public Response PUTWithBody(String url,Map<String,String> body) 
	{			
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(body);		
		return httpRequest.put(url);
	} 
	
	public Response PUTWithBodyAndPathParams(String url,Map<String,String> pathParams, Map<String,String> body) 
	{			
		httpRequest.header("Content-Type","application/json");
		httpRequest.pathParams(pathParams);
		httpRequest.body(body);		
		return httpRequest.put(url);
	}                                      
	
	
	
	public void robotMouseMove(int x, int y) throws AWTException
	{
		Robot robot = new Robot();
		robot.mouseMove(x, y);
		robot.delay(5);		
	}
	
	public void robotMouseLeftClickByOffset(int x, int y) throws AWTException
	{
		Robot robot = new Robot();
		robot.mouseMove(x, y);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.delay(5);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		robot.delay(5);		
	}
	
	public void robotMouseRightClickByOffset(int x, int y) throws AWTException
	{
		Robot robot = new Robot();
		robot.mouseMove(x, y);
		robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
		robot.delay(5);
		robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
		robot.delay(5);		
	} 
	
	public void robotEnter() throws AWTException
	{
		Robot robot = new Robot();
		int[] keys = {KeyEvent.VK_ENTER};
		robot.keyPress(keys[0]);		
		robot.keyRelease(keys[0]);				
		robot.delay(5);			
	}
	
	public void robotTAB() throws AWTException
	{
		Robot robot = new Robot();
		int[] keys = {KeyEvent.VK_TAB};
		robot.keyPress(keys[0]);		
		robot.keyRelease(keys[0]);				
		robot.delay(5);
	}
	
	@SuppressWarnings("rawtypes")
	public void mobileDragAndDrop(WebElement source, WebElement target) throws IOException
	{
		TouchAction action = new TouchAction((MobileDriver)driver);
		try {
			action.longPress(ElementOption.element(source)).moveTo(ElementOption.element(target)).release().perform();
			report.updateTestLog("Darg and Drop", "Souce " + source	+ "  is dragged and dropped in "+target+ " successfully", Status.PASS);
		} catch (IOException e) {
			report.updateTestLog("Darg and Drop", "Souce " + source	+ "  is not dragged and not dropped in "+target+ " successfully", Status.FAIL);
		}
		
	}
	
	@SuppressWarnings("rawtypes")
	public void mobileHorizontalScroll(WebElement ele, int xOffset, int yOffset) throws IOException
	{
		TouchAction action = new TouchAction((MobileDriver)driver);
		try {
			action.longPress(ElementOption.element(ele)).moveTo(ElementOption.element(ele,xOffset,yOffset)).release().perform();
			report.updateTestLog("Horizondal scroll", "Scrolled to the element  " + ele	+ "  successfully", Status.PASS);
		} catch (IOException e) {
			report.updateTestLog("Horizondal scroll", "Not Scrolled to the element  " + ele	+ "  successfully", Status.FAIL);
		}
	}
	
	public void mobileScrollToViewAndClick(String value) throws IOException
	{
		try {
			MobileElement listitem = (MobileElement)driver.findElement(
					MobileBy.AndroidUIAutomator(
							"new UiScrollable(new UiSelector()).scrollIntoView("
									+ "new UiSelector().textContains(\""+value+"\"));"));
			
			listitem.click();
			report.updateTestLog(value, "Scrolled to the element  " + value	+ "  and clicked successfully", Status.PASS);
		} catch (IOException e) {
			report.updateTestLog(value, "Scrolled to the element  " + value	+ "  and not clicked successfully", Status.FAIL);
		}
				
	}
	
	public void mobileScrollToView(String value) throws IOException
	{
		try {
			driver.findElement(
					MobileBy.AndroidUIAutomator(
							"new UiScrollable(new UiSelector()).scrollIntoView("
									+ "new UiSelector().textContains(\""+value+"\"));"));			
			
			report.updateTestLog(value, "Scrolled to the element  " + value	+ "  successfully", Status.PASS);
		} catch (IOException e) {
			report.updateTestLog(value, "Scrolled to the element  " + value	+ "  is not success", Status.FAIL);
		}
				
	}
	
	
	
	      
   
		
		
}
