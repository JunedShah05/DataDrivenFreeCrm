package com.crm.util;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.crm.base.Base;

public class Util extends Base {
	
	public static long Impwait=80;
	public static long LoadTime=80;
	
	public void switchto()
	{
	        driver.switchTo().frame("mainpanel");
	}
    public static ArrayList<Object[]> Excelmethods()
    {
    	String Title;
    	String FirstN;
    	String LastN;
    	ArrayList<Object[]> al=new ArrayList<Object[]>();
    	
		try
		{
			FileInputStream fis=new FileInputStream("E:\\Eclii_juned_java\\DDWP\\src\\main\\java\\com\\crm\\testdata\\Contact.xls");
			Workbook wb=WorkbookFactory.create(fis);
			Sheet s= wb.getSheet("Sheet1");
			int lastrow=s.getLastRowNum();
			System.out.println(lastrow);
			for(int i=1;i<=lastrow;i++)
			{
				Title=s.getRow(i).getCell(0).getStringCellValue();		
				FirstN=s.getRow(i).getCell(1).getStringCellValue();
				LastN=s.getRow(i).getCell(2).getStringCellValue();
				Object[] ob= {Title,FirstN,LastN};
				al.add(ob);
			}
			
		}catch(Exception e)
		{
				System.err.println("File Not Found");
		}		
		return al;   	
    }
}
