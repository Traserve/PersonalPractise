package arithmetic.stock;

/**
 * Description: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 *
 * @author Cao.Zhuang
 * @date 2019/11/13 11:34
 */

public class BuyAndSellStock3 {

    public static void main(String[] args) {
//        int[] prices = {7,1,5,3,6,4};
        int[] prices = {1, 2};
        System.err.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int[][] profit = new int[prices.length][prices.length];
        for(int i = 0; i < prices.length; i++){
            for(int j=i; j< prices.length; j++){
                profit[i][j] = prices[j] - prices[i];
            }
        }
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++){
            for(int j=i; j< prices.length; j++){
                if(profit[i][j] > 0){
                    maxProfit = maxProfit < profit[i][j] ? profit[i][j] : maxProfit;
                    for(int m = j; m < prices.length; m++){
                        for(int n=m; n< prices.length; n++){
                            if(profit[m][n] > 0){
                                int k = profit[i][j] + profit[m][n];
                                if(maxProfit < k){
                                    maxProfit = k;
                                }
                            }
                        }
                    }
                }
            }
        }
        return maxProfit;
    }
}
