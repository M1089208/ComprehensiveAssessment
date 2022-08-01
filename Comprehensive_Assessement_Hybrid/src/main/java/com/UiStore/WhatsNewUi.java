package com.UiStore;

import org.openqa.selenium.By;

public class WhatsNewUi {
	
	public By whatsNewLink=By.linkText("What’s New");
	
	public By latestArticles=By.xpath("//span[contains(text(),'Latest Articles')]");
	
	public By popUp=By.xpath("//button[@class='sticker_close']");
	
	public By learnMore=By.linkText("Learn More");
	
	public By text=By.xpath("//p[contains(text(),'Research* shows that keeping your environment clea')]");

}
