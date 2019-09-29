package com.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.joda.time.DateTime;

/**
 * @ClassName DateTest
 * @Description
 * @Author Cao.Zhuang
 * @Date 2019/6/11 16:42
 */

public class DateTest {

    private static final String FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static void main(String[] args) throws ParseException {

//        Map map = Collections.singletonMap("key","Value");
//
//        System.out.println("Singleton map is: "+map);
//
//
//        DateTime startDate = DateTime.now().withMillisOfDay(0).minusDays(8);
//        DateTime endDate = DateTime.now().withMillisOfDay(0).minusDays(7);
//        System.err.println(startDate.toString(FORMAT) + " " + endDate.toString(FORMAT));
//        getTime();
//        getDay();

//        Date d1 = sdf.parse("2019-6-11 16:00:00");
//        Date startDate = DateTime.now().withMillisOfDay(0).minusDays(7).toDate();
//        Date endDate = DateTime.now().withMillisOfDay(0).minusDays(6).toDate();
//        System.err.println(DateTime.now().toString(FORMAT));
//        System.err.println(sdf.format(startDate) + " " + sdf.format(endDate));

//        System.err.println(DateTime.now().minusDays(0).toString(FORMAT));

//        try {
//            System.err.println(DateUtils
//                    .truncatedCompareTo(new Date(), sdf.parse("2019-08-07 15:43:56"), Calendar.DAY_OF_MONTH));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        test();

//        DateTimeFormatter formatterDate = DateTimeFormat.forPattern("yyyy-MM-dd");
//        if(DateTime.now().isAfter(formatterDate.parseDateTime("2019-08-29"))){
//            System.err.println("11111");
//        }
//        if(DateTime.now().isBefore(formatterDate.parseDateTime("2019-08-30"))){
//            System.err.println("22222");
//        }

//        DateTime startDateTime = DateTime.now();
//        DateTime endDateTime = DateTime.now().plusDays(1).withMillisOfDay(0);
//        System.err.println(startDateTime.toString(FORMAT));
//        System.err.println(endDateTime.toString(FORMAT));
//        System.err.println(new Period(startDateTime, endDateTime, PeriodType.seconds()).getSeconds());
//        System.err.println(new Period(startDateTime, endDateTime).getHours());
//
//        Interval interval =new Interval(startDateTime, endDateTime);
//        Period period=interval.toPeriod();
//        System.out.println("开始于"+startDateTime+" 结束于"+endDateTime+"耗时"+period.getSeconds()+"秒");
//        System.err.println();
//        DateTime d1 = new DateTime(2018,2,26,2,30);
//        DateTime d2 = new DateTime(2018,2,26,2,36);
//        System.err.println(new Period(d1, d2, PeriodType.seconds()).getSeconds());
//        System.err.println(new Period(d1, d2, PeriodType.minutes()).getMinutes());
//        System.err.println(new Period(d1, d2, PeriodType.hours()).getHours());

//        DateTimeFormatter formatter = DateTimeFormat.forPattern("HH:mm:ss");
//        DateTime startTime = formatter.parseDateTime("11:59:59");
//        DateTime endTime = formatter.parseDateTime("10:59:59");
//        System.err.println(startTime.isBefore(endTime));

        LocalDate today = LocalDate.now();
        System.err.println(today);
        LocalTime time = LocalTime.now();
        System.err.println(time);
    }

    private static boolean judgePeriod(Date date, int plusDays) {
        return new DateTime(date).plusDays(plusDays - 1).withMillisOfDay(0).isBeforeNow() && new DateTime(date)
                .plusDays(plusDays).withMillisOfDay(0).isAfterNow();
    }

    public static void getDay() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //当天0点
        DateTime dt = new DateTime().withMillisOfDay(0);
        System.err.println(dt.isBeforeNow());
        //下一天0点
        DateTime dt2 = new DateTime().withMillisOfDay(0).plusDays(1);
        DateTime dt3 = new DateTime().plusDays(7);
        System.err.println(dt3.toString(FORMAT));
        System.err.println(dt3.isBeforeNow());
        try {
            Date d1 = sdf.parse("2019-6-11 16:00:00");
            Date d2 = sdf.parse("2019-6-12 16:00:01");
            Date d3 = sdf.parse("2019-6-13 00:00:00");
            Date d4 = sdf.parse("2019-6-13 01:00:00");
            Date d5 = sdf.parse("2019-6-14 17:00:00");

//            System.err.println(Days.daysBetween(new DateTime(d2), new DateTime(d1)).getDays());
//            System.err.println(new Period(new DateTime(d2), new DateTime(d1)).getDays());
            System.err.println(new DateTime(d2).plusDays(2).withMillisOfDay(0).toString(FORMAT));
//            System.out.println(dt2.toString(FORMAT));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date d1 = sdf.parse("2019-6-11 16:00:00");
            Date d2 = sdf.parse("2019-6-11 16:00:01");
            Date d3 = sdf.parse("2019-6-11 16:01:00");
            Date d4 = sdf.parse("2019-6-11 17:00:00");

            System.err.println("d2 - d1: " + (d2.getTime() - d1.getTime()));
            System.err.println("d3 - d1: " + (d3.getTime() - d1.getTime()));
            System.err.println("d4 - d1: " + (d4.getTime() - d1.getTime()));
            System.err.println();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void test() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, -1);
        date = calendar.getTime();
        System.err.println(formatter.format(date));
    }
}
