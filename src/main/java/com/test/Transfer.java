package com.test;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2019/11/12 17:31
 */

/**
 * 1、基本类型作为参数传递时，是传递值的拷贝，无论你怎么改变这个拷贝，原值是不会改变的
 * 2、对象作为参数传递时，是把对象在内存中的地址拷贝了一份传给了参数。
 * 基本类型作为参数传递时，是传递值的拷贝，无论你怎么改变这个拷贝，原值是不会改变的
 * 在Java中对象作为参数传递时，是把对象在内存中的地址拷贝了一份传给了参数
 *
 *
 * String类是个特殊的类，对它的一些操作符是重载的，如：
 * String str = “Hello”; 等价于String str = new String(“Hello”);
 * String str = “Hello”; str = str + “ world!”;等价于str = new String((new StringBuffer(str)).append(“ world!”));
 */
public class Transfer {

    public static void main(String[] args) {
        int n = 3;
        System.out.println("Before change, n = " + n);
        changeData(n);
        System.out.println("After changeData(n), n = " + n + "\n");

        StringBuffer sb = new StringBuffer("Hello ");
        System.out.println("Before change, sb = " + sb);
        changeData(sb);
        System.out.println("After changeData(n), sb = " + sb + "\n");

        StringBuffer sb2 = new StringBuffer("Hello ");
        System.out.println("Before change, sb2 = " + sb2);
        changeData2(sb2);
        System.out.println("After changeData2(n), sb2 = " + sb2 + "\n");

        StringBuffer sb3 = new StringBuffer("Hello ");
        System.out.println("Before change, sb3 = " + sb3);
        changeData3(sb3);
        System.out.println("After changeData(n), sb3 = " + sb3);
    }

    public static void changeData(int n) {
        n = 10;
    }

    public static void changeData(StringBuffer strBuf) {
        strBuf.append("World!");
    }

    public static void changeData2(StringBuffer strBuf) {
        strBuf = new StringBuffer("Hi ");
        strBuf.append("World!");
    }

    public static void changeData3(StringBuffer strBuf) {
        StringBuffer sb2 = new StringBuffer("Hi ");
        strBuf = sb2;
        sb2.append("World!");

    }
}
