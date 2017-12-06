package com.mybatis.controller;

import com.mybatis.model.Account;
import com.mybatis.service.AccountServiceTwo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accountMybatisTwo")
@MapperScan("com.mybatis.repository")
public class AccountControllerTwo {
    @Autowired
    private AccountServiceTwo accountServiceTwo;

    //查询所有
    @RequestMapping(value="/list",method= RequestMethod.GET)
    public List<Account> getAccounts(){
        return accountServiceTwo.findAccountList();
    }
}
