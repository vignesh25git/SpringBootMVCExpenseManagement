package com.vicky.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vicky.entity.Expense;
import com.vicky.service.ExpenseService;

@Controller
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseService;
	
	@RequestMapping("/list")
	public String listExpense(Model model) {
		
		List<Expense> expenseList = expenseService.listExpense();
		model.addAttribute("expenses", expenseList);
		
		return "expense";
		
	}
	
	@RequestMapping("/add")
	public String addExpense(Model model) {
		
		Expense expense = new Expense();
		model.addAttribute("expense", expense);

		return "create";
		
	}
	
	@PostMapping("/saveexpense")
	public String saveExpense(@ModelAttribute("expense") Expense expense) {
		
		expenseService.saveExpense(expense);
		
	return "redirect:/list";

	}
	
	@GetMapping("/getForUpdate/{id}")
	public String getForUpdateExpense(@PathVariable Integer id, Model model) {
		
		// get student from database by id
		
		Expense expense = expenseService.getExpenseById(id);
		model.addAttribute("expense", expense);
		
//		existingExpense.setId(id);
//		existingExpense.setDate(expense.getDate());
//		existingExpense.setTranType(expense.getTranType());
//		existingExpense.setCategory(expense.getCategory());
//		existingExpense.setSubCategory(expense.getSubCategory());
//		existingExpense.setAmount(expense.getAmount());
//		
//		// save updated student object
//		expenseService.saveExpense(existingExpense);
		return "update";		
	}
	
	@PostMapping("/saveexpense/{id}")
	public String updateExpense(@PathVariable Integer id,@ModelAttribute("expense") Expense expense,
			Model model ) {
		
		Expense existingExpense = expenseService.getExpenseById(id);
		
		existingExpense.setId(id);
		existingExpense.setDate(expense.getDate());
		existingExpense.setTranType(expense.getTranType());
		existingExpense.setCategory(expense.getCategory());
		existingExpense.setSubCategory(expense.getSubCategory());
		existingExpense.setAmount(expense.getAmount());
		
		// save updated student object
		expenseService.saveExpense(existingExpense);

		return "redirect:/list";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable Integer id) {
		expenseService.deleteExpenseById(id);
		return "redirect:/list";
	}
	
	@RequestMapping("/admin")
	public String showAdmin() {
		
		return "admin";
		
	}
	
}
