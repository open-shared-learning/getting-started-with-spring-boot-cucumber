package com.app.hpx.cucumber.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.app.hpx.cucumber.entity.UserAccountDetailsEntity;
import com.app.hpx.cucumber.exceptions.ApplicationException;
import com.app.hpx.cucumber.service.UserAccountDetailsServiceImpl;

@Repository
public class UserAccountDetailsRepositoryImpl implements UserAccountDetailsRepository {
		
		private static final Logger LOG = LoggerFactory.getLogger(UserAccountDetailsServiceImpl.class);
		
		private final Map<Integer, UserAccountDetailsEntity> userAccountDetailsEntityMap = new HashMap<>();
		
		@Override
		public UserAccountDetailsEntity createUserAccountDetails(UserAccountDetailsEntity userAccountDetailsEntity) {
				LOG.info("Repository -> Create User : {}-{}", userAccountDetailsEntity.getUserKey(), userAccountDetailsEntity);
				userAccountDetailsEntityMap.put(userAccountDetailsEntity.getUuid(), userAccountDetailsEntity);
				
				return userAccountDetailsEntity;
		}
		
		@Override
		public UserAccountDetailsEntity updateAccountDetails(String userKey, UserAccountDetailsEntity userAccountDetailsEntity) {
				LOG.info("Repository -> Update User : {}-{}", userKey, userAccountDetailsEntity);
				
				int userUuidFromUserKey = getUserUuidFromUserKey(userKey);
				
				if (userAccountDetailsEntityMap.containsKey(userUuidFromUserKey)) {
						userAccountDetailsEntityMap.put(userUuidFromUserKey, userAccountDetailsEntity);
				} else {
						throw new ApplicationException(
								HttpStatus.BAD_REQUEST.value(),
								HttpStatus.BAD_REQUEST.getReasonPhrase(),
								"Cannot update user : " + userKey + " or user does not exist!"
						);
				}
				return userAccountDetailsEntity;
		}
		
		@Override
		public UserAccountDetailsEntity displayUserAccountDetails(String userKey) {
				LOG.info("Repository -> Display User : {}", userKey);
				if (userAccountDetailsEntityMap.isEmpty()) {
						throw new ApplicationException(
								HttpStatus.BAD_REQUEST.value(),
								HttpStatus.BAD_REQUEST.getReasonPhrase(),
								"Cannot display user : " + userKey + " or user does not exist!"
						);
				} else {
						int uuid = getUserUuidFromUserKey(userKey);
						if (userAccountDetailsEntityMap.containsKey(uuid)) {
								return userAccountDetailsEntityMap.get(uuid);
						} else {
								throw new ApplicationException(
										HttpStatus.BAD_REQUEST.value(),
										HttpStatus.BAD_REQUEST.getReasonPhrase(),
										"Cannot display user : " + userKey + " or user does not exist!"
								);
						}
				}
		}
		
		@Override
		public UserAccountDetailsEntity removeUserAccountDetails(String userKey) {
				LOG.info("Repository -> Remove User : {}", userKey);
				if (userAccountDetailsEntityMap.isEmpty()) {
						throw new ApplicationException(
								HttpStatus.BAD_REQUEST.value(),
								HttpStatus.BAD_REQUEST.getReasonPhrase(),
								"Cannot remove user : " + userKey + " or user does not exist!"
						);
				} else {
						int uuid = getUserUuidFromUserKey(userKey);
						if (userAccountDetailsEntityMap.containsKey(uuid)) {
								/* soft-delete user data */
								UserAccountDetailsEntity entity = userAccountDetailsEntityMap.get(uuid);
								entity.setUserEnabled(false);
								
								userAccountDetailsEntityMap.put(uuid, entity);
								return entity;
						} else {
								throw new ApplicationException(
										HttpStatus.BAD_REQUEST.value(),
										HttpStatus.BAD_REQUEST.getReasonPhrase(),
										"Cannot remove user : " + userKey + " or user does not exist!"
								);
						}
				}
		}
		
		@Override
		public List<UserAccountDetailsEntity> displayAllUsersAccountDetails(boolean enabledOnly) {
				/* TODO: implement logic here */
				return null;
		}
		
		private int getUserUuidFromUserKey(String userKey) {
				if (!userAccountDetailsEntityMap.isEmpty()) {
						List<Map.Entry<Integer, UserAccountDetailsEntity>> entryList = userAccountDetailsEntityMap
								.entrySet()
								.stream()
								.filter(a -> a.getValue().getUserKey().equalsIgnoreCase(userKey))
								.collect(Collectors.toList());
						
						/* assuming that userKey is unique for all user */
						return entryList.get(0).getValue().getUuid();
				}
				
				LOG.error("Repository -> Find UUID : failed or does not exist");
				return 0;
		}
}
