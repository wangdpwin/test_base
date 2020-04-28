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
}
