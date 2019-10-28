package com.test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName Other
 * @Description
 * @Author Cao.Zhuang
 * @Date 2019/6/12 16:54
 */

public class Other {

    public static void main(String[] args) {
//        System.err.println(Base64.getEncoder().encodeToString((String.valueOf(7)).getBytes(Charset.forName("utf-8"))));
//        System.err.println(Base64.getEncoder().encodeToString((String.valueOf(8)).getBytes(Charset.forName("utf-8"))));
//        String a = null;
//        System.err.println("1".equals(a));
//        System.err.println(a.equals(1));

//        System.err.println(UUID.randomUUID());
//        System.err.println(UUID.randomUUID());
//        System.err.println(UUID.randomUUID());
//        System.err.println(UUID.randomUUID());
//        System.err.println(UUID.randomUUID());
//        System.err.println(RandomStringUtils.randomAlphabetic(16));

//        hashCode2("sagasg".toCharArray());
//        double max=100,min=99.99;
//        for (int i = 0; i < 10; i++) {
//            System.err.println((Math.random() * (max - min) + min));
//        }
//        System.err.println(1/0.0101);
//        String s = "0.03%";
//        System.err.println(s.substring(0, 3));
//        System.err.println(s.substring(0, s.length()-1));
//        System.err.println(s.substring(3));
//        double registerAndLoanRate = getIntervalRandomValue("0-0", 2).doubleValue() / 100D;
//        if(registerAndLoanRate == 0){
//            System.err.println("00000000000000");
//        }
//        Map<Object, Object> map = new HashMap<>();
//        map.put("22", true);
//        System.err.println(String.valueOf(map.get("11")));
//        System.err.println(String.valueOf(map.get("22")));
//        System.err.println(Boolean.valueOf(String.valueOf(map.get("11"))));
//        System.err.println(Boolean.valueOf(String.valueOf(map.get("22"))));
//        System.err.println(idCardNoMock("430421199011089157"));

        BigDecimal total = new BigDecimal("10000");
        BigDecimal raise = new BigDecimal("3300");
        System.err.println(
                raise.divide(total, 2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).toString().concat("%"));
    }

    public static String amountToCommaString(Long amount) {
        if (null != amount && amount > 0L) {
            BigDecimal a = new BigDecimal(amount);
            a = a.divide(BigDecimal.valueOf(100L), 1);
            return (new DecimalFormat(",###")).format(a).toString();
        } else {
            return "0";
        }
    }

    /**
     * 身份证号脱敏
     */
    public static String idCardNoMock(String idCardNo) {
        if (StringUtils.isEmpty(idCardNo) || (idCardNo.length() < 8)) {
            return idCardNo;
        }
        return idCardNo.replaceAll("(?<=\\w{3})\\w(?=\\w{4})", "*");
    }


    public static int hashCode2(char[] value) {
        int hash = 0;
        int h = hash;
        if (h == 0 && value.length > 0) {
            char val[] = value;

            for (int i = 0; i < value.length; i++) {
                h = 31 * h + val[i];
            }
            hash = h;
        }
        return h;
    }

    private static BigDecimal getIntervalRandomValue(String interval, int scale) {
        String[] boundaryValue = interval.split("-");
        double min = Double.valueOf(boundaryValue[0]);
        double max = Double.valueOf(boundaryValue[1]);
        if (min == max) {
            return new BigDecimal(max);
        }
        return new BigDecimal(Math.random() * (max - min) + min).setScale(scale, BigDecimal.ROUND_HALF_UP);
    }

}
