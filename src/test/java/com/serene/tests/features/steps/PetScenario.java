package com.serene.tests.features.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.restassured.RestAssured;
import net.thucydides.core.annotations.Steps;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.runner.RunWith;



@RunWith(SerenityRunner.class)


public class PetScenario {
	

	@Before
	public void setup()
	{
    	RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";

	}
	
	@After
	public void tearDown()
	{
        RestAssured.reset();
	}

	@Steps
	PetAPISteps petAPI;

	@Given("^I provide petID \"([^\"]*)\"$")
    public void buildRequestGetPetByID(String petID) {
		petAPI.buildRequestGetPetByID(petID);
	}

	@When("^I send request to get Pet By ID$")
	public void sendGetPetByIDRequest() throws Throwable {

		petAPI.sendGetPetByIDRequest();
	}

	@Then("^I Test$")
	public void test() {
		petAPI.test();
	}

	@Then("^I get Pet$")
	public void verifyGetPetByIDSuccess() {
		petAPI.verifyGetPetByIDSuccess();
	}



	@Given("^I provide a new pet \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void buildRequestCreatePet(String petID,String petName, String petStatus) {
		petAPI.buildRequestCreatePet(petID,petName,petStatus);
	}

	@When("^I send request to create a new Pet$")
	public void sendPostCreatePetRequest() throws Throwable {

		petAPI.sendPostCreatePetRequest();
	}

	@Then("^I have a new pet created$")
	public void verifyCreatePetSuccess() {
		petAPI.verifyCreatePetSuccess();
	}



}
