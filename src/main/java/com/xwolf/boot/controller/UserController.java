package com.xwolf.boot.controller;

import com.github.pagehelper.PageHelper;
import com.xwolf.boot.annotation.AvoidRepeatableCommit;
import com.xwolf.boot.entity.User;
import com.xwolf.boot.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 *
 * @author xwolf
 * @date 2017-02-25 09:20
 * @since 1.8
 * @version 1.0.0
 */
@RestController
@RequestMapping("user")
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 添加用户
     * @param user
     * @return
     */
    @PostMapping(value = "add")
    @AvoidRepeatableCommit(timeout = 50000)
    public String insert(@Valid User user){
        // user.setBirth(new Date());
        log.info("请求参数:{}",user);
        return userService.insert(user);
    }

    /**
     * 获取用户列表
     * @param start
     * @param size
     * @return
     */
    @GetMapping(value = "list/{start}/{size}")
    public List<User> getUserList(@PathVariable("start")int start,@PathVariable("size")int size){
       PageHelper.startPage(start,size);
       List<User> list= userService.getList();
       return list;
    }
}
