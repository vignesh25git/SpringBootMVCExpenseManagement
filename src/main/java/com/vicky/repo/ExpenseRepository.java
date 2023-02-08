package com.vicky.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vicky.entity.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

}
