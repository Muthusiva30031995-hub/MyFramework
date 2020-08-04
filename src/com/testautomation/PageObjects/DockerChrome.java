package com.testautomation.PageObjects;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.Status;
import com.testautomation.PageUI.LoginPageUI;

public class DockerChrome {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		@SuppressWarnings("static-access")
		DesiredCapabilities dc = new DesiredCapabilities().chrome();			
		URL url = new URL("httP://localhost:4444/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(url,dc);
		driver.get("https://opensource-demo.orangehrmlive.com");	
		System.out.println("Opened Application");
		String userName = "Admin";
		String passWord = "admin123";
		driver.findElement(LoginPageUI.usernameTxt).sendKeys(userName);
		driver.findElement(LoginPageUI.passwordTxt).sendKeys(passWord);
		driver.findElement(LoginPageUI.loginBtn).click();
		Thread.sleep(5000);
		System.out.println("Logged in to the Application");
		driver.quit();
	}

}
