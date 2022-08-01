package com.PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.UiStore.CommitmentUi;
import com.runner.Base;


public class CommitmentPage extends Base{

	CommitmentUi cu=new CommitmentUi();
	
	@Test(priority=0)
	public void go_To_Our_Commitment_page()
	{
		WebElement com=driver.findElement(cu.commitmentLink);
		Actions action=new Actions(driver);
		action.moveToElement(com).build().perform();
		
		
//		WebElement popup=driver.findElement(By.xpath("//*[@id=\"lilo3746-wrapper\"]/div/a"));
//		popup.click();
		
		wd.onClick(cu.sustainabilityLink, driver);
		logger.logInfo("Click on sustainability");
		
	}
	
	@Test(priority=1)
	public void go_To_LearnMore()
	{
		wd.onClick(cu.learnMorebtn, driver);
		logger.logInfo("Click on Learn More button");
		
	}
	
	@Test(priority=2)
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
