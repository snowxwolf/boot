package com.xwolf.boot.controller;

import com.google.common.collect.Maps;
import com.xwolf.boot.entity.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Swagger API测试Controller,无明确时限,以Map代替CRUD
 * @author xwolf
 * @date 2017-02-26 20:15
 * @since 1.8
 * @version 1.0.0
 */
@RestController
@RequestMapping(value="/api")
public class ApiController {

    private static Map<Integer, User> users = Maps.newConcurrentMap();

    @ApiOperation(value="获取用户列表", notes="")
    @GetMapping(value={"/list"})
    public List<User> getUserList() {
        List<User> r = new ArrayList<User>(users.values());
        return r;
    }

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @PostMapping(value="/add")
    public String postUser(@RequestBody User user) {
        users.put(user.getUid(), user);
        return "success";
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer")
    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public User getUser(@PathVariable Integer id) {
        return users.get(id);
    }

    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String putUser(@PathVariable Integer id, @RequestBody User user) {
        User u = users.get(id);
        u.setUname(user.getUname());
        users.put(id, u);
        return "success";
    }

    /**
     * 删除用户
     * @param id 用户ID
     * @return
     */
    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer")
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable Integer id) {
        users.remove(id);
        return "success";
    }
}
