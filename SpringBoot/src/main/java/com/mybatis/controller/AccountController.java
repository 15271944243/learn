package com.mybatis.controller;

import com.mybatis.model.Account;
import com.mybatis.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accountMybatis")
public class AccountController {
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
        return accountService.findAccount(id);
    }

    //更新
    @RequestMapping(value="/{id}" ,method=RequestMethod.PUT)
    public String updateAccount(@PathVariable("id") int id,@RequestParam(value="name" ,required=true)
            String name, @RequestParam(value="money" ,required=true)double money){
        int t=accountService.update(name, money, id);
        if(t==1){
            return "success";
        }else{
            return "fail";
        }
    }

    //删除
    @RequestMapping(value="/{id}" ,method=RequestMethod.DELETE)
    public String delete(@PathVariable("id") int id){
        int t=accountService.delete( id);
        if(t==1){
            return "success";
        }else{
            return "fail";
        }
    }

    //添加
    @RequestMapping(value="" ,method=RequestMethod.POST)
    public String addAccount(@RequestParam(value="name" ,required=true) String name, @RequestParam(value="money" ,required=true)double money){
        int t=accountService.add(name, money);
        if(t==1){
            return "success";
        }else{
            return "fail";
        }
    }
}
