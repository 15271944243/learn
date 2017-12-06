package com.jpa.controller;


import com.jpa.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accountJpa")
@EnableAutoConfiguration
public class AccountJPAController {

    @Autowired
    AccountDao accountDao;

    @RequestMapping(value="/list" ,method= RequestMethod.GET)
    public List getAccounts(){
        return accountDao.findAll();
    }
}
