package com.celcom.wallet.exception;

public class InsufficientFundException extends RuntimeException {
		public InsufficientFundException(long walletid) {
	          super("Wallet id --> "+walletid+" has not sufficient fund");
	    }
	
}
