package com.crm.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.crm.util.Util;
import com.crm.util.WebEventListener;

public class Base {
	public static WebDriver driver;
	public static Properties ps;
	public static EventFiringWebDriver eve;
    public static WebDriverEventListener evelis; 
	public Base()
	{
	   
		try
		{
			ps=new Properties();
            FileInputStream fis=new FileInputStream("E:\\Eclii_juned_java\\DDWP\\src\\main\\java\\com\\crm\\envvar\\config.properties");
            ps.load(fis);
		}catch (Exception e) {
		    System.err.println("File Not Found");
		}
		
	}
    
	public static void initiliation()
	{
		//String Impwait0=ps.getProperty("Implicitwait");
		//String	LoadTime1=ps.getProperty("LoadTimeout");
		
		//int Impwait=Integer.parseInt(Impwait0);
		//int LoadTime=Integer.parseInt(LoadTime1);
		
		String Browsername=ps.getProperty("Browser");
		if(Browsername.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","E:\\chromedriver.exe");
			driver=new ChromeDriver();			
			
		}else
		{
			driver=new FirefoxDriver();			
		}
		eve=new EventFiringWebDriver(driver);
		evelis=new WebEventListener();
		eve.register(evelis);
		driver=eve;
		driver.get(ps.getProperty("url"));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Util.Impwait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Util.LoadTime,TimeUnit.SECONDS);
		
	}
	}
