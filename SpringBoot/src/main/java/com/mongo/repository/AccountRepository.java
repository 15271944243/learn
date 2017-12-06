package com.mongo.repository;

import com.mongo.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AccountRepository extends MongoRepository<Account,String> {

    /**
     *
     * findByFirstname 命名有研究，比如 findBy后面的名称是实体类属性名称
     * Firstname
     *
     */
    public List<Account> findByName(String name);
    public List<Account> findByMoney(Double money);
}
