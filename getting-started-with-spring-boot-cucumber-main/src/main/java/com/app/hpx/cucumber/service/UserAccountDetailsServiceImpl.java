package com.app.hpx.cucumber.service;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hpx.cucumber.entity.UserAccountDetailsEntity;
import com.app.hpx.cucumber.request.UserAccountDetailsRequest;
import com.app.hpx.cucumber.response.UserAccountDetailsResponse;
import com.app.hpx.cucumber.repository.UserAccountDetailsRepository;
import com.app.hpx.cucumber.util.RandomIntegerBasedUuidGenerator;
import com.app.hpx.cucumber.util.RandomPlainTextKeyGenerator;

@Service
public class UserAccountDetailsServiceImpl implements UserAccountDetailsService {
		
		private static final Logger LOG = LoggerFactory.getLogger(UserAccountDetailsServiceImpl.class);
		
		private static final int USER_KEY_LENGTH = 32;
		
		private final UserAccountDetailsRepository userAccountDetailsRepository;
		
		@Autowired
		public UserAccountDetailsServiceImpl(UserAccountDetailsRepository userAccountDetailsRepository) {
				this.userAccountDetailsRepository = userAccountDetailsRepository;
		}
		
		@Override
		public UserAccountDetailsResponse createUserAccountDetails(UserAccountDetailsRequest userAccountDetailsRequest) {
				UserAccountDetailsEntity userAccountDetailsEntity = new UserAccountDetailsEntity();
				UserAccountDetailsResponse userAccountDetailsResponse = new UserAccountDetailsResponse();
				
				/* Prepare Entity and call repository */
				int uuid = RandomIntegerBasedUuidGenerator.generateRandomIntegerUuidDefault();
				String userKey = RandomPlainTextKeyGenerator.getString(USER_KEY_LENGTH);
				
				userAccountDetailsEntity.setUuid(uuid);
				userAccountDetailsEntity.setUserKey(userKey);
				userAccountDetailsEntity.setUserEnabled(true);
				userAccountDetailsEntity.setCreateTimeStamp(LocalDateTime.now());
				userAccountDetailsEntity.setUpdateTimeStamp(LocalDateTime.now());
				
				LOG.info("Service -> Create User : {}", userAccountDetailsEntity);
				
				BeanUtils.copyProperties(userAccountDetailsRequest, userAccountDetailsEntity);
				UserAccountDetailsEntity responseEntity = userAccountDetailsRepository.createUserAccountDetails(userAccountDetailsEntity);
				
				BeanUtils.copyProperties(responseEntity, userAccountDetailsResponse);
				return userAccountDetailsResponse;
		}
		
		@Override
		public UserAccountDetailsResponse updateUserAccountDetails(String userKey, UserAccountDetailsRequest userAccountDetailsRequest) {
				UserAccountDetailsEntity userAccountDetailsEntity = new UserAccountDetailsEntity();
				UserAccountDetailsResponse userAccountDetailsResponse = new UserAccountDetailsResponse();
				
				/* Prepare Entity and call repository */
				userAccountDetailsEntity.setUpdateTimeStamp(LocalDateTime.now());
				LOG.info("Service -> Update User : {}", userAccountDetailsEntity);
				
				BeanUtils.copyProperties(userAccountDetailsRequest, userAccountDetailsEntity);
				/* FIXME: using this methodology existing data is replaced */
				UserAccountDetailsEntity responseEntity = userAccountDetailsRepository.updateAccountDetails(userKey, userAccountDetailsEntity);
				
				BeanUtils.copyProperties(responseEntity, userAccountDetailsResponse);
				return userAccountDetailsResponse;
		}
		
		@Override
		public UserAccountDetailsResponse displayUserAccountDetails(String userKey) {
				UserAccountDetailsResponse userAccountDetailsResponse = new UserAccountDetailsResponse();
				UserAccountDetailsEntity responseEntity = userAccountDetailsRepository.displayUserAccountDetails(userKey);
				
				BeanUtils.copyProperties(responseEntity, userAccountDetailsResponse);
				return userAccountDetailsResponse;
		}
		
		@Override
		public UserAccountDetailsResponse removeUserAccountDetails(String userKey) {
				UserAccountDetailsResponse userAccountDetailsResponse = new UserAccountDetailsResponse();
				UserAccountDetailsEntity responseEntity = userAccountDetailsRepository.removeUserAccountDetails(userKey);
				
				BeanUtils.copyProperties(responseEntity, userAccountDetailsResponse);
				return userAccountDetailsResponse;
		}
		
		@Override
		public List<UserAccountDetailsResponse> displayAllUsersAccountDetails(boolean enabledOnly) {
				userAccountDetailsRepository.displayAllUsersAccountDetails(enabledOnly);
				return null;
		}
}
