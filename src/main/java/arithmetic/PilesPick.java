package arithmetic;

import javafx.util.Pair;

/**
 * @ClassName PilesPick
 * @Description
 * @Author Cao.Zhuang
 * @Date 2019/10/12 18:02
 */

public class PilesPick {

    static int[] piles = {3, 9, 1, 3};

    public static void main(String[] args) {

    }

    private static void pick(){
        Pair<Integer, Integer>[][] dp = new Pair<Integer, Integer>[piles.length][piles.length];
        for (int i = 0; i < piles.length; i++) {
            dp[i][i] =
        }
        for (int i = 0; i < piles.length; i++) {
            for (int j = i; j < piles.length; j++) {

            }
        }
    }

}
