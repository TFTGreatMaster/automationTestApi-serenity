package com.serene.tests.features;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;


import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features= "src/test/resources/Feature.Pet/Pet.Feature")

public class TestRunner {
	
}
