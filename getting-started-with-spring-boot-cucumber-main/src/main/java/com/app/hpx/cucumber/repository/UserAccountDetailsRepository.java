package com.app.hpx.cucumber.repository;

import java.util.List;

import com.app.hpx.cucumber.entity.UserAccountDetailsEntity;

public interface UserAccountDetailsRepository {
		UserAccountDetailsEntity createUserAccountDetails(UserAccountDetailsEntity userAccountDetailsEntity);
		
		UserAccountDetailsEntity updateAccountDetails(String userKey, UserAccountDetailsEntity userAccountDetailsEntity);
		
		UserAccountDetailsEntity displayUserAccountDetails(String userKey);
		
		UserAccountDetailsEntity removeUserAccountDetails(String userKey);
		
		List<UserAccountDetailsEntity> displayAllUsersAccountDetails(boolean enabledOnly);
}
