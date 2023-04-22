package sort;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Martin
 * @date 2021/4/29 22:33
 */

public class MaxGap {

    public static void main(String[] args) {
//        int[] arr = new int[]{1, 2, 3, 13, 4, 5, 6, 4, 5, 9};
        int[] arr = new int[]{1, 2, 3, 3, 4, 15, 6, 24, 5, 59};
        //桶id、桶最小值、桶最大值
        int[][] bucket = new int[arr.length + 1][3];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(arr[i], min);
            max = Math.max(arr[i], max);

            bucket[i][0] = 0;
            bucket[i][1] = Integer.MAX_VALUE;
            bucket[i][2] = Integer.MIN_VALUE;
        }

        bucket[arr.length][0] = 0;
        bucket[arr.length][1] = Integer.MAX_VALUE;
        bucket[arr.length][2] = Integer.MIN_VALUE;

        int slice = (max - min + 1) / arr.length + 1;

        System.out.println("length: " + arr.length + " min: " + min + " max: " + max + " slice: " + slice);

        for (int i = 0; i < arr.length; i++) {
            int index = arr[i] / slice;
            System.out.println("index: " + index + " arr[" + i + "]: " + arr[i]);
            bucket[index][0] = 1;
            bucket[index][1] = Math.min(arr[i], bucket[index][1]);
            bucket[index][2] = Math.max(arr[i], bucket[index][2]);
        }

        int maxGap = Integer.MIN_VALUE;
        for (int i = 0; i < bucket.length; i++) {
            System.err.println(Arrays.toString(bucket[i]));
            if (bucket[i][0] != 0) {
                maxGap = Math.max(maxGap, bucket[i][2] - bucket[i][1]);
                int j = i;
                while (j > 0 && bucket[j - 1][0] == 0) {
                    j--;
                }
                if (j > 0 && bucket[j - 1][0] == 1) {
                    maxGap = Math.max(maxGap, bucket[i][1] - bucket[j - 1][2]);
                }

            }
        }
        System.err.println("MAX_GAP: " + maxGap);
    }

}
