package arithmetic.nowcoder;

import java.util.Scanner;

/**
 * @Author: Martin
 * @Date: 2020/1/29 21:35
 * @Description:
 */

public class MaxScore {

    public static void main(String[] args) {
        int M = 0, N = 0;
        int i;
        int A = 0, B = 0;
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            N = in.nextInt();
            M = in.nextInt();
//            System.out.println (N + " " + M);

            int[] score = new int[N];
            for (i = 0; in.hasNext() && i < N; i++) {
                score[i] = in.nextInt();
//                System.out.println (score[i] + " ");
            }

            String c = null;
            for (i = 0; in.hasNext() && i < M; i++) {
                c = in.next();
                A = in.nextInt();
                B = in.nextInt();
                process(c, A, B, score);
            }
        }
    }

    private static void process(String c, int a, int b, int[] score) {
        int begin, end;

        if ("Q".equals(c)) {
            end = Math.max(a, b);
            begin = Math.min(a, b) - 1;
            int max = score[begin];
            for (int i = begin; i < end; i++) {
                if (max < score[i]) {
                    max = score[i];
                }
            }
            System.out.println(max);
        } else if ("U".equals(c)) {
            score[a - 1] = b;
        }
    }
}
