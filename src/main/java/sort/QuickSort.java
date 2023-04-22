package sort;

import org.mortbay.util.ajax.JSON;

import java.lang.reflect.Proxy;
import java.util.Random;

/**
 * Description:
 *
 * @author Martin
 * @date 2022/1/1 18:54
 */

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 1, 4, 7, 2, 8};
        arr = new int[]{6, 1, 2, 7, 9, 11, 4, 5, 10, 8};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(JSON.toString(arr));
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int index = partition(arr, start, end);
        quickSort(arr, start, index - 1);
        quickSort(arr, index + 1, end);
    }

    public static int partition(int[] arr, int start, int end) {
        int index = new Random().nextInt(end - start) + start + 1;
        int pivot = arr[index];
        int low = start;
        int high = end;
        while (low < high) {
            while (low <= high && arr[high] > pivot) {
                high--;
            }
            while (low < high && arr[low] <= pivot) {
                low++;
            }
            swap(arr, low, high);
        }
        swap(arr, low, index);
        return low;
    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

}
