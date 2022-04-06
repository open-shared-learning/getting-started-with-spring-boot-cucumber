package com.app.hpx.cucumber.bdd.stepdefs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.app.hpx.cucumber.request.UserAccountDetailsRequest;
import com.app.hpx.cucumber.response.UserAccountDetailsResponse;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateUserApiStepDefs {
		
		/* FIXME: too much clutter with dependencies & data usage */
		private static final Logger LOG = LoggerFactory.getLogger(CreateUserApiStepDefs.class);
		
		private static final String CREATE_USER_API_URL = "http://localhost:8089/app/v1/user/create";
		
		private final RestTemplate restTemplate = new RestTemplate();
		
		private ResponseEntity<UserAccountDetailsResponse> responseEntity;
		private UserAccountDetailsRequest userAccountDetailsRequest;
		
		@Given("To create new user I have user-name as {string}")
		public void toCreateNewUserIHaveUserNameAs(String arg0) {
				userAccountDetailsRequest = new UserAccountDetailsRequest();
				userAccountDetailsRequest.setUserName(arg0);
				
				LOG.info("Create User Request : {}", userAccountDetailsRequest);
		}
		
		@And("I pass first-name as {string}")
		public void iPassFirstNameAs(String arg0) {
				userAccountDetailsRequest.setFirstName(arg0);
				LOG.info("Add First Name in Request : {}", userAccountDetailsRequest);
		}
		
		@And("I pass last-name as {string}")
		public void iPassLastNameAs(String arg0) {
				userAccountDetailsRequest.setLastName(arg0);
				LOG.info("Add Last Name in Request : {}", userAccountDetailsRequest);
		}
		
		@When("I call Create User API")
		public void iCallCreateUserAPI() {
				HttpEntity<UserAccountDetailsRequest> requestHttpEntity = new HttpEntity<>(userAccountDetailsRequest);
				responseEntity = restTemplate.exchange(CREATE_USER_API_URL, HttpMethod.POST, requestHttpEntity, UserAccountDetailsResponse.class);
				
				LOG.info("Create User API Response : {}", responseEntity);
		}
		
		@Then("I get a success response as HTTP {int} OK")
		public void iGetASuccessResponseAsHTTPOK(int arg0) {
				LOG.info("Create User API Response Status : {}", responseEntity.getStatusCodeValue());
				assertEquals(arg0, responseEntity.getStatusCodeValue());
		}
		
		@And("A non-null user-response is received")
		public void aNonNullUserResponseIsReceived() {
				assertNotNull(responseEntity.getBody());
				LOG.info("Create User API Response Body : {}", responseEntity.getBody());
		}
		
		@And("user-response has non-null user-key")
		public void userResponseHasNonNullUserKey() {
				assertNotNull(responseEntity.getBody().getUserKey());
				LOG.info("User Key in Response : {}", responseEntity.getBody().getUserKey());
		}
		
		@And("user-response has first-name as {string}")
		public void userResponseHasFirstNameAs(String arg0) {
				assertEquals(arg0, responseEntity.getBody().getFirstName());
				LOG.info("First Name in Response : {}", responseEntity.getBody().getFirstName());
		}
		
		@And("user-response has last-name as {string}")
		public void userResponseHasLastNameAs(String arg0) {
				assertEquals(arg0, responseEntity.getBody().getLastName());
				LOG.info("Last Name in Response : {}", responseEntity.getBody().getLastName());
		}
}
