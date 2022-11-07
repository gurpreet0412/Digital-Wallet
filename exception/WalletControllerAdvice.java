package com.celcom.wallet.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
// we make this for  handling exception : step 1
//step 2 : har ek exception ka alg se class bnao
@ControllerAdvice
public class WalletControllerAdvice extends ResponseEntityExceptionHandler {

	  @ExceptionHandler(WalletNotValidException.class)
	    public ResponseEntity<Object> handleWalletNotValidException(
	    		WalletNotValidException ex, WebRequest request) {

	        Map<String, Object> body = new LinkedHashMap<>();
	        body.put("error", ex.getMessage());
	        body.put("message", "Wallet not found");

	        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	    }
	  
	  @ExceptionHandler(OperationNotAllowed.class)
	    public ResponseEntity<Object> handleOperationNotAllowedException(
	    		OperationNotAllowed ex, WebRequest request) {

	        Map<String, Object> body = new LinkedHashMap<>();
	        body.put("error", ex.getMessage());
	        body.put("message", "Operation not allowed");

	        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	    }
	  
	  @ExceptionHandler(InsufficientFundException.class)
	    public ResponseEntity<Object> handleInsufficientFundException(
	    		InsufficientFundException ex, WebRequest request) {

	        Map<String, Object> body = new LinkedHashMap<>();
	        body.put("error", ex.getMessage());
	        body.put("message", "Insufficient fund in amount");

	        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	    }

}
