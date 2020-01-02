package com.qa.utility;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.base.BootsBaseClass;
 
public class NewUtility extends BootsBaseClass
{
	public NewUtility() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}


	public static String keyword=null;
	public static String location=null;
	public static String reference=null;
	public static String distancename=null;
	public static String businessarea=null;
	public static String functionarea=null;
	//public static String specialism=null;
	public static String jotype=null;
	public static String contractype=null;
	
	public static Object[][] ExcelRedaer(String path, String sheetName) throws InvalidFormatException, IOException {
		FileInputStream file= new FileInputStream(path);
	    XSSFWorkbook wb = new XSSFWorkbook(file);
	    XSSFSheet sheet = wb.getSheet(sheetName);
	    int rowCount = sheet.getLastRowNum();
	    int column = sheet.getRow(0).getLastCellNum();
	    Object[][] data = new Object[rowCount][column];
	    for (int i = 1; i <= rowCount; i++) {
	        XSSFRow row = sheet.getRow(i);
	        for (int j = 0; j < column; j++) {
	            XSSFCell cell = row.getCell(j);
	           // DataFormatter formatter = new DataFormatter();
	           // String val = formatter.formatCellValue(cell);
	           // data[i - 1][j] = val;
	            String keyheader = cell.getSheet().getRow(0).getCell(0).getRichStringCellValue().toString();
	            String keyvalue = cell.getSheet().getRow(1).getCell(0).getRichStringCellValue().toString();
	            String locheader = cell.getSheet().getRow(0).getCell(1).getRichStringCellValue().toString();
	            String locvalue = cell.getSheet().getRow(1).getCell(1).getRichStringCellValue().toString();	
	            String distheader = cell.getSheet().getRow(0).getCell(2).getRichStringCellValue().toString();
	            String distvalue = cell.getSheet().getRow(1).getCell(2).getRichStringCellValue().toString();
	            String busiheader = cell.getSheet().getRow(0).getCell(3).getRichStringCellValue().toString();
	            String busivalue = cell.getSheet().getRow(1).getCell(3).getRichStringCellValue().toString();
	            String funheader = cell.getSheet().getRow(0).getCell(4).getRichStringCellValue().toString();
	            String funvalue = cell.getSheet().getRow(1).getCell(4).getRichStringCellValue().toString();
	           // String splheader = cell.getSheet().getRow(0).getCell(6).getRichStringCellValue().toString();
	         //   String splvalue = cell.getSheet().getRow(1).getCell(6).getRichStringCellValue().toString();
	            String jobheader = cell.getSheet().getRow(0).getCell(5).getRichStringCellValue().toString();
	            String jobvalue = cell.getSheet().getRow(1).getCell(5).getRichStringCellValue().toString();
	            String contheader = cell.getSheet().getRow(0).getCell(6).getRichStringCellValue().toString();
	            String contvalue = cell.getSheet().getRow(1).getCell(6).getRichStringCellValue().toString();
	            String refheader = cell.getSheet().getRow(0).getCell(7).getRichStringCellValue().toString();
	            String refvalue = cell.getSheet().getRow(1).getCell(7).getRichStringCellValue().toString();
	            
	            if(keyheader.equals("Keyword"))
        		{
	            	keyword=keyvalue;
        		}
	            if(locheader.equals("Location"))
        		{
	            	location=locvalue;
        		}
	          
	          if(distheader.equals("Distance"))
        		{
        	distancename=distvalue;
        		}
	      if(busiheader.equals("Businessarea"))
	            {
	            	businessarea=busivalue;
	            		}
	           if(funheader.equals("Functionarea"))
	            {
	            	functionarea=funvalue;
	            		}
	           /* else if(splheader.equals("Specialism"))
	            {
	            	contractype=splvalue;
	            		}*/
	          if(jobheader.equals("Jobtype"))
	            {
	        	  jotype=jobvalue;
	            		}
	           if(contheader.equals("Contracttype"))
	            {
	        	   contractype=contvalue;
	            		}
	           if(refheader.equals("Reference"))
        		{
        	reference=refvalue;
        		}
	        }
	    }

	    return data;
	}



			//method to move mouse on screen with hand icon
			public WebElement Mousemove(WebElement e) throws AWTException
			{
				org.openqa.selenium.Point coordinates = e.getLocation();
				Robot robot = new Robot();
				robot.mouseMove(coordinates.getX(),coordinates.getY()+120);
				return e;
			}
			
			
			//open link in new tab without closing current tab
			public static WebElement NewtabFunction(WebElement ex) throws AWTException, InterruptedException
			{
				 //WebElement rightClickElement=driver.findElement(By.xpath(path));
				 Actions action = new Actions(driver);
				 action.contextClick(ex).build().perform();
				 Thread.sleep(1000);
				 Robot robot = new Robot();
				 robot.keyPress(KeyEvent.VK_DOWN);
				 Thread.sleep(1000);
				 robot.keyRelease(KeyEvent.VK_DOWN);
				 Thread.sleep(1000);
				 robot.keyPress(KeyEvent.VK_ENTER);
				 robot.keyRelease(KeyEvent.VK_ENTER);
				return ex;
			}
	}
	

