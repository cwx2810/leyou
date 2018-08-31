package com.leyou.page.pojo;

/**
 * @author: LieutenantChen
 * @create: 2018-08-31 21:32
 **/
public class User {
    String name;
    int age;
    User friend;
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
    public User getFriend() {
        return friend;
    }
    public void setFriend(User friend) {
        this.friend = friend;
    }
}
