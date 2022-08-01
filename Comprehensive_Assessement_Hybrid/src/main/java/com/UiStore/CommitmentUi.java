package com.UiStore;

import org.openqa.selenium.By;

public class CommitmentUi {

	public By commitmentLink = By.cssSelector("a[data-action-detail='Our Commitment']");

	public By sustainabilityLink = By.cssSelector("a[data-action-detail='Sustainability']");

	public By learnMorebtn = By.xpath(
			"//div[contains(@class,'our-commitment-small-articles margin-vertical-none null')]//div[2]//div[1]//div[2]//div[1]//a[2]");


}
