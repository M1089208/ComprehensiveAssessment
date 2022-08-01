package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	static Properties pro;
	
	public ConfigFileReader(){
		
		File src=new File(System.getProperty("user.dir")+"/TestData/config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public String getBrowser() {
		
		return pro.getProperty("browser");
	}

	public String getUrl()
	{
		return pro.getProperty("url");
	}
	
	public String getChromePath() {
		
		return pro.getProperty("chromepath");
	}
	
	public String getEdgePath()
	{
		return pro.getProperty("edgepath");
	}
	
	public String getExcelFilePath()
	{
		
		String filePath = pro.getProperty("excelfilepath");
		if(filePath!= null) 
			return filePath;
		else 
			throw new RuntimeException("Excel file path is not found");		
	}
	
	public String  getExcelSheetName()
	{
		return pro.getProperty("excelSheetName");
	}

	public String getApplicationUrl() {
		 
		return pro.getProperty("url");
	}
	
	public String getExtentCongifFilePath()
	{
		return pro.getProperty("extentconfigpath");
	}
}
