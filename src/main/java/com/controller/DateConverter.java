package com.controller;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import org.springframework.core.convert.converter.Converter;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-02-20 11:23
 */
public class DateConverter implements Converter<String, Date> {
    //自定义日期格式
    private static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

    @Override
    public Date convert(String source) {
        //格式化日期
        if(source == null || source.isEmpty()){
            return null;
        }
        // 定义数组，保存支持的日期字符串的格式
        DateTimeFormatter[] dtfs = new DateTimeFormatter[] {
                DateTimeFormat.forPattern(DATE_PATTERN),
                DateTimeFormat.forPattern("yyyy-MM-dd"),
                DateTimeFormat.forPattern("yyyy/MM/dd"),
                DateTimeFormat.forPattern("yyyyMMdd")
        };
        for (DateTimeFormatter dtf : dtfs) {

            DateTime dt = dtf.parseDateTime(source);
            if(dt != null) {
                return dt.toDate();
            } else {
                continue;
            }
        }

        return null;

//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN);
//
//        try {
//            if(null != source) {
//                return simpleDateFormat.parse(source);
//            }
//        } catch (ParseException e) {
//            throw new IllegalArgumentException("无效的日期格式，请使用这种格式：" + DATE_PATTERN);
//        }
//        return null;
    }

    public static String format(Date date) {
        //格式化日期
        if(date == null){
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(DATE_PATTERN);

//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN);
//        return simpleDateFormat.format(date);
    }

    public static Date strToDate(String dateTimeStr,String formatStr){
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(formatStr);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
        return dateTime.toDate();
    }

    public static String dateToStr(Date date,String formatStr){
        if(date == null){
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(formatStr);
    }

    public static Date strToDate(String dateTimeStr){
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(DATE_PATTERN);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
        return dateTime.toDate();
    }

    public static String dateToStr(Date date){
        if(date == null){
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(DATE_PATTERN);
    }

/*
1、将字符串转换为时间
    DateTimeFormatter forPattern = DateTimeFormat.forPattern(“yyyy-MM-dd”);
    DateTime dateTime=forPattern.parseDateTime(“2018-01-01”);
    format = DateTimeFormat.forPattern(“yyyy年MM月dd日 HH:mm:ss”);
    dateTime=forPattern.parseDateTime(“2018年01月01日 23:25:35”);
2、将时间转换为字符串
    DateTime dateTime=new DateTime();
    String dateString = dateTime.toString(“yyyyMMdd”);
    DateTimeFormatter forPattern = DateTimeFormat.forPattern(“yyyy年MM月dd日 HH:mm:ss”);
    dateString=forPattern.print(dateTime);
3、得到任何日期所在周的第一天与最后一天
    DateTime dateTime=new DateTime();
    // 一周的开始日期
    String monday= dateTime.dayOfWeek().withMinimumValue().toString(“yyyyMMdd”);
    // 一周的结束日期
    String sunday= dateTime.dayOfWeek().withMaximumValue().toString(“yyyyMMdd”);
4、得到任何日期所在月的第一天与最后一天
    DateTime dateTime=new DateTime();
    String first= dateTime.dayOfMonth().withMinimumValue().toString(“yyyyMMdd”);
    String last= dateTime.dayOfMonth().withMaximumValue().toString(“yyyyMMdd”);

5、得到任何日期所在年的第一天与最后一天
    DateTime dateTime=new DateTime();
    String first= dateTime.dayOfYear().withMinimumValue().toString(“yyyyMMdd”);
    String last= dateTime.dayOfYear().withMaximumValue().toString(“yyyyMMdd”);
6、加减年、月、周、天、时、分、秒、毫秒
    DateTime dateTime=new DateTime();
    //加一年
    dateTime.plusYears(1);
    //加一月
    dateTime.plusMonths(1);
    //加一周
    dateTime.plusWeeks(1);
    //加一天
    dateTime.plusDays(1);
    //加一小时
    dateTime.plusHours(1);
    dateTime.plusMinutes(1);
    dateTime.plusSeconds(1);
    dateTime.plusMillis(1);

    //减去一年
    dateTime.minusYears(1);
    //减去加一月
    dateTime.minusMonths(1);

7、得到上一周的星期一与星期天、下一周的星期一与星期天
    DateTime dateTime=new DateTime();
    DateTime previousMonday= dateTime.dayOfWeek().withMinimumValue().minusWeeks(1);
    DateTime previousSunday= dateTime.dayOfWeek().withMaximumValue().minusWeeks(1);

    DateTime nextMonday= dateTime.dayOfWeek().withMinimumValue().plusWeeks(1);
    DateTime nextSunday= dateTime.dayOfWeek().withMaximumValue().plusWeeks(1);

8、得到上一个月的第一天与最后一天、下一个有的第一天与最后一天
    DateTime dateTime=new DateTime();
    String previousFirstDay= dateTime.dayOfYear().withMinimumValue().minusMonths(1).toString(“yyyyMMdd”);
    String previousLastDay= dateTime.dayOfYear().withMaximumValue().minusMonths(1).toString(“yyyyMMdd”);

    String nextFirstDay= dateTime.dayOfYear().withMinimumValue().plusMonths(1).toString(“yyyyMMdd”);
    String nextLastDay= dateTime.dayOfYear().withMaximumValue().plusMonths(1).toString(“yyyyMMdd”);

9、计算两个日期相差多少天、相差多少月、相差多少年
    DateTime nextFirstDay= dateTime.dayOfYear().withMinimumValue().plusMonths(1);
    DateTime nextLastDay= dateTime.dayOfYear().withMaximumValue().plusMonths(1);
    int days = Days.daysBetween(nextFirstDay, nextLastDay).getDays();
    int months = Months.monthsBetween(nextFirstDay, nextLastDay).getMonths();
    int years = Years.yearsBetween(nextFirstDay, nextLastDay).getYears();

10、计算某个月份的第一个星期二
    DateTime now =new DateTime();
    String date=now.monthOfYear()
            .setCopy(10) // 10月
            .dayOfMonth()
            .withMinimumValue() // 10月第一天
            .plusDays(6) // 加6天
            .dayOfWeek()
            .setCopy(2) //第一个星期二
            .toString(“yyyy-MM-dd”);

11、判断闰年、闰月
    DateTime now =new DateTime();
    boolean leapYear = now.year().isLeap();
    boolean leapMonth = now.monthOfYear().isLeap();

12、取得一天的开始时间和结束时间
    DateTime now = new DateTime();
    String formatter=“yyyy-MM-dd HH:mm:ss”；
    String startTime = now.withTimeAtStartOfDay().toString(formatter);
    String endTime = now.millisOfDay().withMaximumValue().toString(formatter);
*/
}
