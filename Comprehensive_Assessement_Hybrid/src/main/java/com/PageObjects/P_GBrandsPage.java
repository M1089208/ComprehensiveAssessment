package com.PageObjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.UiStore.P_GBrandsUI;
import com.runner.Base;

public class P_GBrandsPage extends Base{
	
	P_GBrandsUI pu=new P_GBrandsUI();
	
	@Test(priority=0)
	public void go_To_PGBrands()
	{
		wd.onClick(pu.PGBrands, driver);
		logger.logInfo("Clicked on \"P&G Brands\" link");
		
		Set<String> ids=driver.getWindowHandles();
		Iterator <String> it=ids.iterator();
		
		String parentId=it.next();
		String childId=it.next();
		
		wd.implictWait(driver, 10);
		driver.switchTo().window(childId);
		
		WebElement ourBrandsEle=driver.findElement(pu.ourBrands);
		Actions action=new Actions(driver);
		action.moveToElement(ourBrandsEle).build().perform();
		logger.logInfo("Mouse hover on \"Our Brands\" ");

		wd.implictWait(driver, 3);
		JavascriptExecutor js=(JavascriptExecutor)driver;

		wd.onClick(pu.ingredeints, driver);
		logger.logInfo("Clicked on \"Brands\" under \"Our Brands\" ");
		
		js.executeScript("arguments[0].scrollIntoView();", wd.getWebElement(driver, pu.link));
		if(wd.getWebElement(driver, pu.link).isDisplayed())
		{
			Assert.assertTrue(true);
			logger.logInfo("Correct page");
		}
		else {
			logger.logError("incorrect page");
			Assert.assertTrue(false);
		}
		
		
	}

}
