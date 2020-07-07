package com.testautomation.Config;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;

import com.testautomation.Config.ReusableData;
import com.testautomation.reusableComponents.ReusableComponents;






public class WebDriverFactory {	
	private static Properties properies;
	static String headless = null;
	public static DesktopOptions options= null;
	
	public static WiniumDriverService service = null;
	static WebDriver driver;
	
	public static WebDriver getWebDriver(String browserName) throws Exception {
		WebDriver driver =null;	
		properies = ReusableComponents.loadFromPropertiesFile();		
		headless = properies.getProperty("HeadlessMode");
		
		if(headless.equalsIgnoreCase("true"))
		{
			driver = getHeadlessChromeDriver();
		}
		else {
			if(browserName.equalsIgnoreCase("chrome"))
			{	
				driver = getChromeDriver();
			}
			
				
			
		}
		return driver;
	}
	
	
	public static WebDriver getDesktopWebDriver() throws Exception {
		WiniumDriver driver = null;
		options  = new DesktopOptions();		
//		String applicationPath = "C:\\Program Files (x86)\\Internet Explorer\\iexplore.exe";
//		String applicationPath = "C:\\Windows\\System32\\notepad.exe";
		String applicationPath = "C:\\Symbility Manual\\mclaim.exe";
		options.setApplicationPath(applicationPath);
		String Path = ReusableData.currentDir+"\\src\\driverFactory\\Winium.Desktop.Driver.exe";
		File driverPath = new File(Path);
		Process process = Runtime.getRuntime().exec("taskkill /F /IM Winium.Desktop.Driver.exe");
		process.waitFor();
		if(process.isAlive())
			process.destroy();
		service = new WiniumDriverService.Builder().usingDriverExecutable(driverPath).usingPort(9999).withVerbose(true).withSilent(false).buildDesktopService();
		service.start();		
		driver = new WiniumDriver(service, options);
		return driver;
}
		
	
	
		private static WebDriver getChromeDriver() throws InterruptedException {			
			String filePath = ReusableData.currentDir+"\\src\\driverFactory\\chromedriver.exe";
			File file = new File(filePath);
			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());			    	
			driver = new ChromeDriver();	
			driver.manage().deleteAllCookies();	
			driver.manage().window().maximize();
			return driver;			
		}
		
		private static WebDriver getphantomJSDriver() throws Exception {						
			String phantomjs_dir = ReusableData.currentDir+"\\Drivers\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe";
			File file = new File(phantomjs_dir);				
            System.setProperty("phantomjs.binary.path", file.getAbsolutePath()); 			
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setJavascriptEnabled(true);
			caps.setCapability("locationContextEnabled", true);
			caps.setCapability("applicationCacheEnabled", true);
			caps.setCapability("browserConnectionEnabled", true);
			caps.setCapability("localToRemoteUrlAccessEnabled", true);
			caps.setCapability("locationContextEnabled", true);
			caps.setCapability("takesScreenshot", true);
			String[] phantomJsArgs = new String[]{ "--ignore-ssl-errors=true" };
	        caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomJsArgs);
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,phantomjs_dir); 			
	        driver = new  PhantomJSDriver(caps);
	        driver.manage().deleteAllCookies();
	        driver.manage().window().maximize();	        
	        return driver;
		}
		
		
		private static WebDriver getHeadlessChromeDriver() {			
			String filePath = System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", filePath);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
            options.addArguments("window-size=1200x600");
            driver = new ChromeDriver(options);			
			return driver;
		}		
		
		
		
		
}


