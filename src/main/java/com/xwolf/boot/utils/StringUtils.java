package com.xwolf.boot.utils;

/**
 * 字符串工具
 * @author xwolf
 * @version 1.0
 * @since 1.8
 */
public class StringUtils {

    /**
     * 是否为空字符串
     * @param str
     * @return
     */
    public static boolean isBlank(String str){
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (Character.isWhitespace(str.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotBlank(String str){
        return !isBlank(str);
    }

}
