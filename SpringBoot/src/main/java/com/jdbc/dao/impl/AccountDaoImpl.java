package com.jdbc.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.jdbc.dao.IAccountDao;
import com.jdbc.model.Account;

import java.util.List;

@Repository
public class AccountDaoImpl implements IAccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(Account account) {
        return jdbcTemplate.update("insert into test_account(name ,money) values(?,?)",account.getName(),account.getMoney());
    }

    @Override
    public int update(Account account) {
        return jdbcTemplate.update("UPDATE test_account SET NAME=?,MONEY=? where id=?",
                account.getName(),account.getMoney(),account.getId());
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("DELETE from TABLE test_account where id=?",id);
    }

    @Override
    public Account findAccountById(int id) {
        List list =jdbcTemplate.query("select * from test_account where id=?", new Object[]{id},
                new BeanPropertyRowMapper(Account.class));
        if(list!=null && list.size()>0){
            Account account=(Account)list.get(0);
            return account;
        }else{
            return null;
        }
    }

    @Override
    public List findAccountList() {
        List list =jdbcTemplate.query("select * from test_account ", new Object[]{},
                new BeanPropertyRowMapper(Account.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }
}
