package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class BootsBaseClass 
{
    public static WebDriver driver;
    public static Properties prop;
	
	public BootsBaseClass() throws FileNotFoundException
	{
		try
		{
		prop = new Properties();
		FileInputStream ip = new FileInputStream("D:/Akshaya/General/Other/Selenium Projects/"
				+ "Automated Testing With Selenium/Boots_POC/src/main/java/com/qa/config/config.properties");
		prop.load(ip);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
    //code to access the URL
	public static void Initialization()
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
	        options.addArguments("--incognito");
			System.setProperty("webdriver.chrome.driver", "D:/Akshaya/General/Other/eclipse/chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver(options);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
}
