package com.library.manager.util;

import com.library.manager.exception.AppsException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalendarUtil {


    public static final String DEFAULT_DATE_TIME_FORMAT = "dd/MM/yyyy HH:mm:ss";

    public static final String DEFAULT_DATE_FORMAT = "dd/MM/yyyy";

    public static Date getParsedDate(String date, String dateFormat) throws AppsException {

        Date parsedDate;
        try {
            SimpleDateFormat format = new SimpleDateFormat(dateFormat);
            parsedDate = format.parse(date);
            return parsedDate;
        } catch (ParseException e) {
            throw new AppsException("Invalid data format");
        }

    }

    public static Date getDefaultParsedDateOnly(String date) throws AppsException {
        return getParsedDate(date, DEFAULT_DATE_FORMAT);
    }

    public static Date getDefaultParsedDateOnlyMaskNull(String date) throws Exception {
        return date != null ? getParsedDate(date, DEFAULT_DATE_FORMAT) : null;
    }

    public static String getDefaultFormattedDateTimeMaskNull(Date date) {
        if (date != null) {
            return CalendarUtil.getDefaultFormattedDateTime(date);
        }
        return null;
    }

    public static String getDefaultFormattedDateTime(Date date) {
        return getFormattedDate(date, DEFAULT_DATE_TIME_FORMAT);
    }

    public static String getFormattedDate(Date date, String dateFormat) {
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        return formatter.format(date);
    }

    public static String getDefaultFormattedDate(Date date) {
        return getFormattedDate(date, DEFAULT_DATE_FORMAT);
    }
}
