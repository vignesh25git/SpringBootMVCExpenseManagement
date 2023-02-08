package com.vicky.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vicky.entity.Expense;
import com.vicky.repo.ExpenseRepository;

@Service
public class ExpenseService {
	
	@Autowired
	private ExpenseRepository expenseRepository;

	public List<Expense> listExpense() {
		
		return expenseRepository.findAll();
	}

	public Expense saveExpense(Expense expense) {
		// TODO Auto-generated method stub
		return expenseRepository.save(expense);

		
	}

	public Expense getExpenseById(Integer id) {
		// TODO Auto-generated method stub
		
		return expenseRepository.findById(id).get();
	}

	public void deleteExpenseById(Integer id) {
		// TODO Auto-generated method stub
		
		expenseRepository.deleteById(id);
		
	}

	
	
	

}
