package com.app.hpx.springbootcucumbermain.exceptions;

public class ErrorDetails {
		
		private int errorCode;
		
		private String errorType;
		private String errorMessage;
		
		public ErrorDetails() {
		}
		
		public ErrorDetails(int errorCode, String errorType, String errorMessage) {
				this.errorCode = errorCode;
				this.errorType = errorType;
				this.errorMessage = errorMessage;
		}
		
		public int getErrorCode() {
				return errorCode;
		}
		
		public void setErrorCode(int errorCode) {
				this.errorCode = errorCode;
		}
		
		public String getErrorType() {
				return errorType;
		}
		
		public void setErrorType(String errorType) {
				this.errorType = errorType;
		}
		
		public String getErrorMessage() {
				return errorMessage;
		}
		
		public void setErrorMessage(String errorMessage) {
				this.errorMessage = errorMessage;
		}
		
		@Override
		public String toString() {
				return "ErrorDetails{" +
						"errorCode=" + errorCode +
						", errorType='" + errorType + '\'' +
						", errorMessage='" + errorMessage + '\'' +
						'}';
		}
}
