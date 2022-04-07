package com.app.hpx.cucumber.entity;

import java.time.LocalDateTime;

public class UserAccountDetailsEntity {
		
		/* for internal usage only - should not be sent to client */
		private int uuid;
		
		/* for look-up usage - should be sent to client */
		private String userKey;
		private String userName;
		private String firstName;
		private String lastName;
		
		private boolean userEnabled;
		
		private LocalDateTime createTimeStamp;
		private LocalDateTime updateTimeStamp;
		
		public UserAccountDetailsEntity() {
		}
		
		public UserAccountDetailsEntity(int uuid, String userKey, String userName, String firstName, String lastName, boolean userEnabled, LocalDateTime createTimeStamp, LocalDateTime updateTimeStamp) {
				this.uuid = uuid;
				this.userKey = userKey;
				this.userName = userName;
				this.firstName = firstName;
				this.lastName = lastName;
				this.userEnabled = userEnabled;
				this.createTimeStamp = createTimeStamp;
				this.updateTimeStamp = updateTimeStamp;
		}
		
		public int getUuid() {
				return uuid;
		}
		
		public void setUuid(int uuid) {
				this.uuid = uuid;
		}
		
		public String getUserKey() {
				return userKey;
		}
		
		public void setUserKey(String userKey) {
				this.userKey = userKey;
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
		
		public boolean isUserEnabled() {
				return userEnabled;
		}
		
		public void setUserEnabled(boolean userEnabled) {
				this.userEnabled = userEnabled;
		}
		
		public LocalDateTime getCreateTimeStamp() {
				return createTimeStamp;
		}
		
		public void setCreateTimeStamp(LocalDateTime createTimeStamp) {
				this.createTimeStamp = createTimeStamp;
		}
		
		public LocalDateTime getUpdateTimeStamp() {
				return updateTimeStamp;
		}
		
		public void setUpdateTimeStamp(LocalDateTime updateTimeStamp) {
				this.updateTimeStamp = updateTimeStamp;
		}
		
		@Override
		public String toString() {
				return "UserAccountDetailsEntity{" +
						"uuid=" + uuid +
						", userKey='" + userKey + '\'' +
						", userName='" + userName + '\'' +
						", firstName='" + firstName + '\'' +
						", lastName='" + lastName + '\'' +
						", userEnabled=" + userEnabled +
						", createTimeStamp=" + createTimeStamp +
						", updateTimeStamp=" + updateTimeStamp +
						'}';
		}
}
