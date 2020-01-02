package com.qa.utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

public class BootsUtilityClass {

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	//private static XSSFRow Row;
	public static FileInputStream ExcelFile = null;

public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {   

   String[][] tabArray = null;

   try {

   ExcelFile = new FileInputStream(FilePath);

   // Access the required test data sheet

   ExcelWBook = new XSSFWorkbook(ExcelFile);

   ExcelWSheet = ExcelWBook.getSheet(SheetName);

   int startRow = 1;

   int startCol = 1;

   int ci,cj;

   int totalRows = ExcelWSheet.getLastRowNum();

   // you can write a function as well to get Column count

   int totalCols = 2;

   tabArray=new String[totalRows][totalCols];

   ci=0;

   for (int i=startRow;i<=totalRows;i++, ci++) {              

  cj=0;

   for (int j=startCol;j<=totalCols;j++, cj++){

   tabArray[ci][cj]=getCellData(i,j);

   System.out.println(tabArray[ci][cj]);  

}

}

}

catch (FileNotFoundException e){

System.out.println("Could not read the Excel sheet");

e.printStackTrace();

}

catch (IOException e){

System.out.println("Could not read the Excel sheet");

e.printStackTrace();

}

return(tabArray);

}

public static String getCellData(int RowNum, int ColNum) throws Exception {

try
{

Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

int dataType = Cell.getCellType();

if  (dataType == 3) 
{

return "";

}
else
{

String CellData = Cell.getStringCellValue();

return CellData;

}
}
catch (Exception e)
{

System.out.println(e.getMessage());

throw (e);

}
}

//method to move mouse on screen with hand icon
		public static WebElement Mousemove(WebElement e) throws AWTException
		{
			org.openqa.selenium.Point coordinates = e.getLocation();
			Robot robot = new Robot();
			robot.mouseMove(coordinates.getX(),coordinates.getY()+120);
			return e;
		}
}



