package com.PageObjects;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.UiStore.WhatsNewUi;
import com.runner.Base;

public class WhatsNewPage extends Base{
	
	WhatsNewUi wu=new WhatsNewUi();
	
	

	public void go_To_WhatsNew()
	{
		wd.onClick(wu.whatsNewLink, driver);
		logger.logInfo("Clicked on \"What\'s New \" page");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", wd.getWebElement(driver, wu.learnMore));
		
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(wu.popUp));
		wd.onClick(wu.popUp, driver);
	}
	
	public void go_to_LatestArticles()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", wd.getWebElement(driver, wu.latestArticles));
		wd.onClick(wu.latestArticles, driver);
		logger.logInfo("Clicked on \"Latest Articles\" ");
	}
	
	public void validation()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", wd.getWebElement(driver, wu.text));
		if(wd.getWebElement(driver, wu.text).isDisplayed())
		{
			Assert.assertTrue(true);
			logger.logInfo("correct page ");
		}
		else
		{
			Assert.assertTrue(false);
			logger.logInfo("incorect page");
		}
		
		
		
	}

}
