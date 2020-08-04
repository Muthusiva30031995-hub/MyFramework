package com.testautomation.PageUI;

import org.openqa.selenium.By;

import com.testautomation.PageObjects.PageBase;

public class LoginPageUI {
	
	public static final By usernameTxt = By.xpath("//input[@name='txtUsername']");
	public static final By passwordTxt = By.xpath("//input[@name='txtPassword']");
	public static final By loginBtn = By.xpath("//input[@name='Submit']");
	public static final By homePage = By.xpath("//h1[text()='Dashboard']");
	public static final By settings = By.xpath("//div[@id=\"gw-TabBarWidget--settings\"]");
	public static final By logoutBtn = By.xpath("//div[@id=\"TabBar-LogoutTabBarLink\"]");

}
