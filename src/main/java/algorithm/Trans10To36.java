package algorithm;

/**
 * @author: Martin
 * @date: 2023/5/26 1:30
 * Description: 十进制转为 36 进制：1,2,3,4,5,6,7,8,9,A,B,C...X,Y,Z,10
 * 输入：80 输出：28
 */
public class Trans10To36 {

    public static void main(String[] args) {
        for (int i = 0; i <= 36 * 15; i++) {
            System.out.print(trans(i) + " ");
            if (i != 0 && i % 36 == 0) {
                System.out.println();
            }
        }
    }

    public static String trans(int num) {
        int tmp = 1;
        int n = 0;
        StringBuilder res = new StringBuilder();
        while (num >= 36) {
            while (tmp <= num) {
                tmp *= 36;
            }
            tmp /= 36;
            n = num / tmp;
            res.append(transSingleNum(n));
            num -= n * tmp;
            tmp = 1;
        }
        res.append(transSingleNum(num));
        return res.toString();
    }

    public static String transSingleNum(int num) {
        if (num < 10) {
            return String.valueOf(num);
        }
        return String.valueOf((char) ('A' + (num - 10)));
    }
}


