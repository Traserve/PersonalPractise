package huawei;

import org.mortbay.util.ajax.JSON;

import java.util.*;

/**
 * Description:
 *
 * @author Martin
 * @date 2022/6/14 00:19
 */

public class Maze {

    static List<int[]> path = new ArrayList<>();

    static List<int[]> result = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] maze = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maze[i][j] = in.nextInt();
            }
        }
        walk(maze, 0, 0);
        for (int[] p : result) {
            System.out.println("(" + p[0] + "," + p[1] + ")");
        }
    }

    public static void walk(int[][] maze, int a, int b) {
        if (a < 0 || a >= maze.length || b < 0 || b >= maze[0].length || maze[a][b] == 1) {
            return;
        }
        path.add(new int[]{a, b});
        maze[a][b] = 1;
        if (a == maze.length - 1 && b == maze[0].length - 1) {
            result = new ArrayList<>(path);
            return;
        }
        walk(maze, a - 1, b);
        walk(maze, a + 1, b);
        walk(maze, a, b - 1);
        walk(maze, a, b + 1);
        path.remove(path.size() - 1);
        maze[a][b] = 0;
    }

}
