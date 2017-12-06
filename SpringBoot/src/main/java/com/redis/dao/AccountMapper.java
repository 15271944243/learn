package com.redis.dao;

import com.redis.model.Account;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AccountMapper {
    //添加数据
    @Insert("insert into test_account (name,money) values(#{name},#{money})  ")
    public int add(@Param("name") String name, @Param("money") double money);

    //更新数据
    @Update("update test_account set name =#{name},money= #{money} where id = #{id}")
    public int update(@Param("name") String name, @Param("money") double money,
                      @Param("id") int id);
    //根据id删除
    @Delete("delete from test_account where id=#{id}")
    public  int delete(int id);

    //通过id查找Account对象
    @Select("select id,name ,money from test_account where id=#{id}")
    public Account findAccount(@Param("id") int id);

    //查询所有
    @Select("select id,name ,money from test_account")
    public List<Account> findAccountList();
}
