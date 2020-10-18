package com.mybatis.dao;

import com.mybatis.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 查询接口
 */
public interface IUserDao {

    @Select("select * from user")
    List<User> findAll();
}
