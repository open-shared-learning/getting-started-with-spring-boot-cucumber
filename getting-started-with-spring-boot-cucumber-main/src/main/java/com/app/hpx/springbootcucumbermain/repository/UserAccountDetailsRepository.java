package com.app.hpx.springbootcucumbermain.repository;

import com.app.hpx.springbootcucumberinterface.entity.UserAccountDetailsEntity;

public interface UserAccountDetailsRepository {
		UserAccountDetailsEntity createUserAccountDetails(UserAccountDetailsEntity userAccountDetailsEntity);
		
		UserAccountDetailsEntity updateAccountDetails(String userKey, UserAccountDetailsEntity userAccountDetailsEntity);
		
		UserAccountDetailsEntity displayUserAccountDetails(String userKey);
		
		UserAccountDetailsEntity removeUserAccountDetails(String userKey);
}
