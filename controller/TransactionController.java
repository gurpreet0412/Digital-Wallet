package com.celcom.wallet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.celcom.wallet.entity.Transaction;
import com.celcom.wallet.request.TransactionReq;
import com.celcom.wallet.response.TransactionRes;
import com.celcom.wallet.service.TransactionService;

@RestController
@RequestMapping("transaction")//mtlb "http://localhost:9090" ke baad aayega"/trancation"
public class TransactionController {
	//controller ko service se auto wired krte h humesha
	@Autowired TransactionService service;
	//post qki transaction konsa h pta krna h i.e credit ya debit
	@PostMapping(path = "/")//"/transaction" ke baad "/" lgao
	public TransactionRes performTransaction(@RequestBody TransactionReq transactionReq) {
		 return service.creditOrDebit(transactionReq);
			
	}
	// for getting all transaction details
	@GetMapping(path = "/")//"/transaction" ke baad "/" lgao
	public List<Transaction> getTransactions() {
		 return service.getAllTransactions();
			
	}
	//for getting trnction for particular walletid
	@GetMapping(path = "/{walletId}")//"/transaction" ke baad "/" lgao
	public List<Transaction> getTransactionForWalletId(@PathVariable("walletId") long walletid) {
		 return service.getTransactionForWallet(walletid);
			
	}
	

}
