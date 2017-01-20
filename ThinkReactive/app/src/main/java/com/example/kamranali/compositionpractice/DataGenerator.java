package com.example.kamranali.compositionpractice;

import java.util.ArrayList;

/**
 * Created by Kamran ALi on 1/19/2017.
 */

public class DataGenerator {
    public static ArrayList<Integer> integerList(int lenght){
        ArrayList<Integer> myList = new ArrayList<>();
        for (int i =0;i<lenght;i++){
            myList.add(i);
        }
        return myList;
    }
    public static ArrayList<User> userList(){
        ArrayList<User> userList = new ArrayList<>();

        userList.add(new User(User.ADMIN,"Kamran Admin","asds@y.com"));
        userList.add(new User(User.MODERATOR,"Qasim Moderator","asds@y.com"));
        userList.add(new User(User.GUEST,"Imran Guest","asds@y.com"));
        userList.add(new User(User.MODERATOR,"Bilal Moderator","asds@y.com"));
        userList.add(new User(User.ADMIN,"Samad Admin","asds@y.com"));
        userList.add(new User(User.GUEST,"Baba Guest","asds@y.com"));
        userList.add(new User(User.MODERATOR,"JOji Moderator","asds@y.com"));
        userList.add(new User(User.GUEST,"Naveed Guest","asds@y.com"));
        userList.add(new User(User.MODERATOR,"Faiz Moderator","asds@y.com"));
        userList.add(new User(User.MODERATOR,"Adnan Moderator","asds@y.com"));

        return userList;
    }
}
