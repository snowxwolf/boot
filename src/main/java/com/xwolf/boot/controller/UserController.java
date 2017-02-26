package com.xwolf.boot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xwolf.boot.entity.User;
import com.xwolf.boot.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * </p>
 *
 * @author xwolf
 * @date 2017-02-25 09:20
 * @since V1.0.0
 */
@Controller
@RequestMapping("user")
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public String insert(@RequestParam(value = "name",defaultValue = "")String name){
        User user = new User();
        user.setUname(name);
        user.setBirth(new Date());
        log.info("请求参数:{}",user);
         return userService.insert(user);
    }

    @RequestMapping(value = "list/{start}/{size}",method = RequestMethod.POST)
    public PageInfo<User> getUserList(@PathVariable("start")int start,@PathVariable("size")int size){
        PageHelper.startPage(start,size);
       List<User> list= userService.getList();
       return new PageInfo<>(list);
    }
}
