package com.jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import com.jdbc.service.IAccountService;
import com.jdbc.model.Account;


import java.util.List;

@RestController
@RequestMapping("/accountJdbc")
@EnableAutoConfiguration
public class AccountJDBCController {

    @Autowired
    IAccountService accountService;

    @RequestMapping(value="/list" ,method= RequestMethod.GET)
    public List getAccounts(){
        return accountService.findAccountList();
    }

    @RequestMapping(value="/{id}" ,method=RequestMethod.GET)
    public Account getAccountById(@PathVariable("id") int id){
        return accountService.findAccountById(id);
    }

    @RequestMapping(value="/{id}" ,method=RequestMethod.PUT)
    public String updateAccount(@PathVariable("id") int id,@RequestParam(value="name" ,required=true)
            String name, @RequestParam(value="money" ,required=true)double money){
        Account account=new Account();
        account.setMoney(money);
        account.setName(name);
        account.setId(id);
        int t=accountService.update(account);
        if(t==1){
            return account.toString();
        }else{
            return "fail";
        }
    }

    @RequestMapping(value="" ,method=RequestMethod.POST)
    public String addAccount(@RequestParam(value="name")String name,@RequestParam(value="money")
            double money){
        Account account=new Account();
        account.setMoney(money);
        account.setName(name);
        int t=accountService.add(account);
        if(t==1){
            return account.toString();
        }else{
            return "fail";
        }
    }
}
