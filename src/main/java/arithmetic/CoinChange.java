package arithmetic;

import com.google.common.primitives.Ints;
import java.util.List;

/**
 * @ClassName CoinChange
 * @Description 题目：给你 k 种面值的硬币，面值分别为 c1, c2 ... ck，再给一个总金额 n，问你最少需要几枚硬币凑出这个金额，如果不可能凑出，则回答 -1 。 比如说，k = 3，面值分别为 1，2，5，总金额
 * n = 11，那么最少需要 3 枚硬币，即 11 = 5 + 5 + 1 。
 * @Author Cao.Zhuang
 * @Date 2019/9/29 17:48
 */

public class CoinChange {

    public static void main(String[] args) {
        int k = 3;
        int[] coins = new int[]{1, 2, 5};
        int n = 11;
        System.err.println(coinSum(k, n, coins));
        System.err.println(coinChangeDp(Ints.asList(coins), 11));
    }

    public static int coinSum(int k, int n, int[] coins) {
        int m = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int sum = 0;
            if (n - coins[i] > 0) {
                sum = coinSum(k, n - coins[i], coins) + 1;
            } else if (n - coins[i] == 0) {
                sum = sum + 1;
            } else {
                continue;
            }
            if (sum >= 0) {
                m = Math.min(m, sum);
            }
        }
        return m;
    }

    /**
     * 递归
     */
    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 金额不可达
            if (amount - coin < 0) {
                continue;
            }
            int subProb = coinChange(coins, amount - coin);
            // 子问题无解
            if (subProb == -1) {
                continue;
            }
            ans = Math.min(ans, subProb + 1);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    /**
     * dp数组解法
     */
    public static int coinChangeDp(List<Integer> coins, int amount) {
        int[] dp = new int[amount];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 1;
        for (int i = 0; i < dp.length; i++) {
            if (coins.contains(i + 1)) {
                dp[i] = 1;
            } else {
                int m = Integer.MAX_VALUE;
                for (int j = 0; j < coins.size(); j++) {
                    if (i + 1 - coins.get(j) >= 0) {
                        dp[i] = Math.min(m, dp[i - coins.get(j)] + 1);
                    }
                }
            }
        }
        return dp[amount - 1];
    }
}
