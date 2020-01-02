package com.qa.tests;
import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.base.BootsBaseClass;
import com.qa.pages.CheckDropdown;
import com.qa.pages.ExternalJobsSearch;
import com.qa.pages.HomePage;
import com.qa.utility.NewUtility;

//import jxl.Sheet;
//import jxl.Workbook;
//import jxl.read.biff.BiffException;

public class HomePageTest extends BootsBaseClass
{
	HomePage homepage;
	ExternalJobsSearch external;
	CheckDropdown chkdrop;

//constructor
 public HomePageTest() throws FileNotFoundException 
{
	 super();
}	
 
 @DataProvider
 public Object[][] getExcelData() throws InvalidFormatException, IOException{
 return NewUtility.ExcelRedaer("D:/Akshaya/General/Other/"
 		+ "Selenium Projects/Automated Testing With Selenium/Boots_POC/"
 		+ "src/main/java/com/qa/testdata/Book2.xlsx", "Sheet1");
 }
  

public void testSenchaLogin(String keyword, String location, String distance, String Business, String Function, String Jobtype, String Contracttype, String reference) throws InterruptedException, AWTException
 {
 	external.SearchJobsWithValidData(keyword,location,distance,Business,Function,Jobtype,Contracttype,reference);

 }
 
 public void getData()
 {
	 
 }
 
 public void AcceptCookiesTest() throws InterruptedException, AWTException
 {
 	homepage.ValidateAcceptCookies();
 }

 public void SearchJobsExNavigationTest() throws InterruptedException, AWTException
 {
 	homepage.NavigateToSearchJobsExpternalPage();
 }

 public void SearchJobsWithValidDataTest() throws InterruptedException, AWTException, InvalidFormatException, IOException
 {
    getExcelData();
 }

@BeforeMethod
public void SetUpStart() throws FileNotFoundException
{
	Initialization();
	homepage = new HomePage();
	external = new ExternalJobsSearch();
}

@Test(dataProvider = "getExcelData")
public void RunAllTests(String key,String Loc,String Dist, String Busi, String Funct, String jobt, String Contr, String Jobr) throws InterruptedException, AWTException, InvalidFormatException, IOException
{
	//AcceptCookiesTest();
	//SearchJobsExNavigationTest();
	Thread.sleep(4000);
   driver.findElement(By.xpath("//*[contains(text(), 'Accept Cookies')]")).click();
	testSenchaLogin(key,Loc,Dist,Busi,Funct,jobt,Contr,Jobr);
}

/*@Test
public void runtest() throws Exception
{
	//AcceptCookiesTest();
    //SearchJobsExNavigationTest();
	newtest();
	
}*/

/*public void newtest() throws BiffException, IOException
{
	FileInputStream fi=new FileInputStream("D:/Akshaya/General/Other/"
	 		+ "Selenium Projects/Automated Testing With Selenium/Boots_POC/"
	 		+ "src/main/java/com/qa/testdata/mytest.xls");
	         Workbook w=Workbook.getWorkbook(fi);
	         Sheet s=w.getSheet(0);
	       try
	       {
	       for (int i = 1; i < s.getRows(); i++)
	       {
	    	   String s1 = s.getCell(0,1).getContents();
	    	   Thread.sleep(4000);
	    	   driver.findElement(By.xpath("//*[contains(text(), 'Accept Cookies')]")).click();
	    	   Thread.sleep(4000);
	           driver.findElement(By.xpath("//*[@id='jobs_search']/div[1]/div[3]/div/span")).click();
	           Thread.sleep(4000);
	           driver.findElement(By.xpath("//*[@id='jobs_search']/div[1]/div[3]/div/ul/li[text()='"+s1+"']")).click();
	       }
	}
	catch(Exception e)
	{


	}
}*/

@AfterMethod
public void SetUpEnd()
{
	
}
}
