package com.app.hpx.springbootcucumbermain.repository;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.app.hpx.springbootcucumberinterface.entity.UserAccountDetailsEntity;
import com.app.hpx.springbootcucumbermain.service.UserAccountDetailsServiceImpl;

@Repository
public class UserAccountDetailsRepositoryImpl implements UserAccountDetailsRepository {

		private static final Logger LOG = LoggerFactory.getLogger(UserAccountDetailsServiceImpl.class);

		private final Map<Integer, UserAccountDetailsEntity> userAccountDetailsEntityMap = new HashMap<>();

		@Override
		public UserAccountDetailsEntity createUserAccountDetails(UserAccountDetailsEntity userAccountDetailsEntity) {
				
				LOG.info("Repository: received {}", userAccountDetailsEntity);
				
				userAccountDetailsEntityMap.put(userAccountDetailsEntity.getUuid(), userAccountDetailsEntity);
				return userAccountDetailsEntity;
		}
}
