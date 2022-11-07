package com.celcom.wallet.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.celcom.wallet.entity.Transaction;
import com.celcom.wallet.entity.Wallet;

@Repository
public interface WalletRepo extends JpaRepository<Wallet, Long> {
	

}
