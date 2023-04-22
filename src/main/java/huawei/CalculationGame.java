package huawei;

/**
 * Description:
 *
 * @author Martin
 * @date 2022/6/14 23:49
 */

public class CalculationGame {

    static boolean[] visit = new boolean[4];
    static boolean[] used = new boolean[4];
    static int[] nums = new int[]{7, 9, 10, 9};

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int[] nums = new int[]{2, 2, 7, 6};
//        int[] nums = new int[]{7, 9, 10, 9};
//        boolean[] used = new boolean[4];
//        for (int i = 0; i < 4; i++){
//            nums[i] = in.nextInt();
//        }
        System.out.println(dfs(0, 0));
        System.out.println(dfs2(0, 0));
    }

    public static boolean dfs(int u, int tmp) {
        // 递归终止条件：已经使用了数组四个元素，同时结果为24，满足题意
        if (tmp == 24 && u == 4) {
            return true;
        }

        for (int i = 0; i < 4; i++) {
            if (!visit[i]) {
                visit[i] = true;
                // 加减乘除当前数字num[i]
                if (dfs(u + 1, tmp + nums[i]) ||
                        dfs(u + 1, tmp - nums[i]) ||
                        dfs(u + 1, tmp * nums[i]) ||
                        dfs(u + 1, tmp / nums[i])) {
                    return true;
                }
                // 相当于回溯
                visit[i] = false;
            }
        }
        return false;
    }

    static boolean dfs2(int u, float tmp) {
        // 递归终止条件：已经使用了数组四个元素，同时结果为24，满足题意
        if (tmp == 24 && u == 4) {
            return true;
        }

        for (int i = 0; i < 4; i++) {
            if (!visit[i]) {
                visit[i] = true;
                // 加减乘除当前数字num[i]
                if (dfs2(u + 1, tmp + nums[i]) ||
                        dfs2(u + 1, tmp - nums[i]) ||
                        dfs2(u + 1, tmp * nums[i]) ||
                        dfs2(u + 1, tmp / nums[i])) {
                    return true;
                }
                // 相当于回溯
                visit[i] = false;
            }
        }
        return false;
    }
}
