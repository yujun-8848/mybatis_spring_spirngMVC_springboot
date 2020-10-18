package com.mybatis.dao;

import com.mybatis.domain.QueryVo;
import com.mybatis.domain.User;

import java.util.List;

/**
 * 查询接口
 */
public interface IUserDao {

    /**
     * 查询接口
     */
    List<User> findAll();

    /**
     * 插入值
     *
     * @param user
     */
    void saveUser(User user);

    /**
     * 测试更新
     */
    void updateUser(User user);

    /**
     * 删除
     */
    void delete(int id);

    /**
     * 查找指定ID
     * @param id
     * @return
     */
    User findUserId(int id);

    /**
     * 查询总条数
     * @return
     */
    int findTotal();

    /**
     * 用户自定义类型
     */
    List<User> findVo(QueryVo queryVo);
}
