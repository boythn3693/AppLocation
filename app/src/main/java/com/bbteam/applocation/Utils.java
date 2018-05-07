package com.bbteam.applocation;


import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Utils {

    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String getCurrentDateTime() {
        Calendar c = Calendar.getInstance();
        return df.format(c.getTime());
    }
}
