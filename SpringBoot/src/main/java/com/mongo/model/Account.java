package com.mongo.model;

import org.springframework.data.annotation.Id;

public class Account {
    /**
     *  cid：该字段用于mongodb的“_id"索引
     *  1 需要	@Id的注解
     *  2定义为String类型  ，如果定义为Integer可能索引只会是0
     *  会出现key重复导致数据库插不进去的情况
     *  3该类型也是MongoRepository泛型类主键的ID
     *
     */
    @Id
    private String cid;
    private String name;
    private Double money;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
