package arithmetic.matrix;

/**
 * @Author: Martin
 * @Date: 2020/1/30 15:46
 * @Description: 链接：https://www.nowcoder.com/questionTerminal/17ab1e527c504df09a600e1af09d9a60?orderByHotValue=1&questionTypes=000100&mutiTagIds=639&page=1&onlyReference=false
 * 来源：牛客网
 * <p>
 * 有一副由 NxN 矩阵表示的图像，这里每个像素用一个int表示，请编写一个算法，在不占用额外内存空间的情况下(即不使用缓存矩阵)，将图像顺时针旋转90度。
 * <p>
 * 给定一个NxN的矩阵，和矩阵的阶数N,请返回旋转后的NxN矩阵,保证N小于等于500，图像元素小于等于256。
 * <p>
 * 测试样例：
 * [[1,2,3],[4,5,6],[7,8,9]],3
 * 返回：[[7,4,1],[8,5,2],[9,6,3]]
 */

public class Transform {

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        transformImage(mat, 3);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print("\t" + mat[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] transformImage(int[][] mat, int n) {
        if (mat == null) {
            return null;
        }

        int temp = 0;
        //先将矩阵以次对角线互换
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                temp = mat[i][j];
                mat[i][j] = mat[n - j - 1][n - i - 1];
                mat[n - j - 1][n - i - 1] = temp;
            }
        }

        //将矩阵上下互换
        for (int i = 0; i < (n / 2); ++i) {
            for (int j = 0; j < n; ++j) {
                temp = mat[i][j];
                mat[i][j] = mat[n - i - 1][j];
                mat[n - i - 1][j] = temp;
            }

        }
        return mat;
    }
}
