package com.PageObjects;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.UiStore.CouponsAndRewardsUi;
import com.runner.Base;

public class CouponsAndRewardsPage extends Base{
	
	CouponsAndRewardsUi cu=new CouponsAndRewardsUi();
	
	public void getCouponsAndRewards()
	{
		wd.implictWait(driver, 2);
		wd.onClick(cu.couponsAndRewards, driver);
		logger.logInfo("Clicked on \"Coupons and Rewards\" link");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", wd.getWebElement(driver, cu.saveNowBtn));
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cu.popUp));
		wd.onClick(cu.popUp, driver);
	}
	
	public void validatePage()
	{
		
		wd.implictWait(driver, 3);
		if(wd.getWebElement(driver, cu.validation1).isDisplayed())
		{
			Assert.assertTrue(true);
			logger.logInfo("Current page is \"Coupons and Rewards\" page");
		}
		else
		{
			Assert.assertTrue(false);
			logger.logInfo("incorect page");
		}
		wd.onClick(cu.saveNowBtn, driver);
		logger.logInfo("Clicked on \"Save Now\" button");
				
	}

}
