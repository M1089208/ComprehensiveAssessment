package com.PageObjects;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.UiStore.ShopProductsUi;
import com.runner.Base;

public class ShopProductsPage extends Base{

	ShopProductsUi sp=new ShopProductsUi();
	Actions action=new Actions(driver);
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	public void getUrl()
	{
		driver.get(baseUrl);
		logger.logInfo("Navigate to Tide website");
		try {
			WebElement ele=driver.findElement(sp.popUp);
			js.executeScript("arguments[0].click();", ele);
			wd.implictWait(driver, 4);
			logger.logInfo("popup is displayed");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void go_To_Shop_Products()
	{
		WebElement productEle=driver.findElement(sp.shopProductsLink);
		action.moveToElement(productEle).build().perform();
		logger.logInfo("Mouse hover on Shop Products");
		
		wd.onClick(sp.stainRemover, driver);
		logger.logInfo("Navigate to Stain Remover page");
	}
	
	public void go_To_Deep_Clean()
	{
		wd.onClick(sp.deepClean, driver);
		logger.logInfo("Click on deep clean");
		try {
			WebElement ele=driver.findElement(sp.popUp);
			js.executeScript("arguments[0].click();", ele);
			wd.implictWait(driver, 4);
			logger.logInfo("popup is displayed");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void print_No_Of_Products()
	{
		String products=driver.findElement(sp.productsNo).getText();
		System.out.println("Number of products= "+products);
	}
	
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
