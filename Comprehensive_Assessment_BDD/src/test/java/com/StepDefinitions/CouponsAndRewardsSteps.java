package com.StepDefinitions;

import com.PageObjects.CouponsAndRewardsPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CouponsAndRewardsSteps {
	
	CouponsAndRewardsPage cp=new CouponsAndRewardsPage();
	
	@When("User clicks on Coupons and Rewards link")
	public void user_clicks_on_coupons_and_rewards_link() {
	    
		cp.getCouponsAndRewards();
	}
	@Then("Validate the Coupons and Rewards page")
	public void validate_the_coupons_and_rewards_page() {
	    
		cp.validatePage();
		
	}


}
