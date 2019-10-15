package arithmetic;

/**
 * @ClassName StringEdit
 * @Description 对于两个字符串A和B，我们需要进行插入、删除和修改操作将A串变为B串，定义ic，dc，rc分别为三种操作的代价，请设计一个高效算法，求出将A串变为B串所需要的最少代价。
 * 给定两个字符串A和B，及它们的长度和三种操作代价，请返回将A串变为B串所需要的最小代价。保证两串长度均小于等于300，且三种代价值均小于等于100。
 * 测试样例："abc",3,"adc",3,5,3,10 返回：8
 * @Author Cao.Zhuang
 * @Date 2019/10/14 18:10
 */

/**
 * 如何生成dp[][]:
 * 1.dp[0][0]表示空串编辑成空串，故dp[0][0]=0;
 * 2.求第一行dp[0][j]，空串编辑成str2[0....j-1]，则dp[0][j]=ic*j;
 * 3.求第一列dp[i][0]，str1[0......i-1]编辑成空串，则dp[i][0]=dc*i;
 * 4.求dp[i][j]，即str1[0....i-1]编辑成str2[0.....j-1]，四种可能的途径：
 * <1>str1[0....i-1]先编辑成str2[0.....j-2]，再由str2[0.....j-2]到str2[0.....j-1]，即dp[i][j-1]+ic;
 * <2>str1[0....i-1]先编辑成str1[0.....i-2]，再由str1[0.....i-2]到str2[0.....j-1]，即dc+dp[i-1][j];
 * <3>如果str1[i-1]==str2[j-1],则dp[i][j]=dp[i-1][j-1];如果str1[i-1]!=str2[j-1],则dp[i][j]=dp[i-1][j-1]+rc;
 * 选择上面四个中最小的值作为dp[i][j]，时间复杂度O(MN)，空间复杂度O(MN)。最小编辑距离为dp[M][N]。
 */
public class StringEdit {

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "adc";
        int ic = 5;
        int dc = 3;
        int rc = 10;
        System.err.println(findMinCost(str1, str1.length(), str2, str2.length(), ic, dc, rc));
        System.err.println(minCost02(str1, str2, ic, dc, rc));
    }

    private static int findMinCost(String A, int n, String B, int m, int ic, int dc, int rc) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i * dc;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j * ic;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i-1) == B.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + dc, Math.min(dp[i][j - 1] + ic, dp[i - 1][j - 1] + rc));
                }
            }
        }
        return dp[n][m];
    }

    /**
     * 压缩空间的动态规划(滚动法)(时间复杂度为O(M*N)，额外的空间复杂度为O(min(M,N))
     */
    public static int minCost02(String str1, String str2, int ic, int dc, int rc) {
        if (str1 == null || str2 == null) {
            return 0;
        }
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        char[] longs = ch1.length >= ch2.length ? ch1 : ch2;
        char[] shorts = ch1.length < ch2.length ? ch1 : ch2;
        //str2较长就交换ic和dc的值
        if (ch1.length < ch2.length) {
            int temp = ic;
            ic = dc;
            dc = temp;
        }
        int[] dp = new int[shorts.length + 1];
        for (int i = 1; i <= shorts.length; i++) {
            dp[i] = ic * i;
        }
        for (int i = 1; i <= longs.length; i++) {
            //pre表示左上角的值
            int pre = dp[0];
            dp[0] = dc * i;
            for (int j = 1; j <= shorts.length; j++) {
                int temp = dp[j];
                if (longs[i - 1] == shorts[j - 1]) {
                    dp[j] = pre;
                } else {
                    dp[j] = pre + rc;
                }
                dp[j] = Math.min(dp[j], dp[j - 1] + ic);
                dp[j] = Math.min(dp[j], temp + dc);
                pre = temp;
           }
        }
        return dp[shorts.length];
    }
}
