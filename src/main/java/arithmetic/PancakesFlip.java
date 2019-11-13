package arithmetic;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Description: 假设盘子上有n块面积大小不一的烧饼，你如何用一把锅铲进行若干次翻转，让这些烧饼的大小有序（小的在上，大的在下）？
 *
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484611&idx=1&sn=8c3b6c986830f4a801e9e237d9e1554d&chksm=9bd7facbaca073ddc8158b78a29b96820993c446de56c013f274a6ee265cd98c47006ec0a23f&mpshare=1&scene=1&srcid=&sharer_sharetime=1572487395475&sharer_shareid=69f0e668dda636f518627eeb17172314#rd
 *
 * 思路：先把最大的饼翻到最上面，再把最大的饼翻到最下面就可以了。
 *
 * @author Cao.Zhuang
 * @date 2019/11/4 11:14
 */

public class PancakesFlip {

    static final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    public static void main(String[] args) {
        int[] panackes = new int[]{3, 2, 4, 1, 9, 6, 8, 7, 5};
//        pancakeSort(panackes);
        pancakeSortRecursion(panackes, panackes.length);
        System.err.println(gson.toJson(panackes));
    }

    public static void pancakeSort(int[] pancakes) {
        int maxpancake = 0;
        int maxPancakePos = 0;
        int currHeight = pancakes.length;
        while (currHeight > 1) {
            maxpancake = 0;
            for (int i = 0; i < currHeight; i++) {
                if (pancakes[i] > maxpancake) {
                    maxpancake = pancakes[i];
                    maxPancakePos = i;
                }
            }
            reverse(pancakes, 0, maxPancakePos);
            reverse(pancakes, 0, currHeight - 1);
            currHeight--;
        }
    }

    /**
     * 递归解法
     * @param pancakes
     * @param currHeight
     */
    public static void pancakeSortRecursion(int[] pancakes, int currHeight) {
        if (currHeight == 1) {
            return;
        }
        int maxpancake = 0;
        int maxPancakePos = 0;
        for (int i = 0; i < currHeight; i++) {
            if (pancakes[i] > maxpancake) {
                maxpancake = pancakes[i];
                maxPancakePos = i;
            }
        }
        reverse(pancakes, 0, maxPancakePos);
        reverse(pancakes, 0, currHeight - 1);
        pancakeSortRecursion(pancakes, currHeight - 1);
    }


    public static void reverse(int[] arr, int i, int j) {
        int temp = 0;
        while (i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
