package arithmetic;

import com.alibaba.fastjson.JSON;

/**
 * @Author: Martin
 * @Date: 2020/1/30 13:51
 * @Description: 旋转数组-O(1)空间复杂度 leetcode 189
 */

public class ArrayTransposition {

    public static void main(String[] args) {
        int[] matrix = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        transposingMatrix(matrix.length, 3, matrix);
        System.out.println(JSON.toJSONString(matrix));
    }

    public static void transposingMatrix(int n, int k, int[] matrix) {
        swap(0, n - 1 - k, matrix);
        swap(n - 1, n - 1, matrix);
        swap(0, n - 1, matrix);
    }

    public static void swap(int start, int end, int[] matrix) {
        while (start < end) {
            int tmp = matrix[start];
            matrix[start++] = matrix[end];
            matrix[end--] = tmp;
        }
    }
}
