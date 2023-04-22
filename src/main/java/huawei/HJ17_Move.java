package huawei;

import java.util.Scanner;

/**
 * Description:
 *
 * @author Martin
 * @date 2022/6/3 19:23
 */

public class HJ17_Move {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] steps = input.split(";");
        int x = 0;
        int y = 0;
        for (String step : steps) {
            if (!checkValid(step)) {
                continue;
            }
            System.out.println("step: " + step);
            int num = Integer.parseInt(step.substring(1, step.length()));
            System.out.println("step: " + step + " num: " + num);
            if (step.charAt(0) == 'A') {
                x -= num;
            } else if (step.charAt(0) == 'D') {
                x += num;
            } else if (step.charAt(0) == 'W') {
                y += num;
            } else if (step.charAt(0) == 'S') {
                y -= num;
            }
        }
        System.out.println(x + " " + y);
    }

    public static boolean checkValid(String step) {
        if (step == null || step.length() < 2 || step.length() > 3) {
            System.out.println("step: " + step + " 111");
            return false;
        }
        if (step.charAt(0) != 'A' && step.charAt(0) != 'D' && step.charAt(0) != 'W' && step.charAt(0) != 'S') {
            System.out.println("step: " + step + " 222");
            return false;
        }
        String str = step.substring(1, step.length());
        if (str.compareTo("0") < 0 || str.compareTo("99") > 0) {
            System.out.println("step: " + step + " 333");
            return false;
        }
        return true;
    }
}
