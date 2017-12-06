package com.mybatis.service;

import com.mybatis.dao.AccountMapper;
import com.mybatis.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountMapper accountMapper;

    //添加
    public int add(String name,double money ){
        return accountMapper.add(name, money);
    }
    //更新
    public int update(String name,double money,int id ){
        return accountMapper.update(name, money,id);
    }
    //删除
    public int delete(int id ){
        return accountMapper.delete(id);
    }
    //根据id查找
    public Account findAccount(int id){
        return accountMapper.findAccount(id);
    }
    //查询所有
    public List<Account> findAccountList(){
        return accountMapper.findAccountList();
    }
}
