package com.redis.service;

import com.redis.dao.AccountMapper;
import com.redis.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class AccountService {

    @Autowired
    private RedisTemplate redisTemplate;


  /*  //添加
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
    }*/

    //根据key查找
    public String findByKey(String key){
        String newKey = new StringBuffer("account_").append(key).toString();
        // 获取String(字符)串类型
        ValueOperations<String,Account>  operations = redisTemplate.opsForValue();
        // 插入缓存(后面两个参数表示缓存有效时间为10s)
        operations.set("aaa",new Account(),10, TimeUnit.SECONDS);
        // 查询Hash(散列)类型
        // HashOperations
        // 查询List(列表)类型
        // ListOperations
        // 查询Set(集合)类型
        // SetOperations
        // 查询ZSet(有序集合)类型
        // ZSetOperations
        boolean hasKey = redisTemplate.hasKey(newKey);
        if(hasKey){
            // 根据key查询
            Account aaa = operations.get(newKey);
        }
        return null;
    }
    //查询所有
    public List<Account> findAccountList(){
        return null;
    }
}
