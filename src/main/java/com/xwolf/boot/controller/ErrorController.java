package com.xwolf.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 对应响应码跳转
 * @author xwolf
 * @version 1.0
 * @since 1.8
 */
@Controller
public class ErrorController {

    @GetMapping("500")
    public String error500(){
        return "500";
    }

    @GetMapping("404")
    public String error404(){
        return "404";
    }

    @GetMapping("400")
    public String error400(){
        return "400";
    }

    @GetMapping("302")
    public String error302(){
        return "302";
    }

}
