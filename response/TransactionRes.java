package com.celcom.wallet.response;

public class TransactionRes {
	private long transactionid;
	private String status;
	private long amount;
	private long walletid;
	private String transactionType;
	private long balance;
	public long getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(long transactionid) {
		this.transactionid = transactionid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public long getWalletid() {
		return walletid;
	}
	public void setWalletid(long walletid) {
		this.walletid = walletid;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	
//4.JSON response m kya kya chahiye wo likha h.	

}
