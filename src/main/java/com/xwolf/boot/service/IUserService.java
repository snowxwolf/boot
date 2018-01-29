package com.xwolf.boot.service;

import com.xwolf.boot.entity.User;

import java.util.List;

/**
 * @author xwolf
 * @date 2017-02-25 09:16
 * @since 1.8
 * @version 1.0.0
 */
public interface IUserService {

    String insert(User user);

    List<User> getList();
}
