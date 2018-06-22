package com.yoti.api.client.spi.remote;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.yoti.api.client.spi.remote.call.YotiConstants.DEFAULT_CHARSET;
import static java.lang.String.format;

/**
 * Attribute value holding a year/month/day tuple.
 *
 */
final class DateValue implements com.yoti.api.client.Date {

    private static final String DATE_PATTERN = "yyyy-MM-dd";
    private final int year;
    private final int month;
    private final int day;

    private DateValue(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public static DateValue parseFrom(byte[] content) throws UnsupportedEncodingException, ParseException {
        String source = new String(content, DEFAULT_CHARSET);
        return parseFrom(source);
    }

    public static DateValue parseFrom(String source) throws UnsupportedEncodingException, ParseException {
        Calendar calendar = parseDate(source);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return new DateValue(year, month, day);
    }

    private static Calendar parseDate(String source) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
        sdf.setLenient(false);
        Date date = sdf.parse(source);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public int getMonth() {
        return month;
    }

    @Override
    public int getDay() {
        return day;
    }

    @Override
    public String toString() {
        return format("%04d-%02d-%02d", year, month, day);
    }

}
