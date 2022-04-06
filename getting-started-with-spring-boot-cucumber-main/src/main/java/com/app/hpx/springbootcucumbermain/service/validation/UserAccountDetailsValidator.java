package com.app.hpx.springbootcucumbermain.service.validation;

import org.springframework.stereotype.Component;

import com.app.hpx.springbootcucumberinterface.request.UserAccountDetailsRequest;

@Component
public class UserAccountDetailsValidator {
		protected boolean validateUserAccountDetailsRequest(UserAccountDetailsRequest userAccountDetailsRequest){
				return false;
		}
		
		
}
