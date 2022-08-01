package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenShot {
	
	public void takeSS(WebDriver driver,String tName) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		String timeStamp=new SimpleDateFormat("yyyy-MM-dd.hh-mm-ss").format(new Date());
		
		String screenShot=System.getProperty("user.dir")+"/Screenshots/"+tName+"_"+timeStamp+"_err.png";
		
		File dest=new File(screenShot);
		
		FileUtils.copyFile(src,dest);
		
		System.out.println("Screen shot is taken");
		
			
	}

}

