package arithmetic;

import com.alibaba.fastjson.JSON;
import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/maximal-rectangle/
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 * Output: 6
 *
 * @author Cao.Zhuang
 * @date 2019/12/5 16:57
 */

public class MaximalRectangle {

    public static void main(String[] args) {
//        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'},
//                {'1', '0', '0', '1', '0'}};
//        System.err.println(maximalRectangle(matrix));

//        char[][] matrix2 = {{'1', '0', '1', '0', '0'}, {'1', '0', '0', '1', '1'}, {'1', '1', '1', '1', '1'},
//                {'1', '0', '0', '1', '0'}};
//        System.err.println(maximalRectangle(matrix2));

//        char[][] matrix3 = {};
//        System.err.println(maximalRectangle(matrix3));

//        char[][] matrix4 = {{'1','1'},{'1','1'}};
//        System.err.println(maximalRectangle(matrix4));

//        char[][] matrix5 = {{'1','1','1','1'},{'1','1','1','1'},{'1','1','1','1'},{'1','1','1','1'}};
//        System.err.println(maximalRectangle(matrix5));

        char[][] matrix6 = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        System.err.println(maximalRectangle(matrix6));

    }

    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length, maxArea = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];
        Arrays.fill(right, n - 1);
        for (int i = 0; i < m; i++) {
            int rB = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], rB);
                } else {
                    right[j] = n - 1;
                    rB = j - 1;
                }
            }
            System.err.println("row(" + i + ") right: " + JSON.toJSONString(right));
            int lB = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], lB);
                    height[j]++;
                    maxArea = Math.max(maxArea, height[j] * (right[j] - left[j] + 1));
                } else {
                    height[j] = 0;
                    left[j] = 0;
                    lB = j + 1;
                }
            }
            System.err.println("row(" + i + ") left : " + JSON.toJSONString(left));
            System.err.println("row(" + i + ") height : " + JSON.toJSONString(height));
            System.err.println();
        }
        return maxArea;
    }
}