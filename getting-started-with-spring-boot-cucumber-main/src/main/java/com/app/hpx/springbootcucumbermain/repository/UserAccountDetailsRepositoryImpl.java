package com.app.hpx.springbootcucumbermain.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.app.hpx.springbootcucumberinterface.entity.UserAccountDetailsEntity;
import com.app.hpx.springbootcucumbermain.exceptions.ApplicationException;
import com.app.hpx.springbootcucumbermain.service.UserAccountDetailsServiceImpl;

@Repository
public class UserAccountDetailsRepositoryImpl implements UserAccountDetailsRepository {
		
		private static final Logger LOG = LoggerFactory.getLogger(UserAccountDetailsServiceImpl.class);
		
		private final Map<Integer, UserAccountDetailsEntity> userAccountDetailsEntityMap = new HashMap<>();
		
		@Override
		public UserAccountDetailsEntity createUserAccountDetails(UserAccountDetailsEntity userAccountDetailsEntity) {
				LOG.info("Repository -> Create User : {}", userAccountDetailsEntity);
				userAccountDetailsEntityMap.put(userAccountDetailsEntity.getUuid(), userAccountDetailsEntity);
				
				return userAccountDetailsEntity;
		}
		
		@Override
		public UserAccountDetailsEntity updateAccountDetails(String userKey, UserAccountDetailsEntity userAccountDetailsEntity) {
				LOG.info("Repository -> Update User : {}", userAccountDetailsEntity);
				
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
				return null;
		}
		
		@Override
		public UserAccountDetailsEntity removeUserAccountDetails(String userKey) {
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
