package ndInterest;

import java.math.BigDecimal;

/**
 * @ClassName NioTest
 * @Description
 * @Author Cao.Zhuang
 * @Date 2019/7/10 19:04
 */

public class YXJBTest {

    public static void main(String[] args) {
        System.err.println(getInterest(100000, 85000));
    }

    public static long getInterest(long amount, long rate) {
        return BigDecimal.valueOf(amount).multiply(BigDecimal.valueOf(rate))
                .divide(BigDecimal.valueOf(12 * 1000000), 0, BigDecimal.ROUND_UP).longValue();
    }

    public static long getYXJBRate(int phase) {
        if (phase >= 1 && phase <= 3) {
            return 100000;
        } else if (phase >= 4 && phase <= 6) {
            return 200000;
        } else if (phase >= 7 && phase <= 9) {
            return 300000;
        } else if (phase >= 10 && phase <= 12) {
            return 400000;
        }
        return 0;
    }

}
