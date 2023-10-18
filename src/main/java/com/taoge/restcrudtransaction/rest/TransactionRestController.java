package com.taoge.restcrudtransaction.rest;

import com.taoge.restcrudtransaction.entity.Transaction;
import com.taoge.restcrudtransaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TransactionRestController
{
	private TransactionService transactionService;

	@Autowired
	public TransactionRestController(TransactionService transactionService)
	{
		this.transactionService = transactionService;
	}

	// Endpoint to get all transactions
	@GetMapping("/transactions")
	public List<Transaction> getAllTransactions()
	{
		return transactionService.findAll();
	}

	// Endpoint to get 1 transaction by ID
	@GetMapping("/transactions/{id}")
	public Transaction getTransaction(@PathVariable int id)
	{
		Transaction transaction = transactionService.findById(id);

		if (transaction == null)
		{
			throw new TransactionNotFoundException(String.format("Transaction ID (%d) not found", id));
		}

		return transaction;
	}

	// Endpoint to add a new transaction
	@PostMapping("/transactions")
	public Transaction addTransaction(@RequestBody Transaction transaction)
	{
		transaction.setId(0);

		// If any part of transaction detail is invalid
		if (transaction.getFirstName() == null || transaction.getLastName() == null ||
				transaction.getTitle() == null || transaction.getAmount() <= 0)
		{
			throw new InvalidTransactionException("Invalid transaction format");
		}
		return transactionService.save(transaction);
	}

	// Endpoint to update a transaction
	@PutMapping("/transactions")
	public Transaction updateTransaction(@RequestBody Transaction transaction)
	{
		// If requested ID does not match any in the database
		if (transactionService.findById(transaction.getId()) == null)
		{
			throw new TransactionNotFoundException(String.format("Transaction ID (%d) not found", transaction.getId()));
		}

		// If any part of transaction detail is invalid
		if (transaction.getFirstName() == null || transaction.getLastName() == null ||
				transaction.getTitle() == null || transaction.getAmount() <= 0)
		{
			throw new InvalidTransactionException("Invalid transaction format");
		}
		return transactionService.save(transaction);
	}

	// Endpoint for deleting a transaction by ID
	@DeleteMapping("/transactions/{id}")
	public Transaction deleteTransaction(@PathVariable int id)
	{
		Transaction transaction = transactionService.deleteById(id);

		if (transaction == null)
		{
			throw new TransactionNotFoundException(String.format("Transaction ID (%d) not found", id));
		}

		return transaction;
	}
}
