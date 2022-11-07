package com.celcom.wallet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.celcom.wallet.entity.Transaction;
import com.celcom.wallet.entity.Wallet;
import com.celcom.wallet.request.CreateWalletReq;
import com.celcom.wallet.response.CreateWalletResponse;
import com.celcom.wallet.service.WalletService;

@RestController
@RequestMapping("wallet")

public class WalletController {
	@GetMapping(path="/",produces = "application/json")
	public List<Wallet> index() {
		// test kr ra
		return service.getWallets();
	}
	
	@Autowired WalletService service;//autowired mtlb controller se pehle  service ka obj bnega
	//wallet create kr re i.e post mapping kr re
	@PostMapping(path= "/", consumes = "application/json", produces = "application/json")
	public CreateWalletResponse createWallet(@RequestBody CreateWalletReq walletReq) {
		CreateWalletResponse walletRes= service.createWallet(walletReq);
		return walletRes;
		
	}
	//for changing status of lock i.e updating i.e.y PUTMapping
	@PutMapping(path="/{walletid}/status")
	public Wallet changeStatus(@PathVariable("walletid") Long id) {
		//@PathVariable is use to fetch value from URL
		return service.changeStatus(id);
		
	}
	//for fetching data of particular wallet id
	@GetMapping(path = "/{walletId}")//"/transaction" ke baad "/" lgao
	public Wallet getDataForWalletId(@PathVariable("walletId") long walletid) {
		 return service.getDataForWallet(walletid);
			
	}

}
