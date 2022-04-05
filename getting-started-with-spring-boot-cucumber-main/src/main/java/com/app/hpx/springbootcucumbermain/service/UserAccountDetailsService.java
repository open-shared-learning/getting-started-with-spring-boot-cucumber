package com.app.hpx.springbootcucumbermain.service;

import com.app.hpx.springbootcucumberinterface.request.UserAccountDetailsRequest;
import com.app.hpx.springbootcucumberinterface.response.UserAccountDetailsResponse;

public interface UserAccountDetailsService {
		UserAccountDetailsResponse createUserAccountDetails(UserAccountDetailsRequest userAccountDetailsRequest);
}
