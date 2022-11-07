package com.celcom.wallet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.celcom.wallet.entity.Transaction;
import com.celcom.wallet.entity.Wallet;
import com.celcom.wallet.exception.WalletNotValidException;
import com.celcom.wallet.repo.WalletRepo;
import com.celcom.wallet.request.CreateWalletReq;
import com.celcom.wallet.response.CreateWalletResponse;

@Service
public class WalletService {
	
	@Autowired WalletRepo walletRepo;
	
	public CreateWalletResponse createWallet(CreateWalletReq walletReq) {
		Wallet wallet = new Wallet();
		wallet.setAmount(0l);
		wallet.setCustid(Long.parseLong(walletReq.getCustomerid()));
		wallet.setInitiateBy(walletReq.getInitiateBy());
		wallet.setStatus("ACTIVE");
		Wallet walletRes =walletRepo.save(wallet);
	
		
		CreateWalletResponse walletResponse = new CreateWalletResponse(String.valueOf(walletRes.getCustid()), walletRes.getInitiateBy(), walletRes.getCreateDate(), String.valueOf(walletRes.getWalletId()));
		
		return walletResponse;
		
	}
	
	public List<Wallet> getWallets() {
		return walletRepo.findAll();
	}
	
	public Optional<Wallet> getWallet(Long walletId) {
		return walletRepo.findById(walletId);
	}
	
	public Wallet saveWallet(Wallet wallet) {
	return	walletRepo.save(wallet);
	}
	
	public Wallet changeStatus(Long walletid) {
		Optional<Wallet> Optionalwallet =walletRepo.findById(walletid);
		Wallet wallet = Optionalwallet.orElseThrow(() -> new WalletNotValidException(walletid));
		if(wallet != null) {
			if(wallet.getStatus().equals("ACTIVE"))
				wallet.setStatus("LOCK");
			else if (wallet.getStatus().equals("LOCK"))
				wallet.setStatus("ACTIVE");
			walletRepo.save(wallet);
		}
		return wallet;
	}
	// method for getting data for particular wallet id
		public Wallet getDataForWallet(Long walletId) {
		 Optional<Wallet> Optionalwallet =walletRepo.findById(walletId);
		 Wallet wallet = Optionalwallet.orElseThrow(() -> new WalletNotValidException(walletId));
		 return wallet;
		}
		
}
