package arithmetic.stock;

/**
 * Description: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 *
 * @author Cao.Zhuang
 * @date 2019/11/13 11:34
 */

public class BuyAndSellStock3 {

    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.err.println(maxProfit(prices));
        System.err.println(maxProfit2(prices));
        System.err.println(maxProfit3(prices));
    }

    public static int maxProfit(int[] prices) {
        int max_k = 2;
        int[][][] dp = new int[prices.length][max_k + 1][2];
        dp[0][0][0] = 0;
        dp[0][0][1] = Integer.MIN_VALUE;
        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][2][0] = 0;
        dp[0][2][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            for (int k = max_k; k >= 1; k--) {
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[prices.length - 1][max_k][0];
    }

    public static int maxProfit2(int[] prices) {
        int hold1 = Integer.MAX_VALUE, hold2 = Integer.MAX_VALUE;
        int sell1 = 0, sell2 = 0;
        for (int i = 0; i < prices.length; i++) {
            hold1 = Math.min(hold1, prices[i]);
            sell1 = Math.max(prices[i] - hold1, sell1);

            hold2 = Math.min(hold2, prices[i] - sell1);
            sell2 = Math.max(sell2, prices[i] - hold2);
        }
        return sell2;
    }

    public static int maxProfit3(int[] prices) {
        int k = 2;
        int[][] t = new int[k + 1][prices.length];
        for (int i = 1; i <= k; i++) {
            int tmpMax = -prices[0];
            for (int j = 1; j < prices.length; j++) {
                t[i][j] = Math.max(t[i][j - 1], prices[j] + tmpMax);
                tmpMax = Math.max(tmpMax, t[i - 1][j - 1] - prices[j]);
            }
        }
        return t[k][prices.length - 1];
    }
}
