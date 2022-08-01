package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReport {
	
	public static ExtentSparkReporter sparkReporter;
    public static ExtentReports extent;
    public static ExtentTest test;
    public String timeStamp=new SimpleDateFormat("yyyy-MM-dd.hh-mm-ss").format(new Date());

	
	public void onStart (String string)
	{
		String repName="Extent_Report_"+timeStamp+".html";
		File src=new File(System.getProperty("user.dir")+"/ExtentReports/"+repName);
		
		sparkReporter=new ExtentSparkReporter(src);
		try {
			sparkReporter.loadXMLConfig("./extent-config.xml");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		extent=new ExtentReports();
		
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Host Name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "M1089208");
		
		sparkReporter.config().setDocumentTitle("Amazon Test Project");
		sparkReporter.config().setReportName("Functional Test Automation Report");
		sparkReporter.config().setTheme(Theme.DARK);
		
	}

}
