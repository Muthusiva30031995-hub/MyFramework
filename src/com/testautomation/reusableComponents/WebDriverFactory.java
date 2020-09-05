package com.testautomation.reusableComponents;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;

import com.testautomation.Config.ReusableData;
import com.testautomation.reusableComponents.ReusableComponents;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;






public class WebDriverFactory extends Thread{	
	private static Properties properies;
	static String headless = null;
	public static DesktopOptions options= null;
	
	public static WiniumDriverService service = null;
	private static WebDriverFactory instance = new WebDriverFactory();
	ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
	
	private WebDriverFactory()
	{
		
	}
	
	
	public WebDriver getWebDriver(String browserName) throws Exception {
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
			else if(browserName.equalsIgnoreCase("firefox"))
			{	
				driver = getFirefoxDriver();
			}
				
			
		}
		return driver;
	}
	
		
	public WiniumDriver getDesktopWebDriver() throws Exception {
		WiniumDriver driver = null;
		options  = new DesktopOptions();		
//		String applicationPath = "C:\\Program Files (x86)\\Internet Explorer\\iexplore.exe";
		String applicationPath = "C:\\Windows\\System32\\notepad.exe";
//		String applicationPath = "C:\\Symbility Manual\\mclaim.exe";
		options.setApplicationPath(applicationPath);
		String Path = ReusableData.currentDir+"\\Drivers\\Winium.Desktop.Driver.exe";
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
		
	
	
		private WebDriver getChromeDriver() throws InterruptedException, MalformedURLException {		
//			WebDriver driver =null;	
//			String filePath = ReusableData.currentDir+"\\Drivers\\chromedriver.exe";
//			File file = new File(filePath);
//			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());			    	
//			driver = new ChromeDriver();	
//			driver.manage().deleteAllCookies();	
//			driver.manage().window().maximize();	
			DesiredCapabilities dc = new DesiredCapabilities().chrome();
			URL url = new URL("http://192.168.1.11:4444/wd/hub");
//			URL url = new URL("http://192.168.99.100:4444/wd/hub");
			RemoteWebDriver driver = new RemoteWebDriver(url,dc); 
			setDriver(driver);
			getDriver().manage().deleteAllCookies();	
			getDriver().manage().window().maximize();
			return driver;			
		}
		
		private WebDriver getFirefoxDriver() throws InterruptedException, MalformedURLException {			
//			String filePath = ReusableData.currentDir+"\\Drivers\\chromedriver.exe";
//			File file = new File(filePath);
//			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());			    	
//			driver = new ChromeDriver();	
//			driver.manage().deleteAllCookies();	
//			driver.manage().window().maximize();	
			DesiredCapabilities dc = new DesiredCapabilities().chrome();
			URL url = new URL("http://192.168.99.100:4444/wd/hub");
			RemoteWebDriver driver = new RemoteWebDriver(url,dc); 					
			return driver;			
		}
		
		private WebDriver getphantomJSDriver() throws Exception {	
			WebDriver driver =null;	
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
			WebDriver driver =null;	
			String filePath = System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", filePath);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
            options.addArguments("window-size=1200x600");
            driver = new ChromeDriver(options);			
			return driver;
		}		
		
		
		
		public static AndroidDriver<WebElement> getAndroidMobileAppDriver(String platform,String version,String deviceName) throws MalformedURLException
		{			
				AndroidDriver<WebElement> driver=null;
				DesiredCapabilities dc = new DesiredCapabilities();
				dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
				dc.setCapability(MobileCapabilityType.PLATFORM_NAME, platform);
				dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
				dc.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
	//			dc.setCapability(MobileCapabilityType.APP, "E:\\MS\\Automation Softwares\\Appium\\Flipkart Online Shopping App_v7.8_apkpure.com.apk");
	//			dc.setCapability("appPackage", "com.android.calculator2");
	//			dc.setCapability("appActivity", "com.android.calculator2.Calculator");
	//			dc.setCapability("appPackage", "com.google.android.dialer");
	//			dc.setCapability("appActivity", "com.google.android.apps.dialer.extensions.GoogleDialtactsActivity");
	//			dc.setCapability("appPackage", "com.google.android.apps.messaging");
	//			dc.setCapability("appActivity", "com.google.android.apps.messaging.ui.ConversationListActivity");
				dc.setCapability("appPackage", "com.touchboarder.android.api.demos");
				dc.setCapability("appActivity", "com.touchboarder.androidapidemos.MainActivity");
				dc.setCapability("unicodeKeyboard", "true");                                     
				dc.setCapability("resetKeyboard", "true");
				URL url = new URL("http://127.0.0.1:4723/wd/hub");		
				driver = new AndroidDriver<WebElement>(url, dc);		
				return driver;
			
		}
		
		public static AndroidDriver<WebElement> getAndroidMobileWebAppDriver(String platform,String version,String deviceName) throws MalformedURLException
		{			
				AndroidDriver<WebElement> driver=null;
				DesiredCapabilities dc = new DesiredCapabilities();
				dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
				dc.setCapability(MobileCapabilityType.PLATFORM_NAME, platform);
				dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
				dc.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);	
				dc.setCapability("appPackage", "com.touchboarder.android.api.demos");
				dc.setCapability("appActivity", "com.touchboarder.androidapidemos.MainActivity");
				dc.setCapability("browserName", "Chrome");                                 
				dc.setCapability("noReset", true); 
				String filePath = System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe";
				System.setProperty("webdriver.chrome.driver", filePath);
				URL url = new URL("http://127.0.0.1:4723/wd/hub");		
				driver = new AndroidDriver<WebElement>(url, dc);		
				return driver;
			
		}
		
		public static IOSDriver<WebElement> getIOSMobileAppDriver(String platform,String version,String deviceName) throws MalformedURLException
		{			
				IOSDriver<WebElement> driver=null;
				DesiredCapabilities dc = new DesiredCapabilities();
				dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
				dc.setCapability(MobileCapabilityType.PLATFORM_NAME, platform);
				dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
				dc.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);	
				dc.setCapability("appPackage", "com.touchboarder.android.api.demos");
				dc.setCapability("appActivity", "com.touchboarder.androidapidemos.MainActivity");				
				URL url = new URL("http://127.0.0.1:4723/wd/hub");		
				driver = new IOSDriver<WebElement>(url, dc);		
				return driver;
			
		}
		
		
		
		
		public static WebDriverFactory getInstance()
		{
			if(instance==null) {
				instance = new WebDriverFactory();
			}
			return instance;
		}
		
		public void setDriver(WebDriver driver)
		{
			webDriver.set(driver);
		}
		
		
		public WebDriver getDriver()
		{
			return webDriver.get();
		}
		
		
}


