package com.StepDefinitions;

import com.PageObjects.P_GBrandsPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class P_GBrandSteps {
	
	P_GBrandsPage pp=new P_GBrandsPage();
	
	@When("User clicks on P&G Brands link")
	public void user_clicks_on_p_g_brands_link() {
	  
		pp.go_To_PGBrands();
	}
	
	@When("User clicks on Ingredients under Our Brands")
	public void user_clicks_on_ingredients_under_our_brands() {
		
		pp.go_To_Ingredentients();

	}
	
	@Then("Validate the current page")
	public void validate_the_current_page() {

		pp.isLinkPresent();
		
	}


}
