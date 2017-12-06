package com.mybatis.service;

import com.mybatis.dao.AccountMapperTwo;
import com.mybatis.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceTwo {

    @Autowired
    private AccountMapperTwo accountMapperTwo;

    public List<Account> findAccountList(){
        return accountMapperTwo.findAccountList();
    }
}
