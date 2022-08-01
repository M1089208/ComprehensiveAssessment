package com.PageObjects;



import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ReusableComponents.WebDriverHelper;
import com.UiStore.LoginUi;
import com.runner.Base;

public class LoginPage extends Base {

	
	LoginUi lu=new LoginUi();
	WebDriverHelper wd=new WebDriverHelper();
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	public void setUp()
	{
		driver.get(baseUrl);
		try {
			WebElement ele=driver.findElement(lu.popUp);
			js.executeScript("arguments[0].click();", ele);
			wd.implictWait(driver, 4);
			logger.logInfo("popup is displayed");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void goToLoginPage()
	{
		wd.implictWait(driver, 10);
		wd.onClick(lu.reg, driver);
		logger.logInfo("Click on Register");
		
		WebElement signupbtn=driver.findElement(lu.signup);
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
	
	public void enterCredentials(String email, String password)
	{
		
		wd.sendText(lu.email, email, driver);
		
		wd.sendText(lu.password, password, driver);
		
	
		wd.onClick(lu.login_btn2, driver);
		logger.logInfo("Click on login button");
	}
	
	public void validatePage()
	{
		WebElement profile=driver.findElement(lu.profile);
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
}
