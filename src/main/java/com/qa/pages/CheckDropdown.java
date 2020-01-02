package com.qa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import com.qa.base.BootsBaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import jxl.Sheet;
import jxl.Workbook;

public class CheckDropdown extends BootsBaseClass
{
	 public CheckDropdown() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void TestCase1() throws Exception {
         FileInputStream fi=new FileInputStream("D:/Akshaya/General/Other/"
 		+ "Selenium Projects/Automated Testing With Selenium/Boots_POC/"
 		+ "src/main/java/com/qa/testdata/Testing.xlsx");
         Workbook w=Workbook.getWorkbook(fi);
         Sheet s=w.getSheet(0);
       try
       {
       for (int i = 0; i < s.getRows(); i++)
       {
    	   String s1 = s.getCell(0,i).getContents();
           Thread.sleep(4000);
           driver.findElement(By.xpath("//*[@id='jobs_search']/div[1]/div")).click();
           Thread.sleep(9000);
           driver.findElement(By.xpath("//*[@id='jobs_search']/div[1]/div/ul/li[@data-value='"+s1+"']")).click();
       }
}
catch(Exception e)
{


}
}
	 }
       

