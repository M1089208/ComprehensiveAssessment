package com.PageObjects;

import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.UiStore.LiveChatUi;
import com.runner.Base;

public class LiveChatPage extends Base{
	
	LiveChatUi lu=new LiveChatUi();
	
	public void go_To_ChatPage()
	{
		wd.onClick(lu.livechatLink, driver);
		logger.logInfo("Clicking on LiveChat Link");
	}
	
	public boolean isChatNowbtnDisplayed() throws RuntimeException
	{

		boolean chatbtnavailability = false;
		try {
						
			WebElement textele=driver.findElement(lu.chatclosed);
			if(textele.isDisplayed())
			{
				chatbtnavailability= false;
			
			}
			else
			{
				chatbtnavailability= true;
			
			}
		}
		catch(Exception e)
		{
			chatbtnavailability= true;
			throw new RuntimeException(e.getMessage());
		}
		return chatbtnavailability;
	}
	
	public void go_To_Livechat()
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
		
	}
	
	public void toFillDetails(String fname,String lname,String email)
	{
		wd.sendText(lu.firstname, fname, driver);
		wd.sendText(lu.lastname, lname, driver);
		wd.sendText(lu.email, email, driver);
		logger.logInfo("Entered all details");
		
		wd.onClick(lu.chatbtn, driver);
	}
	
	public void validatePage()
	{
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

}
