package com.xwolf.boot.api;

import com.xwolf.boot.entity.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;
import java.util.List;

/**
 * @author wolf
 */

public interface UserBaseController {

    /**
     * 添加用户
     * @param user
     * @return
     */
     @ApiOperation(value = "添加用户")
     String insert(@Valid User user);

    /**
     * 获取用户列表
     * @param start
     * @param size
     * @return
     */
     @ApiOperation(value = "获取用户列表")
     List<User> getUserList(@PathVariable("start")int start, @PathVariable("size")int size);
}
