package com.tiandihui.vpn.common.utils;

import java.util.Date;

public class Utils {

    public static int differentDaysByMillisecond(Date date1, Date date2)
    {
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
        return days;
    }


}
