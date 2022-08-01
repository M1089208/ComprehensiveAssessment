package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.runner.Base;



public class ExtentReport extends TestListenerAdapter{

	public static ExtentSparkReporter sparkReporter;
    public static ExtentReports extent;
    public static ExtentTest test;
    public static ConfigFileReader cfr=new ConfigFileReader();
    public String timeStamp=new SimpleDateFormat("yyyy-MM-dd.hh-mm-ss").format(new Date());
    TakeScreenShot tss=new TakeScreenShot();
	
	@Override
	public void onStart(ITestContext testContext) {
		
		
		String repName="Extent_Report_"+timeStamp+".html";
		File src=new File(System.getProperty("user.dir")+"/ExtentReports/"+repName);
		
		sparkReporter=new ExtentSparkReporter(src);
		try {
			sparkReporter.loadXMLConfig(cfr.getExtentCongifFilePath());
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
	
	@Override
	public void onTestSuccess(ITestResult tr) {

		test=extent.createTest(tr.getName());   //create new entry in report
		test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		
		}

	@Override
	public void onTestFailure(ITestResult tr){

		test=extent.createTest(tr.getName());   //create new entry in report
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
		
		try {
			tss.takeSS(Base.driver, tr.getName());
		} catch (IOException e) {
			
			e.printStackTrace();
		}


	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		
		test=extent.createTest(tr.getName());   //create new entry in report
		test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}

	@Override
	public void onFinish(ITestContext testContext) {
		
		extent.flush();
	}
	
	

}
