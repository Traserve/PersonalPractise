package com.test;

import com.alibaba.fastjson.JSON;

/**
 * @ClassName FastJsonTest
 * @Description
 * @Author Cao.Zhuang
 * @Date 2019/9/10 13:53
 */

public class FastJsonTest {

    public static void main(String[] args) {
        String a = " ";
        User user = JSON.parseObject(a, User.class);
        System.err.println(user.getAge());
    }

}
