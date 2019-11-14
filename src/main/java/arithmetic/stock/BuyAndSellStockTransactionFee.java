package arithmetic.stock;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2019/11/13 18:28
 */

public class BuyAndSellStockTransactionFee {

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        System.err.println(maxProfit(prices, 2));
    }

    public static int maxProfit(int[] prices, int fee) {
        if(prices.length == 0 || prices.length == 1){
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[prices.length-1][0];
    }
}
