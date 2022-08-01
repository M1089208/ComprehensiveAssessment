package com.PageObjects;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.UiStore.LiveChatUi;
import com.runner.Base;


public class LiveChatPage extends Base{
	
	LiveChatUi lu=new LiveChatUi();
	
	@Test(priority=0)
	public void go_To_ChatPage()
	{
		wd.onClick(lu.livechatLink, driver);
		logger.logInfo("Clicking on LiveChat Link");
	}
	
	@Test(priority=1)
	public boolean isChatNowbtnDisplayed() throws RuntimeException
	{

		boolean chatbtnavailability = false;
		try {
			
			wd.implictWait(driver, 3);
				
			WebElement textele=driver.findElement(lu.chatclosed);
			if(textele.isDisplayed())
			{
				logger.logWarn("LiveChat is not available now!");
				chatbtnavailability= true;
			
			}
			else
			{
				logger.logInfo("LiveChat is available now!");
				chatbtnavailability= false;
			
			}
		}
		catch(Exception e)
		{
			throw new RuntimeException(e.getMessage());
		}
		return chatbtnavailability;
	}
	
	@Test(priority=2,dataProvider="testdata")
	public void go_To_Livechat(String fname,String lname,String email)
	{
		if(!isChatNowbtnDisplayed())
		{
		wd.onClick(lu.chatnowBtn, driver);
		logger.logInfo("Clicking on Chat Now button");
		
		Set<String> ids=driver.getWindowHandles();
		Iterator<String> it=ids.iterator();
		
		String pid=it.next();
		String cid=it.next();
		
		wd.implictWait(driver, 10);
		driver.switchTo().window(cid);
		
		wd.onClick(lu.agreeBtn, driver);
		logger.logInfo("Clicking on agree and continue button");
		
		wd.sendText(lu.firstname, fname, driver);
		wd.sendText(lu.lastname, lname, driver);
		wd.sendText(lu.email, email, driver);
		logger.logInfo("Entered all details");
		
		wd.onClick(lu.chatbtn, driver);
		
		WebElement endchatele=driver.findElement(lu.endchatbtn);
		if(endchatele.isDisplayed())
		{
			Assert.assertTrue(true);
			logger.logInfo("User is on LiveChat page");
		}
		else
		{
			Assert.assertTrue(false);
			logger.logError("User is on incorrect page");
		}
		
		}
		else {
			
			logger.logWarn("LiveChat is not available now!");
		}
		
	}
	
	
	@DataProvider(name="testdata")
	public Object getData() throws IOException
	{
		
		String filepath=cfr.getExcelFilePath();
		String sheetname="Livechatpage";
		
		Object data[][]=new Object[1][3];
		
		data[0][0]=ed.getCellData(filepath, sheetname, 1, 0);
		System.out.println("fname= "+data[0][0]);
		data[0][1]=ed.getCellData(filepath, sheetname, 1, 1);
		System.out.println("lname= "+data[0][1]);
		data[0][2]=ed.getCellData(filepath, sheetname, 1, 2);
		System.out.println("Email= "+data[0][2]);
		
		return data;
		
	}

}
