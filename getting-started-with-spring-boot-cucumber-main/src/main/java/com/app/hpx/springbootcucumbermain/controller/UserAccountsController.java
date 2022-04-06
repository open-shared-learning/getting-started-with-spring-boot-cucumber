package com.app.hpx.springbootcucumbermain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.hpx.springbootcucumberinterface.request.UserAccountDetailsRequest;
import com.app.hpx.springbootcucumberinterface.response.UserAccountDetailsResponse;
import com.app.hpx.springbootcucumbermain.service.UserAccountDetailsService;

@RestController
@RequestMapping("/app/v1/user")
public class UserAccountsController {
		
		private final UserAccountDetailsService userAccountDetailsService;
		
		@Autowired
		public UserAccountsController(UserAccountDetailsService userAccountDetailsService) {
				this.userAccountDetailsService = userAccountDetailsService;
		}
		
		@PostMapping("/create")
		public UserAccountDetailsResponse createNewUserDetails(@RequestBody UserAccountDetailsRequest userAccountDetailsRequest) {
				return userAccountDetailsService.createUserAccountDetails(userAccountDetailsRequest);
		}
		
		
		@PutMapping("{userKey}/update")
		public UserAccountDetailsResponse updateUserDetails(@PathVariable String userKey, @RequestBody UserAccountDetailsRequest userAccountDetailsRequest) {
				return userAccountDetailsService.updateUserAccountDetails(userKey, userAccountDetailsRequest);
		}
}
