package com.testautomation.reusableComponents;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.testautomation.Config.ReusableData;

public class DriverFactory {
	private static DriverFactory instance = new DriverFactory();
	ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
	private DriverFactory()
	{
		
	}
	
	
	
	public static DriverFactory getInstance()
	{
		if(instance==null) {
			instance = new DriverFactory();
		}
		return instance;
	}
	
	
	
	
	public WebDriver getDriver()
	{
		return webDriver.get();
	}

	
	public void setDriver(String browser) throws MalformedURLException
	{
		DesiredCapabilities cap = null;
		
		switch(browser)
		{
		case "Chrome":
//			cap = DesiredCapabilities.chrome();
//			ChromeOptions option = new ChromeOptions();
//			cap.setCapability(ChromeOptions.CAPABILITY, option);
//			String filePath = ReusableData.currentDir+"\\Drivers\\chromedriver.exe";
//			File file = new File(filePath);
//			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
//			webDriver.set(new ChromeDriver());
			DesiredCapabilities dc = new DesiredCapabilities().chrome();
			cap = DesiredCapabilities.chrome();
			ChromeOptions option = new ChromeOptions();
			cap.setCapability(ChromeOptions.CAPABILITY, option);
			String filePath = ReusableData.currentDir+"\\Drivers\\chromedriver.exe";
			File file = new File(filePath);
			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			URL url = new URL("http://192.168.1.11:4444/wd/hub");
//			URL url = new URL("http://192.168.99.100:4444/wd/hub");
//			RemoteWebDriver driver = new RemoteWebDriver(url,dc); 
			webDriver.set(new RemoteWebDriver(url,dc));
			getDriver().manage().deleteAllCookies();	
			getDriver().manage().window().maximize();
		}
	}
	
	
	public void removeDriver()
	{
		webDriver.get().quit();
		webDriver.remove();
	}
}
