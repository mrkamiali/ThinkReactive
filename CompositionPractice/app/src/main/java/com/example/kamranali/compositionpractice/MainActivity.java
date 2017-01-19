package com.example.kamranali.compositionpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import rx.Observable;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        userFiltration();
//        flatmapExample();
//        scanExample();
        groupbyExample();
    }

    private void groupbyExample() {
        //Schedulers can effect the Result
        //this method will populate another three list of Admin, Guest and Moderator from Single list
        ArrayList<User> adminList = new ArrayList<>();
        ArrayList<User> GuestList = new ArrayList<>();
        ArrayList<User> ModeratorList = new ArrayList<>();

        Observable.from(DataGenerator.userList())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .groupBy(new Func1<User, String>() {
                    @Override
                    public String call(User user) {
                        return user.getLevel()==0?"ADMIN":(user.getLevel()==1?"Guest":"Moderator");
                    }
                })
                .subscribe(stringUserGroupedObservable -> {

                    stringUserGroupedObservable.subscribe(user -> {
                        if (stringUserGroupedObservable.getKey().equals("ADMIN")){
                                     adminList.add(user);
                            AppLog.loge("Admin Added "+user.toString());
                        }else if (stringUserGroupedObservable.getKey().equals("Guest")){
                            GuestList.add(user);
                            AppLog.loge("Guest Added "+user.toString());
                        }else {
                            ModeratorList.add(user);
                            AppLog.loge("Moderator Added "+user.toString());
                        }
                    });
                });
    }

    private void scanExample() {

        //will give the result of the scan Function
        Observable.from(DataGenerator.userList())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())

                .scan(new StringBuilder(), (stringBuilder, user) -> {
                    //will return the append Object
//                    return stringBuilder.append(user);

                    return stringBuilder.append(user.getName() + " ");

                })
                //will give the last scan result
//                .last()
                .subscribe(stringBuilder -> AppLog.loge(stringBuilder.toString()));
    }

    private void flatmapExample() {
        Observable.from(DataGenerator.userList())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
//                .toSortedList((user, user2) -> user.getName().compareTo(user2.getName()))
                .flatMap(user ->
                {
//                    ArrayList<User> myUser = new ArrayList<User>();
//                    for (User user1 : user) {
//                        user1.setEmail("KAMRAN");
//                        String s = user1.getName().toUpperCase();
//                        user1.setName(s);
//                        myUser.add(user1);
//                    }
//                    return Observable.from(myUser);
                    String[] returnString = {user.getName().toUpperCase(), user.getName().toLowerCase()};
                    return Observable.from(returnString);

                })
                .subscribe(user -> AppLog.loge(user.toString()));
//                .subscribe(r -> AppLog.loge(r.toString()));
    }

    private void userFiltration() {
        Observable.from(DataGenerator.userList())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(user -> user.getLevel() != User.GUEST)
                .toSortedList((user, user2) -> user.getName().compareTo(user2.getName()))
                .subscribe(users -> {
                    for (User user : users) {
                        AppLog.loge(user.toString());
                    }
                });
    }
}
