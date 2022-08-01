package com.StepDefinitions;

import com.PageObjects.LiveChatPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LiveChatSteps {

	LiveChatPage lp=new LiveChatPage();
	
	@When("User clicks on LiveChat link")
	public void user_clicks_on_live_chat_link() {
	    
		lp.go_To_ChatPage();
	}
	
	@Then("Validate ChatNow button is available or not")
	public void validate_chat_now_button_is_available_or_not() {
	   
		if(lp.isChatNowbtnDisplayed())
		{
			lp.logger.logInfo("LiveChat is available now");
		}
		else
		{
			lp.logger.logWarn("LiveChat is not available now");
		}
		
	}
	
	@And("User clicks on ChatNow button")
	public void user_clicks_on_chat_now_button() {
	   
		if(lp.isChatNowbtnDisplayed())
		{
		lp.go_To_Livechat();
		}
		
	}
	
	@And("User enters {string} {string} and {string}")
	public void user_enters_and(String fname, String lname, String email) {
	    
		if(lp.isChatNowbtnDisplayed())
		{
		lp.toFillDetails(fname, lname, email);
		}
	}
	
	@Then("Validate EndChat is displayed or not")
	public void validate_end_chat_is_displayed_or_not() {
		if(lp.isChatNowbtnDisplayed())
		{
		lp.validatePage();
		}
	}
}
