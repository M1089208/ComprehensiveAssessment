package com.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.UiStore.WhatsNewUi;
import com.runner.Base;

public class WhatsNewPage extends Base{
	
	WhatsNewUi wu=new WhatsNewUi();
	
	
	@Test
	public void go_To_WhatsNew()
	{
		wd.onClick(wu.whatsNewLink, driver);
		logger.logInfo("Clicked on \"What\'s New \" page");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", wd.getWebElement(driver, wu.learnMore));
		
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(wu.popUp));
		wd.onClick(wu.popUp, driver);
		
		js.executeScript("arguments[0].scrollIntoView();", wd.getWebElement(driver, wu.latestArticles));
		wd.onClick(wu.latestArticles, driver);
		logger.logInfo("Clicked on \"Latest Articles\" ");
		
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
