package com.jdbc.service.impl;

import com.jdbc.dao.IAccountDao;
import com.jdbc.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jdbc.service.IAccountService;

import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    IAccountDao accountDao;

    @Override
    public int add(Account account) {
        return accountDao.add(account);
    }

    @Override
    public int update(Account account) {
        return accountDao.update(account) ;
    }

    @Override
    public int delete(int id) {
        return accountDao.delete(id);
    }

    @Override
    public Account findAccountById(int id) {
        return accountDao.findAccountById(id);
    }

    @Override
    public List findAccountList() {
        return accountDao.findAccountList();
    }
}
