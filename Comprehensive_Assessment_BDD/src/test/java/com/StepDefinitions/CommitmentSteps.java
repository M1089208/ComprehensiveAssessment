package com.StepDefinitions;

import java.io.IOException;

import com.PageObjects.CommitmentPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommitmentSteps {
	
	CommitmentPage cp=new CommitmentPage();
	
	@When("User mouse hovers on Our Commitment and click on Sustainability")
	public void user_mouse_hovers_on_our_commitment_and_click_on_sustainability() {
	    
		cp.go_To_Our_Commitment_page();
	}
	
	@And("User clicks on Learn More under concentrated detergent")
	public void user_clicks_on_learn_more_under_concentrated_detergent() {
	    
		cp.go_To_LearnMore();
	}
	
	@Then("User checks the text is displayed")
	public void user_checks_the_text_is_displayed() throws IOException {

		cp.textDisplayed();

	}

}
