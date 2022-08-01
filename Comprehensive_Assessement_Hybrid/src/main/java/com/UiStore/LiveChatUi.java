package com.UiStore;

import org.openqa.selenium.By;

public class LiveChatUi {
	
	public By livechatLink=By.linkText("Live Chat");
	
	public By chatnowBtn=By.xpath("//button[contains(text(),'Chat now')]");
	
	public By text=By.xpath("//h4[contains(text(),'Then you have come to the right place!')]");
	
	public By chatclosed=By.xpath("//button[contains(text(),'Chat closed')]");
	
	public By agreeBtn=By.id("acceptGDPR");
	
	public By firstname=By.id("firstNameField");
	
	public By lastname=By.id("lastNameField");
	
	public By email=By.id("emailField");
	
	public By chatbtn=By.cssSelector("#test");
	
	public By endchatbtn=By.cssSelector("#idEndChatBtn");
	
	public By popup=By.xpath("//*[@id=\"lilo3746-wrapper\"]/div/a");
	

}
