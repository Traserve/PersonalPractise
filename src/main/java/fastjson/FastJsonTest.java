package fastjson;

import com.alibaba.fastjson.JSON;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2020/1/7 15:03
 */

public class FastJsonTest {

    public static void main(String[] args) {
        Student student = new Student(1);
        student.setAge(20);
        student.setUserName("张三");
        System.err.println(JSON.toJSONString(student));

        String json = "{\"age\":20,\"id\":1,\"userName\":\"张三\"}";
        //需要默认构造函数
        Student student1 = JSON.parseObject(json, Student.class);
        System.out.println(JSON.toJSONString(student1));
    }
}
