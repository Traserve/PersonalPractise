package test;

import org.mortbay.util.ajax.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author Martin
 * @date 2022/2/15 22:51
 */

public class Test2 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(combinationSum4(nums, 4));

        int[] coins = new int[]{1, 2, 5};
        int amount = 5;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) { // 遍历物品
            for (int j = coins[i]; j <= amount; j++) { // 遍历背包容量
                dp[j] += dp[j - coins[i]];
            }
            System.out.println(JSON.toString(dp));
        }
        System.out.println("----------------------------------------");

        dp = new int[amount + 1];
        dp[0] = 1;
        for (int j = 0; j <= amount; j++) { // 遍历背包容量
            for (int i = 0; i < coins.length; i++) { // 遍历物品
                if (coins[i] <= j) {
                    dp[j] += dp[j - coins[i]];
                }
            }
            System.out.println(JSON.toString(dp));
        }
    }

    static List<List<Integer>> list = new ArrayList<>();

    public static int combinationSum4(int[] nums, int target) {
//        Arrays.sort(nums);
//        process(nums, target, 0, new ArrayList<>());
//        System.out.println(JSON.toString(list));
        return 0;
    }

//    public static void process(int[] nums, int target, int index, List<Integer> combination) {
//        if (target == 0) {
//            list.add(new ArrayList<>(combination));
//            return;
//        }
//        if (index == nums.length) {
//            return;
//        }
//        for (int i = 1; i * nums[index] <= target; i++) {
//            combination.add(nums[index]);
//            process(nums, target - i * nums[index], index + 1, combination);
//            target += i * nums[index];
//            combination.remove(combination.size() - 1);
//        }
//    }

}
