package com.StepDefinitions;

import com.PageObjects.TermsAndConditionsPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TermsAndConditionSteps {
	
	TermsAndConditionsPage tp=new TermsAndConditionsPage();
	
	@When("User clicks on Terms and Conditions link")
	public void user_clicks_on_terms_and_conditions_link() {
	    
		tp.go_To_Terms_ConditionsPage();
	}
	
	@And("User clciks on Third Party Links")
	public void user_clciks_on_third_party_links() {
	   
		tp.go_To_ThirdPartyLinks();
	}
	
	@Then("Validate Geographic text present")
	public void validate_geographic_text_present() {
	    
		tp.isGeographicPresent();
	}


}
