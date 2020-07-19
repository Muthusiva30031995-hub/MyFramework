package com.testautomation.PageObjects;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class InstallAppInEmulator {

	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		dc.setCapability(MobileCapabilityType.APP, "E:\\MS\\Automation Softwares\\Appium\\Apk Info_v2.0.9_apkpure.com.apk");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");		
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url, dc);
		driver.quit();
	}

}
