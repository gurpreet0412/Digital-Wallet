package com.celcom.wallet.request;

public class TransactionReq {
	private long walletId;
	private long amount;
	private String transactionType;
	private String walletStatus;
	public String getWalletStatus() {
		return walletStatus;
	}
	public void setWalletStatus(String walletStatus) {
		this.walletStatus = walletStatus;
	}
	public long getWalletId() {
		return walletId;
	}
	public void setWalletId(long walletId) {
		this.walletId = walletId;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
//3. request mein kya kya parameters chahiye usko define and unka setter getter bnae.	
//har ek layer mein agar parameters define krte hai apn toh uska setter getter bnante h  	
//coz variables private hai toh usse access krne k liye public method bnaye.
}
