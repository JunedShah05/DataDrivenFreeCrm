package com.crm.pagelib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.base.Base;

public class Contacts extends Base{
	@FindBy(xpath=".//td[contains(text(),'Contacts')]")
	WebElement contactlbl;
    
	@FindBy(xpath=".//a[contains(text(),'jbhjbh bhbjb')] //parent::td[@class='datalistrow']"
    		+"//preceding-sibling :: td[@class='datalistrow']//child::input[@type='checkbox']")
    WebElement concheak;
    @FindBy(xpath=".//select[@name='title']")
    WebElement titl;
    @FindBy(xpath=".//input[@id='first_name']")
    WebElement FNa;
    @FindBy(xpath=".//input[@id='surname']")
    WebElement LNa;
    @FindBy(xpath=".//input[@type='submit']")
    WebElement Subm;
	
	public Contacts()
    {
    	PageFactory.initElements(driver,this);
    }
    
	public boolean contactlbl()
    {
    	return contactlbl.isDisplayed();
    }
    public void clickcheak()
    {
    	concheak.click();
    }
    public void NContactFill(String Title,String FName,String LName)
    {
    		Select oselect=new Select(titl);
    		oselect.selectByValue(Title);
    		FNa.sendKeys(FName);
    		LNa.sendKeys(LName);
    		Subm.click();  		
    }
}
