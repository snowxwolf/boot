package com.xwolf.boot.annotation;

import java.lang.annotation.*;

/**
 * 避免重复提交
 * @author xwolf
 * @version 1.0
 * @since 1.8
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AvoidRepeatableCommit {

    /**
     * 指定时间内不可重复提交,单位毫秒
     * @return
     */
    long timeout()  default 30000 ;

}
