package com.celcom.wallet.exception;

public class OperationNotAllowed extends RuntimeException {
	public OperationNotAllowed(long walletid) {

        super("Wallet id --> "+walletid+" is locked");
    }
}
