package com.celcom.wallet.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Transaction {
	//
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long transactionId ;
	
	private String transactionType;
	
	private Long amount;
	
	private long walletid;
	

/*	public long getWalletid() {
		return walletid;
	}

	public void setWalletid(long walletid) {
		this.walletid = walletid;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}
	
//1.we defines transaction table here	
	
*/	
	
	

}
