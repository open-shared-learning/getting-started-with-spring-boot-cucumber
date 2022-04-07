package com.app.hpx.cucumber.bdd;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"classpath:feature"},
		glue = {"com.app.hpx.cucumber.bdd", "com.app.hpx.cucumber.bdd.config"},
		plugin = {"pretty", "html:target/results", "json:target/cucumber.json"},
		tags = "@validation")
@CucumberContextConfiguration
public class RunnerIT {
		
		/* Configuration class for Cucumber test runner.
		 * Make sure 'cucumber.option.glue' points to location where both
		 * CucumberContextConfiguration & step-definitions are present. This is mandatory
		 * from v5.0 onwards for 'cucumber-spring' dependency. They have disabled auto-scanning of
		 * configuration classes, hence cucumber runner would not search for any spring, tests,
		 * step-definitions classes. In the current example, RunnerIT & **StepDefs.java files are both
		 * present in package *.bdd. Hence this makes a valid case for path discovery.
		 * */
}
