package com.crm.testsc;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.base.Base;
import com.crm.pagelib.HomePage;
import com.crm.pagelib.Login;

public class LoginTest extends Base{
//	private static final Object False = null;
	public Login lt;
	public String tit;
	HomePage homepage;
	LoginTest()
	{
		super();
	}

	@BeforeMethod
	public void initmethod()
	{
		initiliation();
		lt=new Login();		
	}
	@Test(priority=1,enabled=false)
	public void tgettitle()
	{
		String Title=lt.titlehomepage();
		String ActTitle="#1 Free CRM software in the cloud for sales and service";
		Assert.assertEquals(ActTitle,Title,"TITle Is Diaplayed");
		System.out.println(Title);
	}
	@Test(priority=2,enabled=false)
	public void testisdisplayed()
	{
		String ActTitle = null;
		//String Title = null;
		boolean b=lt.Logo();
		if(b==true)
		{
			 ActTitle="True";
		}else {
			//Title="False";
			}
		Assert.assertEquals(ActTitle,"True","LOGO Is Diaplayed");			
		System.out.println(b);
	}
	@Test(priority=3,enabled=true)
	public void testSignin()
	{	
		homepage=lt.homeaction(ps.getProperty("un"),ps.getProperty("pwd"));
	}
	
	@AfterMethod
	public void cloese()
	{
		driver.quit();
	}
}