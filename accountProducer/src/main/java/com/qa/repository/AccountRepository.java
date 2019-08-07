package com.qa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

	public Account findByfirstName(String firstName);
	
}
