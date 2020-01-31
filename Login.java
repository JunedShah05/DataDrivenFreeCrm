package com.crm.pagelib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.Base;

public class Login extends Base {

@FindBy(xpath=".//input[@name='username']")
	WebElement Username;
	
@FindBy(xpath=".//input[@type='password']")
WebElement password;

@FindBy(xpath=".//input[@type='submit']")
WebElement Signin;

@FindBy(xpath=".//img[@alt='free crm logo']")
WebElement logo;

public HomePage HomePage;

public Login()
{
	PageFactory.initElements(driver, this);
	
}
public String titlehomepage()
{
	return driver.getTitle();
}
public boolean Logo()
{
	return logo.isDisplayed();
}
public HomePage homeaction(String un,String pwd)
{
	Username.sendKeys(un);
	password.sendKeys(pwd);
	Signin.click();
	return new HomePage();
}
}
