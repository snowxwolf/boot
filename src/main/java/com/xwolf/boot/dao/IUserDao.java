package com.xwolf.boot.dao;

import com.xwolf.boot.entity.User;

import java.util.List;

/**
 * @author xwolf
 * @date 2017-02-25 09:07
 * @since 1.8
 * @version 1.0.0
 */
public interface IUserDao {

    int insert(User user);

    List<User> queryList();
}
