package com.ReusableComponents;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.runner.Base;

public class WebDriverHelper extends Base{
	


	
	public void onClick(By by,WebDriver driver)
	{
		driver.findElement(by).click();
	}
	
	public void sendText(By by,String text,WebDriver driver)
	{
		driver.findElement(by).sendKeys(text);
	}
	
	public void clearText(By by,WebDriver driver)
	{
		driver.findElement(by).clear();
	}
	
	public void sendKey(By by,WebDriver driver)
	{
		driver.findElement(by).sendKeys(Keys.ENTER);
	}
	
	public String getPageTitle(WebDriver driver)
	{
		return driver.getTitle();
	}
	
	public void implictWait(WebDriver driver,int time)
	{
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	public void popUp(WebDriver driver,By by)
	{
		
		try {
			WebElement ele=driver.findElement(by);
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", ele);
			wd.implictWait(driver, 4);
			logger.logInfo("popup is displayed");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public WebElement getWebElement(WebDriver driver,By by)
	{
		return driver.findElement(by);
	}

}
