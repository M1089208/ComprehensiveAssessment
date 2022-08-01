package com.PageObjects;

import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.UiStore.TermsAndConditionsUi;
import com.runner.Base;


public class TermsAndConditionsPage extends Base{
	
	TermsAndConditionsUi tu=new TermsAndConditionsUi();
	JavascriptExecutor js=(JavascriptExecutor)driver;

	public void go_To_Terms_ConditionsPage()
	{
		WebElement termsConditionsEle=driver.findElement(tu.terms_Conditions);
		js.executeScript("arguments[0].scrollIntoView();", termsConditionsEle);
		
		wd.onClick(tu.terms_Conditions, driver);
		logger.logInfo("clicked on \"Terms & Conditions\" link in footer section");
	}
		
	public void go_To_ThirdPartyLinks()
	{
		Set<String> ids=driver.getWindowHandles();
		Iterator<String> it=ids.iterator();
		
		String pid=it.next();
		String cid=it.next();
		
		wd.implictWait(driver, 10);
		driver.switchTo().window(cid);
		
		wd.implictWait(driver, 3);
		
		WebElement thirdPartyEle=driver.findElement(tu.thirdPartyLinks);
		js.executeScript("arguments[0].scrollIntoView();", thirdPartyEle);
		wd.onClick(tu.thirdPartyLinks, driver);
		logger.logInfo("Clicked on \"Third Party Links\" under \"Terms & Conditions\" ");
	}
		
	public void isGeographicPresent()
	{
		WebElement geoghapicEle=driver.findElement(tu.geographicString);
		js.executeScript("arguments[0].scrollIntoView();", geoghapicEle);
		if(geoghapicEle.isDisplayed())
		{
			Assert.assertTrue(true);
			logger.logInfo("Correct Page");
		}
		else
		{
			Assert.assertTrue(false);
			logger.logError("incorrect page");
		}
			
	}

}
