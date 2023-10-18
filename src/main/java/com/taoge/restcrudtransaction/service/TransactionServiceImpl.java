package com.taoge.restcrudtransaction.service;

import com.taoge.restcrudtransaction.dao.TransactionDao;
import com.taoge.restcrudtransaction.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService
{
	private TransactionDao transactionDao;

	@Autowired
	public TransactionServiceImpl(TransactionDao transactionDao)
	{
		this.transactionDao = transactionDao;
	}

	@Override
	public List<Transaction> findAll()
	{
		return transactionDao.findAll();
	}

	@Override
	public Transaction findById(int id)
	{
		return transactionDao.findById(id);
	}

	@Override
	@Transactional
	public Transaction save(Transaction transaction)
	{
		return transactionDao.save(transaction);
	}

	@Override
	@Transactional
	public Transaction deleteById(int id)
	{
		return transactionDao.deleteById(id);
	}
}
