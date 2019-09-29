package ndInterest;

import java.math.BigDecimal;

/**
 * @ClassName XXHBTest
 * @Description
 * @Author Cao.Zhuang
 * @Date 2019/7/10 19:16
 */

public class XXHBTest {

    public static void main(String[] args) {
        System.err.println(getPhaseFee(100000, 85000, 12, 1));
    }

    public static long getPhaseFee(long totalAmount, long totalRate, long totalPhase, long phase) {
        BigDecimal fee = BigDecimal.valueOf(totalAmount).multiply(BigDecimal.valueOf(totalRate))
                .divide(BigDecimal.valueOf(12 * 1000000), 0, BigDecimal.ROUND_UP);
        long result = fee.longValue();
        if (totalPhase == phase) {
            long totalFee = totalAmount * totalRate * totalPhase / 12 / 1000000;
            return totalFee - result * (totalPhase - 1);
        } else {
            return result;
        }
    }
}
