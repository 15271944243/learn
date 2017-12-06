package com.mongo.controller;

import com.mongo.model.Account;
import com.mongo.repository.AccountRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accountMybatis")
@Api("customer相关的API,用于测试mongodb")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @ApiOperation("增加一个Account")
    @RequestMapping(value="/addAccount" ,method=RequestMethod.GET)
    public Account addCustomer(@RequestParam("name") String name,@RequestParam("money") Double money) {
        Account account = new Account();
        account.setName(name);
        account.setMoney(money);
        return accountRepository.save(account);
    }

    @ApiOperation("获取所有的Account")
    @RequestMapping(value="/getAllAccount" ,method=RequestMethod.GET)
    public List<Account> getAllAccount(){
        return  accountRepository.findAll();
    }

    @ApiOperation("根据name查询Account")
    @RequestMapping(value="/getAccountByName" ,method=RequestMethod.GET)
    public List<Account> getAccountByName(@RequestParam("name") String name){
        List<Account> accountList = accountRepository.findByName(name);
        return accountList;
    }

    @ApiOperation("根据name和money查询Account")
    @RequestMapping(value="/getAccountByNameAndMoney" ,method=RequestMethod.GET)
    public List<Account> getAccountByNameAndMoney(@RequestParam("name") String name,@RequestParam("money") Double money){
        // return accountRepository.findBySecondName(secondName);
        return null;
    }

    @ApiOperation("根据id删除Account")
    @RequestMapping(value="/deleteAccountById" ,method=RequestMethod.GET)
    public boolean deleteCustomerById(@RequestParam("cid") String cid){
        accountRepository.delete(cid);
        return true;
    }

    @ApiOperation("根据id更新Account")
    @RequestMapping(value="/{cid}" ,method=RequestMethod.PUT)
    public Account updateCustomer(@PathVariable("cid") String  cid,@RequestParam("name") String name,@RequestParam("money") Double money){
        Account account = new Account();
        account.setCid(cid);
        account.setName(name);
        account.setMoney(money);
        return accountRepository.save(account);
    }
}
