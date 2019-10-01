package arithmetic;

/**
 * @ClassName WorkerCommission
 * @Description https://www.cnblogs.com/zhazhaboke/p/10561154.html
 * @Author Cao.Zhuang
 * @Date 2019/10/1 10:06
 */

public class WorkerCommission {

    static int[] v = {0, 5, 1, 8, 4, 6, 3, 2, 4};
    static int[] prev = {0, 0, 0, 0, 1, 0, 2, 3, 5};

    public static void main(String[] args) {
        int rec_opt = rec_opt(8);
        int dp_opt = dp_opt();
        System.out.println(rec_opt);
        System.out.println(dp_opt);
    }

    /**
     * 递归解法
     */
    public static int rec_opt(int k) {
        int max = 0;
        if (k == 0) {
            return 0;
        }
        if (k >= 1) {
            int A = rec_opt(k - 1);//不选
            int B = v[k] + rec_opt(prev[k]);//选
            max = Math.max(A, B);
        }

        return max;
    }

    /**
     * 动态规划解法
     */
    public static int dp_opt() {
        int[] subset = new int[v.length];
        subset[0] = 0;
        for (int i = 1; i < subset.length; i++) {
            int A = subset[i - 1];//不选
            int B = v[i] + subset[prev[i]];//选
            subset[i] = Math.max(A, B);
        }

        return subset[v.length - 1];
    }

}
