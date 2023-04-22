package huawei;

import org.mortbay.util.ajax.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * 给若干个区间，区间数少于1000，区间范围[-10000,10000]。当区间数少于2个时输出None。当各个区间有交集的时候取交集，再求交集的并集。
 * 具体看下面的列子
 * <p>
 * 1、如:[1,3]、[2,4]、[4,8]、[5,9] 4个区间，输入demo:1 3 2 4 4 8 5 9
 * [1,3]与[2,4]交集为[2,3],。。[1,3]与[4,8]、[5,9]没有交集。
 * [2,4]与[4,8]]交集为[4,4]。[2,4]与[5,9]没有交集。
 * [4,8]与[5,9]的交集为[5,8]
 * 所以最终的输出为[2,3]、[4,4]、[5,8]
 * 输出demo:2 3 4 4 5 8
 * <p>
 * 2、如:[1,2]、[3,4]2个区间，最后输出为None
 * <p>
 * 3、如:[1,6]、[2,5]、[5,7]3个区间，
 * [1,6]、[2,5]的交集为[2,5]，，，[1,6]、[5,7]的交集为[5,6]
 * [2,5]、[5,7]的交集为[5,5]
 * 最后的输出为：2 6
 *
 * @author Martin
 * @date 2022/6/3 19:00
 */

public class RangeCombine {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String strInput = scanner.nextLine();
//        range("1 3 2 4 4 8 5 9");
//        range("1 2 3 4");
//        range("1 6 2 5 5 7");
        range("1 6 2 5 5 7 8 9 8 10");

    }

    public static void range(String strInput) {
        String[] arr = strInput.split(" ");
//        System.out.println(JSON.toString(arr));
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i += 2) {
            list.add(new int[]{Integer.parseInt(arr[i]), Integer.parseInt(arr[i + 1])});
        }
        System.out.println("输入: " + JSON.toString(list));

        //计算交集
        list.sort((a, b) -> a[0] - b[0]);
        List<int[]> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int[] arr1 = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                int[] arr2 = list.get(j);
                // 两个区间左边界较大者作为交集左边界
                int left = Math.max(arr1[0], arr2[0]);
                // 两个区间右边界较大者作为交集右边界
                int right = Math.min(arr1[1], arr2[1]);
                if (left <= right) {
                    // 有交集
                    newList.add(new int[]{left, right});
                }
            }
        }
        System.out.println("交集: " + JSON.toString(newList));
        if (newList.isEmpty()) {
            System.out.println("None");
        }

        //计算并集
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < newList.size(); i++) {
            int left = newList.get(i)[0];
            int right = newList.get(i)[1];
            int j = i + 1;
            while (j < newList.size() && right >= newList.get(j)[0]) {
                right = Math.max(right, newList.get(j)[1]);
                j++;
            }
            result.add(new int[]{left, right});
            i = j - 1;
        }
        System.out.println("并集: " + JSON.toString(result));
    }

}
