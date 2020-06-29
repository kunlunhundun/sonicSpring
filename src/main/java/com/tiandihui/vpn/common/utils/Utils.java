package com.tiandihui.vpn.common.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Utils {


    public static int differentDaysByMillisecond(Date date1, Date date2)
    {
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
        return days;
    }

    public static Date addDays(int days) {
        Date nowDate = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(nowDate);
        calendar.add(calendar.DATE,days); //把日期往后增加一天,整数  往后推,负数往前移动
        Date  newDate = calendar.getTime(); //这个时间就是日期往后推一天的结果
        return newDate;
    }

    public static Date subDays(int days) {
        Date nowDate = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(nowDate);
        calendar.add(calendar.DATE,0-days); //把日期往后增加一天,整数  往后推,负数往前移动
        Date  newDate = calendar.getTime(); //这个时间就是日期往后推一天的结果
        return newDate;
    }


}
