package huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:给定一个数组candidates[]和一个结果target，求candidates数组中有那些数字相加可以得到targer，结果去除重复组合。
 * eg: candidates[10, 1, 2, 7, 6, 1, 5], target=8
 * result: [[1,2,5], [2,6], [1,7]]
 *
 * @author Martin
 * @date 2020/3/26 20:56
 */

public class CombinationSum {

    public static void main(String[] args) {
        List<List<Integer>> result = combinationSum(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        for (List<Integer> list : result) {
            System.out.println(Arrays.toString(list.toArray(new Integer[list.size()])));
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            List<Integer> list = new ArrayList<>();
            calcul(candidates, target, 0, list);
            if (list.get(list.size() - 1) != -1) {
                result.add(list);
            }
        }
        return result;
    }

    public static void calcul(int[] candidates, int target, int pos, List<Integer> list) {
        for (int i = pos; i < candidates.length; i++) {
            int n = target - candidates[i];
            if (n < 0) {
                list.add(-1);
                continue;
            }
            list.add(candidates[i]);
            if (n == 0) {
                break;
            }
            calcul(candidates, n, i + 1, list);
        }
    }
}
