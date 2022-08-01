package com.StepDefinitions;

import com.PageObjects.HowToWashClothesPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HowToWashClothesSteps {
	
	HowToWashClothesPage hp=new HowToWashClothesPage();
	
	@When("User clicks on How to Wash Clothes Link")
	public void user_clicks_on_how_to_wash_clothes_link() {

		hp.goTo_HowToWashClothes();

	}
	
	@Then("Validate Fabric Care link is present")
	public void validate_fabric_care_link_is_present() {

		hp.isLinkPresent();

	}


}
