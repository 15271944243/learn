package com.redis.controller;

import com.redis.model.Account;
import com.redis.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/redisTest")
public class RedisTestController {
    @Autowired
    private AccountService accountService;

    //查询所有
    @RequestMapping(value="/list",method=RequestMethod.GET)
    public List<Account> getAccounts(){
        return accountService.findAccountList();
    }

    //通过ID 查询
    @RequestMapping(value="/{id}",method= RequestMethod.GET)
    public Account getAccountById(@PathVariable("id") int id){
        // return accountService.findAccount(id);
        return null;
    }

    //更新
    @RequestMapping(value="/{id}" ,method=RequestMethod.PUT)
    public String updateAccount(@PathVariable("id") int id,@RequestParam(value="name" ,required=true)
            String name, @RequestParam(value="money" ,required=true)double money){
        // int t=accountService.update(name, money, id);
        int t = 1;
        if(t==1){
            return "success";
        }else{
            return "fail";
        }
    }

    //删除
    @RequestMapping(value="/{id}" ,method=RequestMethod.DELETE)
    public String delete(@PathVariable("id") int id){
        // int t=accountService.delete( id);
        int t = 1;
        if(t==1){
            return "success";
        }else{
            return "fail";
        }
    }

    //添加
    @RequestMapping(value="" ,method=RequestMethod.POST)
    public String addAccount(@RequestParam(value="name" ,required=true) String name, @RequestParam(value="money" ,required=true)double money){
        // int t=accountService.add(name, money);
        int t = 1;
        if(t==1){
            return "success";
        }else{
            return "fail";
        }
    }
}
