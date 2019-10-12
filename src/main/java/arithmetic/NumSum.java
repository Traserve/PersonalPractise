package arithmetic;

/**
 * @ClassName NumSum
 * @Description 从 1 2 4 1 7 8 3中找到不相邻相加之后最大的,不管有几个数字
 * @Author Cao.Zhuang
 * @Date 2019/10/1 11:40
 */

public class NumSum {

    private static int[] numSeq = {1, 2, 4, 1, 7, 8, 3};

    public static void main(String[] args) {
        int[] dp = new int[numSeq.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 0;
        }
        dp[0] = numSeq[0];
        dp[1] =  Math.max(numSeq[0], numSeq[1]);
        numSum(dp);
        System.err.println(numSum(numSeq.length-1));
    }

    /**
     * dp数组解法
     * @param dp
     * @return
     */
    private static int numSum(int[] dp){
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(numSeq[i] + dp[i-2], dp[i-1]);
        }
        for (int i = 0; i < dp.length; i++) {
            System.err.print(dp[i] + " ");
        }
        System.err.print("\n");
        return dp[dp.length-1];
    }

    /**
     * 递归解法
     * @param k
     * @return
     */
    private static int numSum(int k){
        if(k==0){
            return numSeq[0];
        }
        if(k==1){
            return Math.max(numSeq[0], numSeq[1]);
        }
        return Math.max(numSum(k-2)+numSeq[k], numSum(k-1));
    }
}
