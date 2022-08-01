package com.UiStore;

import org.openqa.selenium.By;

public class LoginUi {

	public By popUp=By.xpath("//button[@class='sticker_close']");
	
	public By reg=By.xpath("//a[contains(text(),'Register')]");
	
	public By signup=By.cssSelector(".event_internal_link");
	
	public By loginbtn=By.xpath("//button[contains(text(),'Log in')]");
	
	public By email=By.id("login-email");
	
	public By password=By.id("login-password");
	
	public By login_btn2=By.cssSelector("input[value='LOG IN']");
	
	public By profile=By.xpath("//div[contains(text(),'ramya')]");
}
