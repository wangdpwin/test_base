package cn.wangdpwin.test.base.model;

import java.util.Date;
import lombok.Data;

/**
 * @Author: wangdongpeng
 * @Date: 2019/4/22 下午2:58
 * @Description
 * @Version 1.0
 */
@Data
public class User {

    private String name;

    private int age;

    private Date birthday;

    public User(String name, int age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
