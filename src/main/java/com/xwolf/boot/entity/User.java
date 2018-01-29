package com.xwolf.boot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xwolf.boot.config.Constants;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

/**
 * 用户
 * @author xwolf
 * @date 2017-02-25 09:00
 * @since 1.8
 * @version 1.0.0
 */
@Data
@ToString
public class User {

    /**
     * 用户ID
     */
    private int uid;

    /**
     * 用户名
     */
    @NotBlank(message ="用户名不能为空")
    @Length(min = 5,max =32,message = "用户名长度在5-32")
    private String uname;

    /**
     * 生日
     */
    @JsonFormat(pattern = Constants.DATE_DEFAULT_FORMAT)
    private Date birth;
}
