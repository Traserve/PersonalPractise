package arithmetic.stock;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2019/11/13 11:34
 */

public class BuyAndSellStock {

    public static void main(String[] args) {
        int[] prices = {7, 1, 4, 3, 6};
        System.err.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }
        return dp[prices.length - 1][0];
    }

}
