package test;

import com.alibaba.fastjson.JSON;
import list.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Test {

    public static void main(String[] args) {
        System.out.println(minDistance("edagadgaggag", "dda"));
    }

    public static int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    if (dp[i - 1][j - 1] > 0) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 2);
                    }
                }
            }
            print(dp[i]);
        }
        return dp[len1][len2];
    }

    public static void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

}
