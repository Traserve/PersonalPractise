package string;

import org.junit.Test;

/**
 * @author: Martin
 * @date: 2023/4/28 0:50
 * Description: 字符串常量池相关知识
 */
public class StringTable {

    /**
     * 如何保证交量s指向的是字符串常量池中的数据呢?
     * ① string s = "abc";//宇面量定义的方式
     * ② 调用 intern()
     * String s = new string("abc").intern();
     * String s =new stringBuilder("abc").toString().intern();
     */
    @Test
    public void test2() {
        // 常量拼接放在字符串常量池中，原因是编译期优化，可以查看反编译后的代码
        String s1 = "a" + "b";
        String s2 = "ab";
        System.out.println(s1 == s2);//true
    }

    @Test
    public void test3() {
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        // 拼接包含变量，会变成 StringBuilder 拼接方式
        String s4 = s1 + s2;
        String s5 = s1 + "b";
        String s6 = s4.intern();
        System.out.println(s3 == s4);//false
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//true
    }

    @Test
    public void test4() {
        final String s1 = "a";
        final String s2 = "b";
        String s3 = "ab";
        // 属于常量拼接，不会使用 StringBuilder，走编译期优化
        String s4 = s1 + s2;
        System.out.println(s3 == s4);//true
    }

    @Test
    public void test5() {
        //new String() 会在堆中和字符串常量池中分别新建对象，一共新建两个对象
        String s = new String("1"); // 指向堆中的地址
        s.intern(); // 无效果
        String s2 = "1"; // 指向字符串常量池的地址
        System.out.println(s == s2);//false

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        //??????????????????? 为什么
        System.out.println(s3 == s4);//false

        // StringBuilder.toString() 不会将字符串放进常量池
        String s5 = new String("2") + new String("2");
        s5.intern(); //Java7 之后不会再将字符串拷贝到常量池，而只是在常量池中生成一个对原字符串的引用
        String s6 = "22"; // 返回指向堆中的地址
        System.out.println(s5 == s6); // true

        String s7 = new String("2") + new String("2");
        String s8 = "22";
        String s9 = s7.intern();
        System.out.println(s7 == s8); // false
        System.out.println(s8 == s9); // true
    }

    @Test
    public void test6() {
        String x = "ab";
        String s = new String("a") + new String("b");
        String s2 = s.intern(); //因为常量池已经有 ab,则不会放入
        System.out.println(s2 == x); // true
        System.out.println(s == x); // false
    }
}
