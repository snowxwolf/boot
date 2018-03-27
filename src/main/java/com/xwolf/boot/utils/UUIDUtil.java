package com.xwolf.boot.utils;

import java.util.UUID;

/**
 * @author xwolf
 * @version 1.0
 * @since 1.8
 */
public class UUIDUtil {

    public static String uuid(){
        return UUID.randomUUID().toString().replace("-","").toLowerCase();
    }
}
