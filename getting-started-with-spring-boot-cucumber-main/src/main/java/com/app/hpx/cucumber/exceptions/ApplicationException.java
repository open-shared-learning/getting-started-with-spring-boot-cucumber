package com.app.hpx.cucumber.exceptions;

public class ApplicationException extends RuntimeException {
		
		private final int httpStatusCode;
		private final String exceptionType;
		private final String exceptionMessage;
		
		public ApplicationException(int httpStatusCode, String exceptionType, String exceptionMessage) {
				this.httpStatusCode = httpStatusCode;
				this.exceptionType = exceptionType;
				this.exceptionMessage = exceptionMessage;
		}
		
		public int getHttpStatusCode() {
				return httpStatusCode;
		}
		
		public String getExceptionType() {
				return exceptionType;
		}
		
		public String getExceptionMessage() {
				return exceptionMessage;
		}
		
		@Override
		public String toString() {
				return "ApplicationException{" +
						"httpStatusCode=" + httpStatusCode +
						", exceptionType='" + exceptionType + '\'' +
						", exceptionMessage='" + exceptionMessage + '\'' +
						'}';
		}
}
