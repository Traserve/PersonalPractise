package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName CalendarTest
 * @Description
 * @Author Cao.Zhuang
 * @Date 2019/6/11 10:56
 */

public class CalendarTest {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        Date startTime = cal.getTime();
        System.err.println("startTime: " + sdf.format(startTime));
        cal.add(Calendar.MINUTE, 10);
//        cal.add(Calendar.DAY_OF_YEAR,10);
        Date endTime = cal.getTime();
        System.err.println("endTime: " + sdf.format(endTime));
    }
}
