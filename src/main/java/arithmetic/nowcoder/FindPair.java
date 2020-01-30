package arithmetic.nowcoder;

import java.util.HashMap;

/**
 * Description:
 * <p>
 * 链接：https://www.nowcoder.com/questionTerminal/87d5a092a1d647479103e519a6c0a205?orderByHotValue=1&questionTypes=000100&mutiTagIds=639&page=1&onlyReference=false
 * 来源：牛客网
 * <p>
 * 请设计一个高效算法，找出数组中两数之和为指定值的所有整数对。
 * <p>
 * 给定一个int数组A和数组大小n以及需查找的和sum，请返回和为sum的整数对的个数。保证数组大小小于等于3000。
 * <p>
 * 测试样例：
 * [1,2,3,4,5],5,6
 * 返回：2
 *
 * @author Martin
 * @date 2020/1/30 18:48
 */

public class FindPair {

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int sum = 6;
        System.out.println(countPairs(A, A.length, sum));

        int[] B = {1, 1, 1};
        int sum2 = 2;
        System.out.println(countPairs(B, B.length, sum2));
    }

    public static int countPairs(int[] A, int n, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int temp : A) {
            count += map.getOrDefault(sum - temp, 0);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        return count;
    }
}
