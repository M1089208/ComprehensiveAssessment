package com.PageObjects;



import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.UiStore.LoginUi;
import com.runner.Base;


public class LoginPage extends Base {

	
	LoginUi lu=new LoginUi();
	
	@Test(priority=0)
	public void goToLoginPage()
	{
		wd.popUp(driver, lu.popUp);
		wd.implictWait(driver, 10);
		wd.onClick(lu.reg, driver);
		logger.logInfo("Click on Register");
		
		WebElement signupbtn=driver.findElement(lu.signup);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", signupbtn);
		wd.onClick(lu.signup, driver);
		logger.logInfo("click on signup");
		
		Set<String> ids=driver.getWindowHandles();
		Iterator<String> it=ids.iterator();
		
		String pid=it.next();
		String cid=it.next();
		
		wd.implictWait(driver, 10);
		driver.switchTo().window(cid);
		
		WebElement login=driver.findElement(lu.loginbtn);
		js.executeScript("arguments[0].scrollIntoView();", login);
		wd.implictWait(driver, 10);
		
		wd.onClick(lu.loginbtn, driver);
		logger.logInfo("navigate to login page");
		
	}
	
	@Test(priority=1,dataProvider="testdata")
	public void enterCredentials(String email, String password)
	{
		
		wd.sendText(lu.email, email, driver);
		
		wd.sendText(lu.password, password, driver);
		
	
		wd.onClick(lu.login_btn2, driver);
		logger.logInfo("Click on login button");
	}
	
	@Test(priority=2)
	public void validatePage()
	{
		wd.implictWait(driver, 4);
		WebElement profile=driver.findElement(lu.profile);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", profile);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		if(profile.isDisplayed())
		{
			Assert.assertTrue(true);
			logger.logInfo("User is landing on correct page");
		}
		else {
			logger.logError("incorrect page");
			Assert.assertTrue(false);
		}
	}
	
	
	@DataProvider(name="testdata")
	public Object[][] getData() throws IOException
	{
		
		String filepath=cfr.getExcelFilePath();
		String sheetname="Loginpage";
		
		Object data[][]=new Object[1][2];
		
		data[0][0]=ed.getCellData(filepath, sheetname, 1, 0);
		System.out.println("Email= "+data[0][0]);
		data[0][1]=ed.getCellData(filepath, sheetname, 1, 1);
		System.out.println("password= "+data[0][1]);
		
		return data;
		
	}
}
