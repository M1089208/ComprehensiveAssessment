package com.PageObjects;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.UiStore.CommitmentUi;
import com.runner.Base;

public class CommitmentPage extends Base{

	CommitmentUi cu=new CommitmentUi();
	Actions action=new Actions(driver);
	
	public void go_To_Our_Commitment_page()
	{
		WebElement com=driver.findElement(cu.commitmentLink);
		action.moveToElement(com).build().perform();
		
		
		WebElement popup=driver.findElement(By.xpath("//*[@id=\"lilo3746-wrapper\"]/div/a"));
		popup.click();
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(cu.sustainabilityLink));
		wd.onClick(cu.sustainabilityLink, driver);
		logger.logInfo("Click on sustainability");
		
	}
	
	public void go_To_LearnMore()
	{
		wd.onClick(cu.learnMorebtn, driver);
		logger.logInfo("Click on Learn More button");
		
	}
	
	public void textDisplayed() throws IOException
	{
		String filepath=cfr.getExcelFilePath();
		String sheet=cfr.getExcelSheetName();
		
		String text=ed.getCellData(filepath, sheet, 1, 1);
		System.out.println("text="+text);
		
		if(driver.getPageSource().contains(text))
		{
			Assert.assertTrue(true);
			logger.logInfo("Current page contains"+text);
		}
		else
		{
			Assert.assertTrue(false);
			logger.logError("Incorrect page");
		}
	}
}
