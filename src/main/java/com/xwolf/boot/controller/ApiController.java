package com.xwolf.boot.controller;

import com.google.common.collect.Maps;
import com.xwolf.boot.api.ApiBaseController;
import com.xwolf.boot.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Swagger API测试Controller,无明确时限,以Map代替CRUD
 * @author xwolf
 * @date 2017-02-26 20:15
 * @since 1.8
 * @version 1.0.0
 */
@RestController
@RequestMapping(value="/api")
public class ApiController implements ApiBaseController {

    private static Map<Integer, User> users = Maps.newConcurrentMap();

    @GetMapping(value={"/list"})
    @Override
    public List<User> getUserList() {
        List<User> r = new ArrayList<User>(users.values());
        return r;
    }

    @PostMapping(value="/add")
    @Override
    public String postUser(@RequestBody User user) {
        users.put(user.getUid(), user);
        return "success";
    }

    @Override
    @GetMapping(value="/{id:\\d+}")
    public User getUser(@PathVariable Integer id) {
        return users.get(id);
    }

    @Override
    @PutMapping(value="/{id:\\d+}")
    public String putUser(@PathVariable Integer id, @RequestBody User user) {
        User u = users.get(id);
        u.setUname(user.getUname());
        users.put(id, u);
        return "success";
    }

    @Override
    @DeleteMapping(value="/{id:\\d+}")
    public String deleteUser(@PathVariable Integer id) {
        users.remove(id);
        return "success";
    }
}
