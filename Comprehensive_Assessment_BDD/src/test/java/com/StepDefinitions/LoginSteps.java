package com.StepDefinitions;

import com.PageObjects.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	LoginPage lp=new LoginPage();
	
	@Given("User is landing on website home page")
	public void user_is_landing_on_website_home_page() {
	    
		lp.setUp();
	}
	
	@When("User clicks on Login link on the signup page")
	public void user_clicks_on_login_link_on_the_signup_page() {
	   
		lp.goToLoginPage();
	}
	
	@And("User enters {string} and {string}")
	public void user_enters_and(String email, String password) {
	    
		lp.enterCredentials(email, password);
	}
	
	@Then("Validate user is on correct page")
	public void validate_user_is_on_correct_page() {

		lp.validatePage();

	}

}
