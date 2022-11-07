package com.celcom.wallet.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.celcom.wallet.entity.Transaction;
//humesha repository layer interface hogi              //table name //primary key ka data typ
public interface TransactionRepo extends JpaRepository<Transaction, Long> {
	// findBy() srf primary key ko find krta h, hume find by wallet id krna h isliye ek abstract method bnaye jisse smjh jayega ki find by wallet id krna h
	List<Transaction> findByWalletid(long walletid);
//hum @query bhi use kr skte the, abv sentence ka mtlb h " select * from trnction table where wallet id = "
}
//2.konse table se link krana hai and uske primary key ka data typ kya hai.
// "extends JPA repo" it is an interface, provides various methods to work in database like save(),findBy() etc.
