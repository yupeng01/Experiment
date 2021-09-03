package com.nobug.experiment.jdk;

public class SingletonDemo {
    public static void main(String[] args) {
        User user = User.getInstance();
        System.out.println(user);
        User user2 = User.getInstance();
        System.out.println(user2);
        user2 = null;
        User user3 = User.getInstance();
        System.out.println(user3);
        user3.haha();
    }
}

class User {
    private static User user = new User();
    private User () {

    }

    public void haha () {
        System.out.println("haha");
    }

    public static User getInstance () {
        return user;
    }
}
