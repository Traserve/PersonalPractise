package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Martin
 * @date: 2023/5/25 21:27
 * Description:
 */
public class Test10 {

    /**
     * 分解质因数
     *
     * @param args
     */
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int in = scanner.nextInt();
//        int in = 10;
        for (int i = 5; i <= 100; i++) {
            System.out.println(i + split(i));
        }
    }

    public static String split(int num) {
        List<Integer> res = new ArrayList<>();
        // 保存质数
        List<Integer> primeNums = new ArrayList<>();
        primeNums.add(2);
        primeNums.add(3);
        primeNums.add(5);
        int i = 0;
        while (num != 1) {
            for (; i < primeNums.size() && num != 1; i++) {
                int primeNum = primeNums.get(i);
                if (num / primeNum > 0 && num % primeNum == 0) {
                    num = num / primeNum;
                    res.add(primeNum);
                    // 可以整除后，从头开始从新计算
                    i = -1;
                }
            }
            if (num == 1) {
                break;
            }
            // 计算下一个质数
            int next = primeNums.get(primeNums.size() - 1);
            while (true) {
                next++;
                int j = 2;
                for (; j < next / 2; j++) {
                    if (next % j == 0) {
                        break;
                    }
                }
                // 不存在可以整除的说明是质数
                if (j == next / 2) {
                    primeNums.add(next);
                    break;
                }
            }
        }
        StringBuilder builder = new StringBuilder(" = ");
        for (Integer k : res) {
            builder.append(k).append(" * ");
        }
        builder.delete(builder.length() - 3, builder.length());
        return builder.toString();
    }
}
