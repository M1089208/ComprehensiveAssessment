package com.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.UiStore.HowToWashClothesUi;
import com.runner.Base;

public class HowToWashClothesPage extends Base{
	
	HowToWashClothesUi hu=new HowToWashClothesUi();
	
	
	@Test
	public void goTo_HowToWashClothes()
	{
		WebElement washEle=driver.findElement(hu.howTowashClothesLink);
		Actions action =new Actions(driver);
		action.moveToElement(washEle).build().perform();
		logger.logInfo("Mouse hovered on \"How To Wash Clothes\" Link");
		
		wd.onClick(hu.diffFabricsColorsLink, driver);
		logger.logInfo("Clicked on \"Washing Different Fabrics and Colors\" link");
		
		WebElement commonTypesEle=driver.findElement(hu.commonFabricsLink);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", commonTypesEle);
		wd.onClick(hu.commonFabricsLink, driver);
		logger.logInfo("clicked on \"A Quick Guide to Washing the Most Common Types of\" link");
		
		WebElement fabricCareEle=driver.findElement(hu.fabricCareLink);
		if(fabricCareEle.isDisplayed())
		{
			Assert.assertTrue(true);
			logger.logInfo("User is landing on correct page");
		}
		else {
			
			Assert.assertTrue(false);
			logger.logWarn("User is landing on incorrect page");
		}
		
	}

}
