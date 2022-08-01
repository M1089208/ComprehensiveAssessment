package com.ReusableComponents;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverHelper {
	

	
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

	public WebElement getWebElement(WebDriver driver, By by) {
		
		return driver.findElement(by);
	}

}
