package com.xwolf.boot.dao;

import com.xwolf.boot.entity.User;

import java.util.List;

/**
 * <p>
 * </p>
 *
 * @author xwolf
 * @date 2017-02-25 09:07
 * @since V1.0.0
 */
public interface IUserDao {

    int insert(User user);

    List<User> queryList();
}
