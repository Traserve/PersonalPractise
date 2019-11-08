package arithmetic;

/**
 * Description: 假设盘子上有n块面积大小不一的烧饼，你如何用一把锅铲进行若干次翻转，让这些烧饼的大小有序（小的在上，大的在下）？
 *
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484611&idx=1&sn=8c3b6c986830f4a801e9e237d9e1554d&chksm=9bd7facbaca073ddc8158b78a29b96820993c446de56c013f274a6ee265cd98c47006ec0a23f&mpshare=1&scene=1&srcid=&sharer_sharetime=1572487395475&sharer_shareid=69f0e668dda636f518627eeb17172314#rd
 *
 * @author Cao.Zhuang
 * @date 2019/11/4 11:14
 */

public class PancakesFlip {

    public static void main(String[] args) {
        int[] panackes = new int[]{3, 2, 4, 1};
        pancakeSort(panackes);
    }

    static void pancakeSort(int[] cakes) {

    }


    static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
