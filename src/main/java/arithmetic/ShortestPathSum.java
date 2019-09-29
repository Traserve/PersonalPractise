package arithmetic;

import com.google.common.collect.Lists;
import java.util.List;

/**
 * @ClassName ShortestPathSum
 * @Description 三角形数组最短和路径
 * @Author Cao.Zhuang
 * @Date 2019/8/12 17:48
 */

public class ShortestPathSum {

    public static void main(String[] args) {
        List<Integer> l1 = Lists.newArrayList(2);
        List<Integer> l2 = Lists.newArrayList(3, 4);
        List<Integer> l3 = Lists.newArrayList(6, 5, 7);
        List<Integer> l4 = Lists.newArrayList(4, 9, 8, 3);
        List<List<Integer>> list = Lists.newArrayList(l1, l2, l3, l4);
        System.err.println("minimumTotal: " + minimumTotal2(list));
    }


    private static int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[2][triangle.get(triangle.size() - 1).size()];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < triangle.get(triangle.size() - 1).size(); j++) {
                dp[i][j] = 0;
            }
        }
        int flag = 0;
        for (int i = 0; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int index = flag == 0 ? 1 : 0;
                if (j == 0) {
                    dp[flag][j] = dp[index][j] + triangle.get(i).get(j);
                } else if (j == triangle.get(i).size() - 1) {
                    dp[flag][j] = dp[index][j - 1] + triangle.get(i).get(j);
                } else {
                    dp[flag][j] = Math
                            .min(dp[index][j - 1] + triangle.get(i).get(j), dp[index][j] + triangle.get(i).get(j));
                }
            }
            for (int k = 0; k < triangle.get(triangle.size() - 1).size(); k++) {
                System.err.print(dp[flag][k] + " ");
            }
            System.err.print("\n");
            flag = flag == 0 ? 1 : 0;
        }
        return 0;
    }

    private static int minimumTotal2(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = triangle.get(i).size() - 1; j >= 0; j--) {
                if (j == 0) {
                    dp[j] = dp[j] + triangle.get(i).get(j);
                } else {
                    dp[j] = Math.min(dp[j - 1], dp[j]) + triangle.get(i).get(j);
                }
            }
            for (int k = 0; k < triangle.size(); k++) {
                System.err.print(dp[k] + " ");
            }
            System.err.print("\n");
        }
        return 0;
    }

//    private static int minimumTotal2(List<List<Integer>> triangle) {
//        if (triangle == null) {
//            return 0;
//        }
//        if (triangle.size() == 1) {
//            return triangle.get(0).get(0);
//        }
//        int minTotal = Integer.MAX_VALUE;
//        int[] aux = new int[triangle.size()];//声明一个辅助数组用于存储f[i][j]的数据
//        for (int i = 0; i < aux.length; i++) {
//            aux[i] = Integer.MAX_VALUE;
//        }
//        aux[0] = triangle.get(0).get(0);
//        for (int i = 1; i < triangle.size(); i++) {
//            for (int j = triangle.get(i).size() - 1; j >= 0; j--) {
//                if (j != 0) {
//                    System.err.println("aux[" + j + "]: " + aux[j] + "," + (aux[j] == Integer.MAX_VALUE ? "" :"         ")+" aux[" + (j - 1) + "]: " + aux[j - 1] + ", triangle["+i+"]["+j+"]: " + triangle.get(i).get(j));
//                    aux[j] = Math.min(aux[j], aux[j - 1]) + triangle.get(i).get(j);
//                } else {
//                    aux[j] = aux[j] + triangle.get(i).get(j);
//                }
//            }
//        }
//        for (int i = 0; i < aux.length; i++) {
//            minTotal = Math.min(aux[i], minTotal);
//        }
//        return minTotal;
//    }
}
