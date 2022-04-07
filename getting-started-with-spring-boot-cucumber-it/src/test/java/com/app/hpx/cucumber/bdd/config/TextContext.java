package com.app.hpx.cucumber.bdd.config;

import org.springframework.stereotype.Component;

import com.app.hpx.cucumber.request.UserAccountDetailsRequest;
import com.app.hpx.cucumber.response.UserAccountDetailsResponse;

import io.cucumber.spring.ScenarioScope;

@Component
@ScenarioScope
public class TextContext {
		private UserAccountDetailsRequest userAccountDetailsRequest;
		private UserAccountDetailsResponse userAccountDetailsResponse;
		
		public UserAccountDetailsRequest getUserAccountDetailsRequest() {
				return userAccountDetailsRequest;
		}
		
		public void setUserAccountDetailsRequest(UserAccountDetailsRequest userAccountDetailsRequest) {
				this.userAccountDetailsRequest = userAccountDetailsRequest;
		}
		
		public UserAccountDetailsResponse getUserAccountDetailsResponse() {
				return userAccountDetailsResponse;
		}
		
		public void setUserAccountDetailsResponse(UserAccountDetailsResponse userAccountDetailsResponse) {
				this.userAccountDetailsResponse = userAccountDetailsResponse;
		}
}
