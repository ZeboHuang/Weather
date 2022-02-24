package com.lemondev.weather.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 2022/2/24
 * Created by vibrantBobo
 */

public class FormatUtils {

    private static final Calendar mCalendar = Calendar.getInstance();

    public static final String CAIYUN_DATE_PATTEN = "yyyy-MM-dd'T'hh:mmZ";

    private static final SimpleDateFormat caiyunDateFormatter = new SimpleDateFormat(CAIYUN_DATE_PATTEN);
    private static SimpleDateFormat dateFormatter;

    public static Date getDateWithCaiyunFormat(String date) {
        try {
            return caiyunDateFormatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Calendar getCalendarWithCaiyunFormat(String date) {
        mCalendar.setTime(getDateWithCaiyunFormat(date));
        return mCalendar;
    }


    public static String getFormatDate(String template, Date date) {
        setDateFormat(template);
        return dateFormatter.format(date);
    }

    public static String getFormatDate(String template, String date) {
        setDateFormat(template);
        try {
            return dateFormatter.format(SimpleDateFormat.getDateTimeInstance().parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void setDateFormat(String patten) {
        dateFormatter = new SimpleDateFormat(patten);
    }

}


