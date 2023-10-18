package com.taoge.restcrudtransaction.service;

import com.taoge.restcrudtransaction.entity.Transaction;

import java.util.List;

public interface TransactionService
{
	List<Transaction> findAll();

	Transaction findById(int id);

	Transaction save(Transaction transaction);

	Transaction deleteById(int id);
}
