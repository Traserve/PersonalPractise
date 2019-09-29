package com.test;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

/**
 * @ClassName ForEach
 * @Description
 * @Author Cao.Zhuang
 * @Date 2019/8/7 15:42
 */

@Slf4j
public class ForEach {

    List<User> listUser = new ArrayList<>();

    @Before
    public void initList() {
        listUser = this.getListUsers();
    }

    @Test
    public void test() {
        //一般forEach
        long startSimpleTime = System.currentTimeMillis();
        for (User user : listUser) {
            user.toString();
        }
        long endSimpleTime = System.currentTimeMillis();
        System.out.println("Simple:" + (endSimpleTime - startSimpleTime));

        //java8中新的forEach
        long startLambda = System.currentTimeMillis();
        listUser.forEach(User::toString);
        long endLambda = System.currentTimeMillis();
        System.out.println("Lambda:" + (endLambda - startLambda));

        //java8中新的stream+forEach
        long startStream = System.currentTimeMillis();
        listUser.stream().forEach(User::toString);
        long endStream = System.currentTimeMillis();
        System.out.println("Stream:" + (endStream - startStream));

        //java8中新的parallelStream+forEach
        long startParallelStream = System.currentTimeMillis();
        listUser.parallelStream().forEach(User::toString);
        long endParallelStream = System.currentTimeMillis();
        System.out.println("ParallelStream:" + (endParallelStream - startParallelStream));
    }


    private List<User> getListUsers() {
        List<User> listUser = new ArrayList<User>();
        for (int i = 0; i < 1000000; i++) {
            listUser.add(new User("user" + i, i));
        }
        return listUser;
    }
}
