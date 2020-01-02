package com.qa.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.base.BootsBaseClass;
import com.qa.utility.NewUtility;

public class NewTest extends BootsBaseClass
{
	
	public NewTest() throws FileNotFoundException {
		super();
	}
	@BeforeMethod
	public void SetUpStart() throws FileNotFoundException
	{
		Initialization();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws InvalidFormatException, IOException{
	return NewUtility.ExcelRedaer("D:/Akshaya/General/Other/"
			+ "Selenium Projects/Automated Testing With Selenium/Boots_POC/"
			+ "src/main/java/com/qa/testdata/Book1.xlsx", "Sheet1");
	}
	 
	@Test(dataProvider = "getExcelData")
	public void testSenchaLogin(String Keyword, String Location) throws InterruptedException
	{
		 Thread.sleep(4000);
		 driver.findElement(By.xpath("//*[@id='search_text']")).sendKeys(Keyword);
		 Thread.sleep(4000);
		 driver.findElement(By.xpath("//*[@id='location']")).sendKeys(Location);
		//System.out.println(Keyword + ":" + Location);

}
	
	@AfterMethod
	public void SetUpEnd()
	{
		//driver.quit();
	}
	
	
}
