package com.example.kamranali.compositionpractice;

/**
 * Created by Kamran ALi on 1/19/2017.
 */

public class User {
    public static int ADMIN = 0;
    public static int MODERATOR = 2;
    public static int GUEST = 1;

    private int level;
    private String name ;
    private String email;

    public User(int level, String name, String email) {
        this.level = level;
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "level=" + (level==0?"ADMIN":(level==1?"Guest":"Moderator"))+
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
