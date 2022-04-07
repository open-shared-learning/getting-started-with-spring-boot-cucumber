package com.app.hpx.cucumber.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.hpx.cucumber.request.UserAccountDetailsRequest;
import com.app.hpx.cucumber.response.UserAccountDetailsResponse;
import com.app.hpx.cucumber.service.UserAccountDetailsService;

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
		
		@GetMapping
		public UserAccountDetailsResponse displayUserDetails(@RequestParam String userKey){
				return userAccountDetailsService.displayUserAccountDetails(userKey);
		}
		
		@DeleteMapping
		public UserAccountDetailsResponse removeUserAccountDetails(@RequestParam String userKey){
				return userAccountDetailsService.removeUserAccountDetails(userKey);
		}
		
		@GetMapping("/all")
		public List<UserAccountDetailsResponse> displayAllUserDetails(@RequestParam(required = false) boolean enabledOnly){
				return userAccountDetailsService.displayAllUsersAccountDetails(enabledOnly);
		}
}
