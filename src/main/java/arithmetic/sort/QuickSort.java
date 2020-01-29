package arithmetic.sort;

import com.alibaba.fastjson.JSON;

import java.util.Stack;

/**
 * @Author: Martin
 * @Date: 2020/1/29 15:12
 * @Description:
 */

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {4, 7, 6, 5, 3, 2, 8, 1};
        //递归实现
        quickSort(arr, 0, arr.length - 1);
        //非递归实现
//        quickSortIter(arr, 0, arr.length - 1);
        System.out.println(JSON.toJSONString(arr));
    }

    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        // 递归结束条件：startIndex大等于endIndex的时候
        if (startIndex >= endIndex) {
            return;
        }
        // 得到基准元素位置
        int pivotIndex = partition(arr, startIndex, endIndex);
        // 根据基准元素，分成两部分递归排序
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);
    }

    private static int partition(int[] arr, int startIndex, int endIndex) {
        // 取第一个位置的元素作为基准元素
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            //控制right指针比较并左移
            while (left < right && arr[right] > pivot) {
                right--;
            }
            //控制left指针比较并右移
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            //交换left和right指向的元素
            if (left < right) {
                swap(arr, left, right);
            }
        }
        //pivot和指针重合点交换
        swap(arr, startIndex, left);
        return left;
    }

    private static void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

    /**
     * 快排的非递归写法
     */
    public static void quickSortIter(int[] arr, int left, int right) {
        if (arr == null || left >= right) {
            return;
        }
        Stack<Integer> stack = new Stack<>();
        int i, j;
        // 注意顺序
        stack.push(left);
        stack.push(right);

        while (!stack.isEmpty()) {
            // 这里需要注意顺序呀
            // 先弹出右指针
            j = stack.pop();
            // 在弹出左指针
            i = stack.pop();

            if (i < j) {
                int station = partition(arr, i, j);
                if (station > i) {
                    stack.push(i);
                    stack.push(station - 1);
                }
                if (station < j) {
                    stack.push(station + 1);
                    stack.push(j);
                }
            }
        }
    }
}
