package com.testautomation.PageUI;

import org.openqa.selenium.By;

import com.testautomation.PageObjects.PageBase;

public class LoginPageUI {
	
	public static final By usernameTxt = By.xpath("//input[@name='Login-LoginScreen-LoginDV-username']");
	public static final By passwordTxt = By.xpath("//input[@name='Login-LoginScreen-LoginDV-password']");
	public static final By loginBtn = By.xpath("//div[text()='Log In']");
	public static final By homePage = By.xpath("//div[contains(@id,'DesktopActivities-DesktopActivitiesScreen-0')]");
	public static final By settings = By.xpath("//div[@id=\"gw-TabBarWidget--settings\"]");
	public static final By logoutBtn = By.xpath("//div[@id=\"TabBar-LogoutTabBarLink\"]");

}
