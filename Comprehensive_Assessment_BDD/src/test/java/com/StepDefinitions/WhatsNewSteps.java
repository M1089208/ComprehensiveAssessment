package com.StepDefinitions;

import com.PageObjects.WhatsNewPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WhatsNewSteps {
	
	WhatsNewPage wp=new WhatsNewPage();
	
	@When("User clicks on What's new link")
	public void user_clicks_on_what_s_new_link() {
	    
		wp.go_To_WhatsNew();
	}
	@When("User clicks on Latest Articles")
	public void user_clicks_on_latest_articles() {
	 
		wp.go_to_LatestArticles();
	}
	@Then("Validate Latest Articles page")
	public void validate_latest_articles_page() {
	 
		wp.validation();
	}
	

}
