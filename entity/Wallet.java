package com.celcom.wallet.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
public class Wallet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long walletId ;
	
	

	public Long getWalletId() {
		return walletId;
	}

	private Long custid;
	
	private String initiateBy;
	
	@CreatedDate
	private Date createDate;
	
	@LastModifiedDate
	private Date updateDate;
	
	private String status;
	
	private Long amount ;

	public Long getCustid() {
		return custid;
	}

	public void setCustid(Long custid) {
		this.custid = custid;
	}

	public String getInitiateBy() {
		return initiateBy;
	}

	public void setInitiateBy(String initiateBy) {
		this.initiateBy = initiateBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}
	
	public void credit(Long amount) {
		this.amount+=amount;
	}
	
	public void debit (Long amount) {
		this.amount-=amount;
	}
	
	
	
	
	
}
