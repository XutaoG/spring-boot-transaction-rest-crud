package com.taoge.restcrudtransaction.dao;

import com.taoge.restcrudtransaction.entity.Transaction;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionDaoImpl implements TransactionDao
{
	private EntityManager entityManager;

	@Autowired
	public TransactionDaoImpl(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}

	@Override
	public List<Transaction> findAll()
	{
		return entityManager.createQuery("FROM Transaction", Transaction.class).getResultList();
	}

	@Override
	public Transaction findById(int id)
	{
		return entityManager.find(Transaction.class, id);
	}

	@Override
	public Transaction save(Transaction transaction)
	{
		return entityManager.merge(transaction);
	}

	@Override
	public Transaction deleteById(int id)
	{
		Transaction transaction = entityManager.find(Transaction.class, id);
		entityManager.remove(transaction);
		return transaction;
	}
}
