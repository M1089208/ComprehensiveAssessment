package com.PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.UiStore.ShopProductsUi;
import com.runner.Base;

public class ShopProductsPage extends Base{

	ShopProductsUi sp=new ShopProductsUi();	
	
	@Test(priority=0)
	public void go_To_Shop_Products()
	{
		wd.popUp(driver, sp.popUp);
		WebElement productEle=driver.findElement(sp.shopProductsLink);
		Actions action=new Actions(driver);
		action.moveToElement(productEle).build().perform();
		logger.logInfo("Mouse hover on Shop Products");
		
		wd.onClick(sp.stainRemover, driver);
		logger.logInfo("Navigate to Stain Remover page");
	}
	
	@Test(priority=1)
	public void go_To_Deep_Clean()
	{
		wd.onClick(sp.deepClean, driver);
		logger.logInfo("Click on deep clean");

		wd.popUp(driver, sp.popUp);
		
	}
	
	@Test(priority=2)
	public void print_No_Of_Products()
	{
		String products=driver.findElement(sp.productsNo).getText();
		System.out.println("Number of products= "+products);
	}
	
	@Test(priority=3)
	public void containsString() throws IOException
	{
		String filepath=cfr.getExcelFilePath();
		String sheet=cfr.getExcelSheetName();
		
		String text=ed.getCellData(filepath, sheet, 1, 0);
		
		System.out.println("text in product: "+text);
		if(driver.getPageSource().contains(text))
		{
			logger.logInfo("User is on correct page");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
			logger.logError("Invalid page");
		}
	}
}
