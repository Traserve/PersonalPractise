package arithmetic;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @ClassName SteelBarsCut
 * @Description
 * @Author Cao.Zhuang
 * @Date 2019/9/29 14:55
 */

public class SteelBarsCut {

    private static int[] p = {1, 5, 8, 9, 10, 17, 17, 21, 24, 30};
    private static int[] initPrice = {0, 1, 5, 8, 9, 10, 17, 17, 21, 24, 30};
    private static int[] initdemo = {1, 5, 8, 9, 10};

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
//        System.err.println(steelBarsCut(4, map));
        System.err.println(cut2(5));
        System.err.println(cut3(5));
        System.err.println(buttom_up_cut(initdemo));
//        for (int i = 0; i < map.size(); i++) {
//            System.err.println(map.get(i));
//        }
//        int[] r = new int[p.length + 1];
//        for (int i = 0; i <= p.length; i++) {
//            r[i] = -1;
//        }
//        System.err.println(cut(initdemo, initdemo.length, r));
    }

    public static int steelBarsCut(int n, Map<Integer, Integer> map) {
        if (Optional.ofNullable(map.get(n)).orElse(-1) >= 0) {
            return map.get(n);
        }
        int max = -1;
        if (n == 0) {
            max = 0;
        } else {
            for (int i = 1; i < initPrice.length; i++) {
                max = Math.max(initPrice[n], steelBarsCut(n - i, map) + initPrice[i]);
            }
        }
        map.put(n, max);
        return 0;
    }

    public static int cut3(int n) {
        if (n == 0) {
            return 0;
        }
        int q = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            q = Math.max(q, p[i - 1] + cut3(n - i));
        }
        return q;
    }

    public static int cut2(int n) {
        if (n <= 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, cut2(n - i) + initPrice[i]);
        }
        return max;
    }


    public static int cut(int[] p, int n, int[] r) {
        int q = -1;
        if (r[n] >= 0) {
            return r[n];
        }
        if (n == 0) {
            q = 0;
        } else {
            for (int i = 1; i <= n; i++) {
                q = Math.max(q, cut(p, n - i, r) + p[i - 1]);
            }
        }
        r[n] = q;
        return q;
    }

    public static int buttom_up_cut(int[] p) {
        int[] r = new int[p.length + 1];
        for (int i = 1; i <= p.length; i++) {
            int q = -1;
            //①
            for (int j = 1; j <= i; j++) {
                q = Math.max(q, p[j - 1] + r[i - j]);
            }
            r[i] = q;
        }
        return r[p.length];
    }
}
