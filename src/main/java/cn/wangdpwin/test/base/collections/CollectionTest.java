package cn.wangdpwin.test.base.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: wangdongpeng
 * @Date: 2019/4/9 上午10:57
 * @Description
 * @Version 1.0
 */
public class CollectionTest {

    public static void main(String[] args) {
        List list = initList();
        // jdk8 升序排序，Comparator提供的静态方法
        list = initList();
        Collections.sort(list, Comparator.comparing(User::getAge));
        list.forEach(System.out::println);
        System.out.println();
        // jdk8 降序排序，Comparator提供的静态方法
        list = initList();
        Collections.sort(list, Comparator.comparing(User::getAge).reversed());
        list.forEach(System.out::println);
        System.out.println();
        // jdk8 组合排序，Comparator提供的静态方法，先按年纪排序，年纪相同的按名称排序
        list = initList();
        Collections.sort(list, Comparator.comparing(User::getAge).thenComparing(User::getName));
        list.forEach(System.out::println);
    }

    private static List initList() {
        List list = new ArrayList<>();
        list.add(new User("lisa", 23));
        list.add(new User("tom", 11));
        list.add(new User("john", 16));
        list.add(new User("jennis", 26));
        list.add(new User("tin", 26));
        list.add(new User("army", 26));
        list.add(new User("mack", 19));
        list.add(new User("jobs", 65));
        return list;
    }

}

class User{
    private String name;
    private int age;
    public User() {

    }
    public User(String name,int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}