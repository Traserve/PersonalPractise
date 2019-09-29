package com.test;

/**
 * @ClassName SwitchTest
 * @Description
 * @Author Cao.Zhuang
 * @Date 2019/8/6 15:10
 */

public class SwitchTest {

    public static void main(String[] args) {
        int a = 3;
        switch (a) {
            case 1:
            case 2:
                System.err.println("2");
                break;
            case 3:
            case 4:
                System.err.println("4");
                break;
            default:
                System.err.println("default");
        }
    }
}
