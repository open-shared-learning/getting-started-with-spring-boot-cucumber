package com.app.hpx.cucumber.service.validation;

import org.springframework.stereotype.Component;

import com.app.hpx.cucumber.request.UserAccountDetailsRequest;

@Component
public class UserAccountDetailsValidator {
		protected boolean validateUserAccountDetailsRequest(UserAccountDetailsRequest userAccountDetailsRequest){
				return false;
		}
		
		
}
