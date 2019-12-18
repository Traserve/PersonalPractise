package test;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.scheduling.support.CronSequenceGenerator;

/**
 * @ClassName CronTest
 * @Description
 * @Author Cao.Zhuang
 * @Date 2019/6/12 18:04
 */

public class CronTest {

    public static void main(String[] args) {
        String cron = getCron(new Date());
//        System.out.println(cron);
        getTime();
    }

    /***
     *
     * @param date
     * @param dateFormat : e.g:yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String formatDateByPattern(Date date, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        String formatTimeStr = null;
        if (date != null) {
            formatTimeStr = sdf.format(date);
        }
        return formatTimeStr;
    }

    /***
     * convert Date to cron ,eg.  "0 06 10 15 1 ? 2014"
     * @param date  : 时间点
     * @return
     */
    public static String getCron(java.util.Date date) {
        String dateFormat = "ss mm HH dd MM ? yyyy";
        return formatDateByPattern(date, dateFormat);
    }

    public static void getTime() {
//        String cron = "0 */5 * * * ?";
//        String cron = "0 0 11 * * ?";
        String cron = "0 0 * * * *";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        CronSequenceGenerator cronSequenceGenerator = new CronSequenceGenerator(cron);
        Date currentTime = new Date();
        System.out.println("currentTime: " + currentTime);
        // currentTime为计算下次时间点的开始时间
        Date nextTimePoint = cronSequenceGenerator.next(currentTime);
        System.out.println("nextTimePoint: " + sdf.format(nextTimePoint));
        Date nextNextTimePoint = cronSequenceGenerator.next(nextTimePoint);
        System.out.println("nextNextTimePoint: " + sdf.format(nextNextTimePoint));
    }
}
