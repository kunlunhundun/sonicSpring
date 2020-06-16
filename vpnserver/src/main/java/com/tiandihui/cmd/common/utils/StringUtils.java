package com.tiandihui.cmd.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    public static String replaceEnter(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    //去掉前后的空格
    public static String strim(String str) {
       return str.trim();
    }

    //去掉所有的空格
    public static String replaceAll(String str) {
        return str.replaceAll(" ", "");
    }


   /* 注：\n 回车(\u000a)
    \t 水平制表符(\u0009)
    \s 空格(\u0008)
    \r 换行(\u000d)*/
}
