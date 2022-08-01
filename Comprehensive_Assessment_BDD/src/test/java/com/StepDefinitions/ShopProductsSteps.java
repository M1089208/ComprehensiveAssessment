package com.StepDefinitions;

import java.io.IOException;

import com.PageObjects.ShopProductsPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShopProductsSteps {

	ShopProductsPage sp=new ShopProductsPage();
	
	@Given("User is on website home page")
	public void user_is_on_website_home_page() {
	    
		sp.getUrl();
	}
	
	
	@When("User mouse hovers on Shop Products and click on Stain Remover")
	public void user_mouse_hovers_on_shop_products_and_click_on_stain_remover() {
	    
		sp.go_To_Shop_Products();
	}
	
	@And("User clicks on Deep Clean")
	public void user_clicks_on_deep_clean() {
	    
		sp.go_To_Deep_Clean();
	}
	
	@And("User prints the number of products available on that page")
	public void user_prints_the_number_of_products_available_on_that_page() {
	    
		sp.print_No_Of_Products();
	}
	
	@Then("Validate the page")
	public void validate_the_page() throws IOException {
	    
		sp.containsString();
	}
}
