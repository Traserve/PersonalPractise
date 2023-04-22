package huawei;

import java.util.*;

/**
 * Description:
 *
 * @author Martin
 * @date 2022/6/13 23:55
 */

public class WeightCombine {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int kind = in.nextInt();
        System.out.println("----------------------------");
        List<Weight> weights = new ArrayList<>();
        for (int i = 0; i < kind; i++) {
            Weight weight = new Weight();
            weight.w = in.nextInt();
            weights.add(weight);
        }
        System.out.println("----------------------------");
        for (int i = 0; i < kind; i++) {
            weights.get(i).n = in.nextInt();
        }
        System.out.println("----------------------------");
        Set<Integer> set = new HashSet<>();
        set.add(0);
        for (int i = 0; i < kind; i++) {
            List<Integer> list = new ArrayList<>(set);
            for (int j = 1; j <= weights.get(i).n; j++) {
                for (Integer k : list) {
                    set.add(k + weights.get(i).w * j);
                }
            }
        }
        System.out.println(set.size());
    }

    public static class Weight {
        int w;
        int n;
        public Weight() {
        }
        public Weight(int w, int n) {
            this.w = w;
            this.n = n;
        }
    }

}
