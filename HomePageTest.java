package com.crm.testsc;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.Base;
import com.crm.pagelib.Contacts;
import com.crm.pagelib.Deals;
import com.crm.pagelib.HomePage;
import com.crm.pagelib.Login;
import com.crm.pagelib.tasks;
import com.crm.util.Util;

import org.testng.Assert;

public class HomePageTest extends Base{

	HomePage hp;
	Util ul;
	Contacts ct;
	Deals dl;
	tasks tk;
	public HomePageTest()
	{
		super();	
	}
	@BeforeMethod
	public void initmethod()
	{
		initiliation();
		Login ln=new Login();		
		ul=new Util();
		hp=ln.homeaction(ps.getProperty("un"),ps.getProperty("pwd"));
		
	}
	@Test(priority=1)
	public void gettxt()
	{
		String titv=hp.gettitl();
		
		String act="CRMPRO";
		Assert.assertEquals(titv,act,"TITle Is Not Diaplayed");		
	}
	@Test(priority=2)
	public void getusernam()
	{
	   String result;
	   ul.switchto();
	   if(hp.usernam()==true)
	   {
		   result="true";
	   }
	   else
	   {
		   result="False";
	   }
	   Assert.assertEquals(result,"true","TITle Is Not Diaplayed");	
	}
	@Test(priority=3)
	public void clickoncontact()
	{   ul.switchto(); 
		ct=hp.Contact();
	}
	@Test(priority=4)
	public void deels()
	{   ul.switchto(); 
		dl=hp.deal();
	}
	@Test(priority=5)
	public void tassk()
	{   ul.switchto();
		tk=hp.Task();
	}
	@AfterMethod
	public void cloose()
	{
		driver.close();
	}
		
}
