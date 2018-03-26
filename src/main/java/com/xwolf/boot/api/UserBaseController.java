package com.xwolf.boot.api;

import com.xwolf.boot.entity.User;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;
import java.util.List;

public interface UserBaseController {

    public String insert(@Valid User user);

    public List<User> getUserList(@PathVariable("start")int start, @PathVariable("size")int size);
}
