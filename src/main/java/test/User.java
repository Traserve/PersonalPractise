package test;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @ClassName User
 * @Description
 * @Author Cao.Zhuang
 * @Date 2019/8/7 15:42
 */

@Data
@Accessors(chain = true)
public class User {

    private Long id;
    private String name;
    private Integer age;

    public User() {

    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
