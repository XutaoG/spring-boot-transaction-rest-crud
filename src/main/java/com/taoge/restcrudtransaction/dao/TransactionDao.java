package com.taoge.restcrudtransaction.dao;

import com.taoge.restcrudtransaction.entity.Transaction;

import java.util.List;

public interface TransactionDao
{
	List<Transaction> findAll();

	Transaction findById(int id);

	Transaction save(Transaction transaction);

	Transaction deleteById(int id);
}
