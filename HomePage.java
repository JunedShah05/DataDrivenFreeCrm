package com.crm.pagelib;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.Base;

public class HomePage extends Base{

	@FindBy(xpath=".//a[@title='Contacts']")
	WebElement contact;
	@FindBy(xpath=".//a[@title='Deals']")
	WebElement Deal;
	@FindBy(xpath=".//a[@title='Tasks']")
	WebElement task;
	@FindBy(xpath=".//td[contains(text(),'Juned Shah Rahim Shah')]")
	WebElement usern;
	@FindBy(xpath=".//a[@title='New Contact']")
	WebElement newcon;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String gettitl()
	{
		System.out.println(driver.getTitle());
		return driver.getTitle();
	}
	public boolean usernam()
	{
		
		return usern.isDisplayed();
		
	}
	
	public Contacts Contact()
	{
		contact.click();
		return new Contacts();
	}
	public Deals deal()
	{
		contact.click();
		return new Deals();
	}
	public tasks Task()
	{
		task.click();
		return new tasks();
	}
	public void Newcontactclk()
	{
		Actions action=new Actions(driver);
		action.moveToElement(contact).build().perform();
		newcon.click();
	}
}
