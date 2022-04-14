package com.app.hpx.cucumber.exceptions;

import java.util.Objects;

public class BaseResponse {
		
		private ErrorDetails errorDetails;
		
		public BaseResponse(ErrorDetails errorDetails) {
				this.errorDetails = errorDetails;
		}
		
		public ErrorDetails getErrorDetails() {
				return errorDetails;
		}
		
		public void setErrorDetails(ErrorDetails errorDetails) {
				this.errorDetails = errorDetails;
		}
		
		boolean hasError() {
				return Objects.nonNull(errorDetails);
		}
}
