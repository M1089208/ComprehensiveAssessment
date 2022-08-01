package com.utility;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class RWD {
	
	WebDriver driver;
	public ConfigFileReader cfr=new ConfigFileReader();
	
	/*
	 * public RWD(WebDriver driver) { this.driver=driver; }
	 */
	
	public WebDriver chromeMobileAutomation()
	{
		System.setProperty("webdriver.chrome.driver", cfr.getChromePath());
		Map<String, String> mobileEmulation= new HashMap<String, String> ();
		mobileEmulation.put ("deviceName", "Nexus 5");
		Map<String, Object> chromeOptions= new HashMap<String, Object>();
		chromeOptions.put ("mobileEmulation", mobileEmulation);
		DesiredCapabilities capabilities=DesiredCapabilities.chrome();
		capabilities.setCapability (ChromeOptions.CAPABILITY, chromeOptions);
		driver=new ChromeDriver(capabilities);
		Dimension dimension=new Dimension(400,500);
		driver.manage ().window ().setSize (dimension);
		return driver;
	}
	
	public WebDriver edgeMobileAutomation()
	{
		System.setProperty("webdriver.edge.driver", cfr.getEdgePath());
		Map<String, String> mobileEmulation= new HashMap<String, String> ();
		mobileEmulation.put ("deviceName", "Nexus 5");
		Map<String, Object> edgeOptions= new HashMap<String, Object>();
		edgeOptions.put ("mobileEmulation", mobileEmulation);
		DesiredCapabilities capabilities=DesiredCapabilities.edge();
		capabilities.setCapability (ChromeOptions.CAPABILITY, edgeOptions);
		driver=new EdgeDriver(capabilities);
		Dimension dimension=new Dimension(400,500);
		driver.manage ().window ().setSize (dimension);
		return driver;
	}

}
