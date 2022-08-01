package com.runner;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.ReusableComponents.WebDriverHelper;
import com.utility.*;


public class Base {
	
	public WebDriverHelper wd=new WebDriverHelper();
	public Log4j logger=new Log4j();
	public ConfigFileReader cfr=new ConfigFileReader();
	public TakeScreenShot ts=new TakeScreenShot();
	public RWD rwd=new RWD();
	public static WebDriver driver;
	public String baseUrl=cfr.getUrl();
	public ExcelData ed=new ExcelData();
	
static {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		System.setProperty("current.date.time", dateFormat.format(new Date()));
    }

	public void launchBrowser()
	{
		String browser=cfr.getBrowser();
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			//driver=rwd.chromeMobileAutomation();
			System.setProperty("webdriver.chrome.driver", cfr.getChromePath());
			driver=new ChromeDriver();
			
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			//driver=rwd.edgeMobileAutomation();
			System.setProperty("webdriver.edge.driver", cfr.getEdgePath());
			driver=new EdgeDriver();
		}
		
		logger.logInfo("Browser is launched");
		driver.manage().window().maximize();
			
	}
	
	public void closeBrowser()
	{
		driver.quit();
		logger.logDebug("Browser is closed");
	}
}
