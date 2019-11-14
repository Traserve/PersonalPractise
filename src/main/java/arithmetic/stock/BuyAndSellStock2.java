package arithmetic.stock;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2019/11/13 11:34
 */

public class BuyAndSellStock2 {

    public static void main(String[] args) {
        int[] prices = {7, 1, 4, 3, 6};
        System.err.println(maxProfit(prices));
        System.err.println(maxProfit2(prices));
        System.err.println(maxProfitDp2(prices));
    }

    public static int maxProfit(int[] prices) {
        return calculate(prices, 0);
    }

    public static int calculate(int[] prices, int start) {
        if (start == prices.length - 1) {
            return 0;
        }
        int maxProfit = 0;
        for (int i = start; i < prices.length; i++) {
            int max = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > 0) {
                    int profit = calculate(prices, j) + prices[j] - prices[i];
                    if (profit > max) {
                        max = profit;
                    }
                }
            }
            if (maxProfit < max) {
                maxProfit = max;
            }
        }
        return maxProfit;
    }

    public static int maxProfit2(int[] prices) {
        int i = 0;
        int maxProfit = 0;
        while(i < prices.length-1){
            if(i < prices.length-1 && prices[i] >= prices[i+1]){
                i++;
            }
            int vally = prices[i];
            if(i < prices.length-1 && prices[i] <= prices[i+1]){
                i++;
            }
            int peak = prices[i];
            maxProfit += peak - vally;
        }
        return maxProfit;
    }

    /**
     * i表示天数，k表示剩余操作次数，0表示当天未持有股票，1表示当天持有股票
     * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
     *  max( 选择 rest , 选择 sell )
     *
     * 解释：今天我没有持有股票，有两种可能：
     * 要么是我昨天就没有持有，然后今天选择 rest，所以我今天还是没有持有；
     * 要么是我昨天持有股票，但是今天我 sell 了，所以我今天没有持有股票了。
     *
     * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
     *  max( 选择 rest , 选择 buy )
     *
     * 解释：今天我持有着股票，有两种可能：
     * 要么我昨天就持有着股票，然后今天选择 rest，所以我今天还持有着股票；
     * 要么我昨天本没有持有，但今天我选择 buy，所以今天我就持有股票了。
     * @param prices
     * @return
     */
    public static int maxProfitDp(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int temp = dp[i][0];
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], temp - prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    /**
     * 不用数组，直接用两个变量来存储
     * @param prices
     * @return
     */
    public static int maxProfitDp2(int[] prices) {
        int dp_i_0 = 0;
        int dp_i_1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
        }
        return dp_i_0;
    }
}
