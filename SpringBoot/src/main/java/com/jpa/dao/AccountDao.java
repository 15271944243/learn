package com.jpa.dao;

import com.jpa.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountDao extends JpaRepository<Account,Integer> {
}
