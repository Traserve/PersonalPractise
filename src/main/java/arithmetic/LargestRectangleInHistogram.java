package arithmetic;

/**
 * Description: https://leetcode.com/problems/largest-rectangle-in-histogram/
 *
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 *
 * Example:
 *
 * Input: [2,1,5,6,2,3]
 * Output: 10
 *
 * @author Cao.Zhuang
 * @date 2019/12/6 15:30
 */

public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        int[] heights = {2, 0, 5, 6, 2, 3};
        System.err.println(largestRectangleArea(heights));

        int[] heights2 = {0, 0, 0, 0, 0, 0, 0, 0, 2147483647};
        System.err.println(largestRectangleArea(heights2));
    }

    /**
     * 暴力查询
     * 优化思路：1.首先没必要每一个柱子都检测，可以先获取每一个柱子的高度并用set去重，然后遍历柱子获取每个高度的最大宽度即可。
     * 2.没必要每个高度都做一个全面的扫描，相邻较高柱子到达的边界一定不会超过较低柱子的
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            if(heights[i] == 0){
                continue;
            }
            //查询高度为当前柱子heights[i]的最大矩形面积
            //向左寻找矩形边界
            int left = i - 1;
            while (left >= 0 && heights[left] >= heights[i]) {
                left--;
            }
            //向右寻找矩形边界
            int right = i + 1;
            while (right < heights.length && heights[right] >= heights[i]) {
                right++;
            }
            maxArea = Math.max(maxArea, (right - left - 1) * heights[i]);
        }
        return maxArea;
    }

    public static int largestRectangleArea2(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int maxArea = 0;
        int[] leftLessMin = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            for (int j = i-1; j < 0; j--) {
                if (heights[j] < heights[i]){

                }
            }
        }
        return maxArea;
    }
}
