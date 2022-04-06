package com.app.hpx.cucumber.bdd;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"classpath:feature"},
		glue = {"com.app.hpx.cucumber.bdd.stepdefs"},
		plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json"},
		tags= "@validation")
@CucumberContextConfiguration
public class RunnerIT {
		/* configuration class for Cucumber test runner */
}
