package com.xwolf.boot.service;

import com.xwolf.boot.entity.User;

import java.util.List;

/**
 * <p>
 * </p>
 *
 * @author xwolf
 * @date 2017-02-25 09:16
 * @since V1.0.0
 */
public interface IUserService {

    String insert(User user);

    List<User> getList();
}
