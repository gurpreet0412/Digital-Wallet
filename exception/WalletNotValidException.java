package com.celcom.wallet.exception;
// we do "extends RuntimeException" for every exception
//har ek exception ki alg clss bnana hoti h
public class WalletNotValidException extends RuntimeException {
	public WalletNotValidException(long walletid) {

        super("Wallet id --> "+walletid+" not valid");
    }
}
