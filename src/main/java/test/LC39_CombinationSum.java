package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 * @author Martin
 * @date 2022/6/12 00:17
 */

public class LC39_CombinationSum {

    static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        combinationSum(new int[]{2, 5, 3}, 4);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        process(candidates, target, 0, new ArrayList<>());
        return result;
    }

    public static void process(int[] candidates, int target, int index, List<Integer> list) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length && candidates[i] <= target; i++) {
            list.add(candidates[i]);
            process(candidates, target - candidates[i], i, list);
            list.remove(list.size() - 1);
        }
    }

}
