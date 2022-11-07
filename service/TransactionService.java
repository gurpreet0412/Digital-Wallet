package com.celcom.wallet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.celcom.wallet.entity.Transaction;
import com.celcom.wallet.entity.Wallet;
import com.celcom.wallet.exception.InsufficientFundException;
import com.celcom.wallet.exception.OperationNotAllowed;
import com.celcom.wallet.exception.WalletNotValidException;
import com.celcom.wallet.repo.TransactionRepo;
import com.celcom.wallet.repo.WalletRepo;
import com.celcom.wallet.request.TransactionReq;
import com.celcom.wallet.response.TransactionRes;

@Service
public class TransactionService {

	@Autowired
	TransactionRepo transactionRepo;

	@Autowired
	WalletService walletService;

	@Transactional // coz 2 table m apn update kra re toh hum chahte h ki wo as a transaction work
					// kre
	public TransactionRes creditOrDebit(TransactionReq req) {
		String type = req.getTransactionType();
		Long walletId = req.getWalletId();
		Long amount = req.getAmount();
		String status = req.getWalletStatus();
		// optional isliye qki agr wallet empty bhejoge toh apne aap wo handle kr lega
		Optional<Wallet> optionalWallet = walletService.getWallet(walletId);
		Wallet wallet = optionalWallet.orElseThrow(() -> new WalletNotValidException(walletId));
		if (wallet.getStatus().equals("LOCK"))
			throw new OperationNotAllowed(wallet.getWalletId());//agar lock h toh operation ni ho skta
		Transaction transaction = new Transaction();
		transaction.setTransactionType(type);
		transaction.setAmount(amount);
		transaction.setWalletid(walletId);

		if (type.equals("CREDIT")) {// humlog methods main file(wallet service) m hi likhnge aur usse apn call
									// krayenge
			wallet.credit(amount);

		} else if (type.equals("DEBIT")) {
			  if(transaction.getAmount()>wallet.getAmount())  
			  {
				  throw new InsufficientFundException(wallet.getWalletId());  
			  }
			wallet.debit(amount);

		}

		transactionRepo.save(transaction);
		Wallet updatedWallet = walletService.saveWallet(wallet);
		TransactionRes response = new TransactionRes();
		response.setAmount(amount);
		response.setBalance(updatedWallet.getAmount());
		response.setStatus("SUCCESS");
		response.setWalletid(updatedWallet.getWalletId());
		response.setTransactionType(type);

		return response;
	}

	// method for getting all trnction
	public List<Transaction> getAllTransactions() {

		return transactionRepo.findAll();
	}

	// method for getting trnction for particular wallet id
	public List<Transaction> getTransactionForWallet(Long walletId) {
		return transactionRepo.findByWalletid(walletId);
	}

}
