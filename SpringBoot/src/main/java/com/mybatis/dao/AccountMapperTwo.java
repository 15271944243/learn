package com.mybatis.dao;

import com.mybatis.model.Account;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountMapperTwo {

    List<Account> findAccountList();
}
