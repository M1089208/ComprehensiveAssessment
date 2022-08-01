package com.runner;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.ReusableComponents.WebDriverHelper;
import com.utility.ConfigFileReader;
import com.utility.ExcelData;
import com.utility.Log4j;


/**
 * @author M1089208
 *
 */
public class Base {
	
	public static ConfigFileReader cfr=new ConfigFileReader();
	
	public static String baseurl=cfr.getApplicationUrl();
	
	public static String browser=cfr.getBrowser();
	
	public static WebDriverHelper wd=new WebDriverHelper();
	
	public static Log4j logger=new Log4j();
	
	public static WebDriver driver;
	
	public ExcelData ed=new ExcelData();
	
	static {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		System.setProperty("current.date.time", dateFormat.format(new Date()));
    }
	
	
	/**
	 * @throws IOException
	 */
	@BeforeClass
	public void setUp() throws IOException {
		
		//log=Logger.getLogger(Base.class);
		
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",cfr.getChromePath());
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", cfr.getEdgePath());
			driver=new EdgeDriver();
		}
		logger.logInfo("Browser launched successfully");
		driver.manage().window().maximize();
		driver.get(baseurl);
	}
	
	
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
		logger.logDebug("Browser is closed");
	}

}
