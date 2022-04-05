package com.app.hpx.springbootcucumberinterface.request;

public class UserAccountDetailsRequest {

		private String userName;
		private String firstName;
		private String lastName;

		public UserAccountDetailsRequest() {
		}
		
		public UserAccountDetailsRequest(String userName, String firstName, String lastName) {
				this.userName = userName;
				this.firstName = firstName;
				this.lastName = lastName;
		}
		
		public String getUserName() {
				return userName;
		}

		public void setUserName(String userName) {
				this.userName = userName;
		}

		public String getFirstName() {
				return firstName;
		}

		public void setFirstName(String firstName) {
				this.firstName = firstName;
		}

		public String getLastName() {
				return lastName;
		}

		public void setLastName(String lastName) {
				this.lastName = lastName;
		}

		@Override
		public String toString() {
				return "UserAccountDetailsRequest{" +
						", userName='" + userName + '\'' +
						", firstName='" + firstName + '\'' +
						", lastName='" + lastName + '\'' +
						'}';
		}
}
