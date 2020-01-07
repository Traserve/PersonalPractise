package fastjson;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Description:
 *
 * @author Cao.Zhuang
 * @date 2020/1/7 15:05
 */

public class Student {

    private Integer id;
    private String userName;
    private int age;

    public Student(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
