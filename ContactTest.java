package com.crm.testsc;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.crm.base.Base;
import com.crm.pagelib.Contacts;
import com.crm.pagelib.HomePage;
import com.crm.pagelib.Login;
import com.crm.util.Util;

public class ContactTest extends Base {
	Login ln;
	HomePage hm;
	Util ut;
	Contacts ct;
	public ContactTest()
	{
		super();
	}
    @BeforeMethod
    public void initmethod()
    {
    	initiliation();
    	ln=new Login();
    	hm=ln.homeaction(ps.getProperty("un"),ps.getProperty("pwd"));
    	ut=new Util();
    	ut.switchto();
        hm.Contact();
    	ct=new Contacts();
    	//ut.switchto();
    	
    }
    @Test(priority=1,enabled=true)
    public void verifycontact()
    {
    /*	String act;
    	String dum;
    	if(ct.contactlbl()==true)
    	{
    		act="True";
    	}else
    	{
    		act="False";
    	}
    	dum="True";
    	Assert.assertEquals(act, dum);*/
    	//ut.switchto();
    	Assert.assertTrue(ct.contactlbl());
    }
    @Test(priority=2,enabled=true)
    public void clickcheakbox()
    {
    	//ut.switchto();
    	ct.clickcheak();
    }
    @DataProvider
     public Iterator<java.lang.Object[]> Getdata()
	{
		ArrayList<java.lang.Object[]> dataa =Util.Excelmethods();
		
		return dataa.iterator();
	}
     
    @Test(dataProvider="Getdata",enabled=false)
    public void NewContact(String Title,String FName,String LName)
    {   
    	hm.Newcontactclk();
    	ct.NContactFill(Title,FName,LName);
    }
	@AfterMethod
	public void cloose()
	{
		driver.close();
	}
	
}
