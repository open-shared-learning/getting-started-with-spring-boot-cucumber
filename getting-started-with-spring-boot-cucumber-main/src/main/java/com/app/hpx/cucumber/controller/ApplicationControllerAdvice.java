package com.app.hpx.cucumber.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.hpx.cucumber.exceptions.BaseResponse;
import com.app.hpx.cucumber.exceptions.ErrorDetails;
import com.app.hpx.cucumber.exceptions.ApplicationException;

@ControllerAdvice
public class ApplicationControllerAdvice {
		
		@ExceptionHandler(ApplicationException.class)
		@ResponseBody
		public BaseResponse handleGenericExceptionsApplicationWide(ApplicationException exception, HttpServletResponse response) {
				ErrorDetails errorDetails = new ErrorDetails();
				errorDetails.setErrorCode(exception.getHttpStatusCode());
				errorDetails.setErrorType(exception.getExceptionType());
				errorDetails.setErrorMessage(exception.getExceptionMessage());
				
				return buildErrorResponse(response, errorDetails, exception.getHttpStatusCode());
		}
		
		private BaseResponse buildErrorResponse(HttpServletResponse response, ErrorDetails errorDetails, Integer httpStatusCode) {
				BaseResponse baseResponse = new BaseResponse(errorDetails);
				response.setStatus(httpStatusCode);
				
				return baseResponse;
		}
}
