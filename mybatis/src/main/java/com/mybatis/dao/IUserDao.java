package com.mybatis.dao;

import com.mybatis.domain.User;

import java.util.List;

/**
 * 查询接口
 */
public interface IUserDao {

    List<User> findAll();
    void saveUser(User user);
}
