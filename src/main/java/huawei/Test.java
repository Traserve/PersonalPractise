package huawei;

/**
 * @author: Martin
 * @date: 2023/4/22 18:13
 * Description:
 */

public class Test {

    public static void main(String[] args) {
        canJump(new int[]{3, 2, 1, 0, 4});
    }

    public static boolean canJump(int[] nums) {
        int cover = 0;
        //i每次移动只能在cover的范围内移动，每移动一个元素，cover得到该元素数值（新的覆盖范围）的补充，让i继续移动下去。
        //而cover每次只取 max(该元素数值补充后的范围, cover本身范围)。
        //如果cover大于等于了终点下标，直接return true就可以了。
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(cover, i + nums[i]);
            if (cover >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

}
