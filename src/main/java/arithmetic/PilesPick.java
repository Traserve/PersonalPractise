package arithmetic;

import org.apache.commons.lang3.tuple.Pair;

/**
 * @ClassName PilesPick
 * @Description 你和你的朋友面前有一排石头堆，用一个数组 piles 表示，piles[i] 表示第 i 堆石子有多少个。你们轮流拿石头，
 * 一次拿一堆，但是只能拿走最左边或者最右边的石头堆。所有石头被拿完后，谁拥有的石头多，谁获胜。
 *
 * 思路：使用dp数组，dp[i][j].left标识对于piles[i...j]这部分石头堆先手能获得的最高分数，
 * dp[i][j].right标识对于piles[i...j]这部分石头堆后手能获得的最高分数，写出dp数组即可发现规律
 * 状态转移方程：dp[i][j].fir = max{piles[i] + dp[i+1][j].left, piles[j]+dp[i][j-1].left}
 * @Author Cao.Zhuang
 * @Date 2019/10/12 18:02
 */

public class PilesPick {

    static int[] piles = {3, 9, 1, 2};

    public static void main(String[] args) {
        init();
    }

    private static void init() {
        Pair[][] dp = new Pair[piles.length][piles.length];
        for (int i = 0; i < piles.length; i++) {
            for (int j = i; j < piles.length; j++) {
                if (i == j) {
                    //初始化对角线
                    dp[i][j] = Pair.of(piles[i], 0);
                    System.err.println("[" + i + "][" + j + "] = (" + piles[i] + ", " + 0 + ")");
                } else {
                    dp[i][j] = Pair.of(0, 0);
                }
            }
        }
        System.err.println();
        pick(dp);
    }

    /**
     * 斜着遍历数组
     */
    private static Pair<Integer, Integer> pick(Pair[][] dp) {
        int limit = piles.length - 1;
        int base = 1;
        int first, second = 0;
        int leftIndex, rightIndex = 0;
        for (int i = 0; i < piles.length - 1; i++) {
            for (int j = 0; j < limit; j++) {
                leftIndex = j;
                rightIndex = j + base;
                //先手选左边
                int left = piles[leftIndex] + (int) dp[leftIndex + 1][rightIndex].getRight();
                //先手选右边
                int right = piles[rightIndex] + (int) dp[leftIndex][rightIndex - 1].getRight();
                if (left > right) {
                    first = left;
                    second = (int) dp[leftIndex + 1][rightIndex].getLeft();
                    dp[leftIndex][rightIndex] = Pair.of(first, second);
                } else {
                    first = right;
                    second = (int) dp[leftIndex][rightIndex - 1].getLeft();
                    dp[leftIndex][rightIndex] = Pair.of(first, second);
                }
                System.err.println("[" + leftIndex + "][" + rightIndex + "] = (" + first + ", " + second + ")");
            }
            System.err.println();
            base++;
            limit--;
        }
        return Pair.of(1, 2);
    }

}
