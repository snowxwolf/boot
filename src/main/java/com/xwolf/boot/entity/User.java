package com.xwolf.boot.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * <p>
 * </p>
 *
 * @author xwolf
 * @date 2017-02-25 09:00
 * @since V1.0.0
 */
@Data
@Slf4j
public class User {

    private int uid;
    private String uname;
    private Date birth;
}
