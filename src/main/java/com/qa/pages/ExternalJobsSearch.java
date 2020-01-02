package com.qa.pages;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.utility.NewUtility;
import com.qa.base.BootsBaseClass;


public class ExternalJobsSearch extends BootsBaseClass
{
	 JavascriptExecutor jsx = (JavascriptExecutor)driver;

	
	//page factory
	        //Enter keywords
			@FindBy(xpath="//*[@id='search_text']")
			WebElement enterkeywordsTextbox;
			
			@FindBy(xpath="//*[@id='jobs_search']/div[1]/ul/li[2]/a[contains(text(), 'support pharmacist')]")
			WebElement enterkeywordsTextboxAuto;
			
			//Enter location
			@FindBy(xpath="//*[@id='location']")
			WebElement enterlocationTextbox;
			
			//Select distance
			@FindBy(xpath="//*[@id='jobs_search']/div[1]/div[3]/div/span")
			WebElement selectDistanceDropdown;
			
			//select distance dropdown option
			//@FindBy(xpath="//*[@id='jobs_search']/div[1]/div/ul/li[@data-value='"+check+"']")
			WebElement selectDistanceDropdownOption;
			
			//Enter job reference
			@FindBy(xpath="//*[@id='job_reference']")
			WebElement enterjobreferenceTextbox;
			
			//Click on filter button
			@FindBy(xpath="//*[@id='jobs_search']/a[1]")
			WebElement filterBtn;
			
			//Select business area
			@FindBy(xpath="//*[@id='jobs_search']/div[2]/div[1]/div/span")
			WebElement selectbusinessareaDropdown;
			
			//Select business area dropdown option
			@FindBy(xpath="//*[@id='jobs_search']/div[2]/div[1]/ul/li[@data-value='Supply Chain']")
			WebElement selectbusinessareaDropdownOption;
			
			//Select function area
			@FindBy(xpath="//*[@id='jobs_search']/div[2]/div[2]/div/span")
			WebElement selectfunctionareaDropdown;
			
			//Select function area dropdown option
			@FindBy(xpath="//*[@id='jobs_search']/div[2]/div[2]/ul/li[@data-value='Supply and Demand Planning']")
			WebElement selectfunctionareaDropdownOption;
			
			//Select specialism
			@FindBy(xpath="//*[@id='jobs_search']/div[2]/div[3]/span")
			WebElement selectspecialismDropdown;
			
			//Select specialism dropdown option
			@FindBy(xpath="//*[@id='jobs_search']/div[2]/div[3]/ul/li[@data-value='Quality']")
			WebElement selectspecialismDropdownOption;
			
			//Select job type
			@FindBy(xpath="//*[@id='jobs_search']/div[2]/div[4]/div/span")
			WebElement selectjobtypeDropdown;
			
			//Select job type dropdown option
			@FindBy(xpath="//*[@id='jobs_search']/div[2]/div[4]/ul/li[@data-value='Full-time']")
			WebElement selectjobtypeDropdownOption;
			
			//Select contract type
			@FindBy(xpath="//*[@id='jobs_search']/div[2]/div[5]/div/span")
			WebElement selectcontracttypeDropdown;
			
			//Select contract type option
			@FindBy(xpath="//*[@id='jobs_search']/div[2]/div[5]/ul/li[@data-value='Permanent']")
			WebElement selectcontracttypeDropdownOption;
			
			//Click on "Lets Search CTA"
			@FindBy(xpath="//*[@id='do-search']/span")
			WebElement letssearchCTA;
			
			//Click on Reset CTA
			@FindBy(xpath="//*[@id='jobs_search']/a[2]")
			WebElement resetCTA;
			
			//Click on 'Read More CTA'
			@FindBy(xpath="//span[text()='Read more']")
			WebElement readmoreCTA;
			
			//Click on Apply button
			@FindBy(xpath="//span[text()='Apply']")
			WebElement applyBTN;
			

	
			//object initialization
			public ExternalJobsSearch() throws FileNotFoundException 
			{
				PageFactory.initElements(driver, this);
				}
			
			//Action
			//Testcase1 : Search jobs with valid data
			public void SearchJobsWithValidData(String key,String Loc,String Dist, String Busi, String Funct,String jobt,String Contr,String Jobr) throws InterruptedException, AWTException
			{
				key = NewUtility.keyword;
				Loc =  NewUtility.location;
				Dist = NewUtility.distancename;
				Busi = NewUtility.businessarea;
				Funct= NewUtility.functionarea;
				//Spal = NewUtility.specialism;
				jobt = NewUtility.jotype;
				Contr = NewUtility.contractype;
				Jobr =  NewUtility.reference;
				Thread.sleep(4000);
				enterkeywordsTextbox.sendKeys(key);
				enterlocationTextbox.sendKeys(Loc);
				selectDistanceDropdown.click();
		        driver.findElement(By.xpath("//*[@id='jobs_search']/div[1]/div[3]/div/ul/li[text()='"+Dist+"']")).click();
				Thread.sleep(4000);
				selectbusinessareaDropdown.click();
		        driver.findElement(By.xpath("//*[@id='jobs_search']/div[2]/div[1]/div/ul/li[text()='"+Busi+"']")).click();
		        Thread.sleep(4000);
				selectfunctionareaDropdown.click();
		        driver.findElement(By.xpath("//*[@id='jobs_search']/div[2]/div[2]/div/ul/li[text()='"+Funct+"']")).click();
		       // Thread.sleep(4000);
		       // selectspecialismDropdown.click();
		       // Thread.sleep(4000);
		       // driver.findElement(By.xpath("//*[@id='jobs_search']/div[1]/div[3]/div/ul/li[text()='"+Spal+"']")).click();
		       // Thread.sleep(4000);
		        Thread.sleep(4000);
		        selectjobtypeDropdown.click();
		        Thread.sleep(4000);
		        driver.findElement(By.xpath("//*[@id='jobs_search']/div[2]/div[4]/div/ul/li[text()='"+jobt+"']")).click();
		        Thread.sleep(4000);
		       // jsx.executeScript("window.scrollBy(0,450)");
		        selectcontracttypeDropdown.click();
		        Thread.sleep(4000);
		        driver.findElement(By.xpath("//*[@id='jobs_search']/div[2]/div[5]/div/ul/li[text()='"+Contr+"']")).click();
		        Thread.sleep(4000);
		       // jsx.executeScript("arguments[0].scrollIntoView();", enterjobreferenceTextbox);
				enterjobreferenceTextbox.sendKeys(Jobr);
		        Thread.sleep(4000);
	            letssearchCTA.click();
	            Thread.sleep(4000);
	            NewUtility.NewtabFunction(readmoreCTA);
	            Thread.sleep(4000);
	            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
				driver.switchTo().window(tabs.get(1)); 
	            applyBTN.click();
	            
				
			}
			
}

			
		
	
