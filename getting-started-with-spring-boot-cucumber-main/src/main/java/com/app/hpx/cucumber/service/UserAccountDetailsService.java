package com.app.hpx.cucumber.service;

import java.util.List;

import com.app.hpx.cucumber.request.UserAccountDetailsRequest;
import com.app.hpx.cucumber.response.UserAccountDetailsResponse;

public interface UserAccountDetailsService {
		
		UserAccountDetailsResponse createUserAccountDetails(UserAccountDetailsRequest userAccountDetailsRequest);

		UserAccountDetailsResponse updateUserAccountDetails(String userKey, UserAccountDetailsRequest userAccountDetailsRequest);
		
		UserAccountDetailsResponse displayUserAccountDetails(String userKey);
		
		UserAccountDetailsResponse removeUserAccountDetails(String userKey);
		
		List<UserAccountDetailsResponse> displayAllUsersAccountDetails(boolean enabledOnly);
}
