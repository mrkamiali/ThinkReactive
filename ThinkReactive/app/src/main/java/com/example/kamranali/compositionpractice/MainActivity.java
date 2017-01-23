package com.example.kamranali.compositionpractice;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.observable.ObservableAmb;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        userFiltration();
//        flatmapExample();
//        scanExample();
//        groupbyExample();
//        conditionalOperatorsExample();
//        connectableObserverExample();
        ObserverExample();
    }

    private void ObserverExample() {
        ArrayList<User> users = DataGenerator.userList();

        Observable<User> userObservable = Observable.fromIterable(DataGenerator.userList());
//        userObservable
//                .map(new Function<User, User>() {
//                    @Override
//                    public User apply(User user) throws Exception {
//                        user.setName(user.getName()+" Altered");
//                        return user;
//                    }
//                })
//                .subscribe(user -> AppLog.loge(user.toString()));


        userObservable.subscribe(new Observer<User>() {
            @Override
            public void onSubscribe(Disposable d) {
                AppLog.loge("OnSubscribe " + d.toString());
            }

            @Override
            public void onNext(User user) {
                AppLog.loge("onNext  " + user.toString());

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {

                AppLog.loge("OnComplete Called.");
            }
        });

        try {
            Thread.sleep(5000);

            AppLog.loge("------------------------------");
            users.add(new User(0, "=======", "------"));
            users.add(new User(1, "=======", "------"));
            users.add(new User(2, "=======", "------"));
            users.add(new User(3, "=======", "------"));
            users.add(new User(4, "=======", "------"));
            AppLog.loge("------------------------------");
            AppLog.loge(users.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void connectableObserverExample() {
        ArrayList<User> users = DataGenerator.userList();


        ConnectableObservable<User> observable = ConnectableObservable.fromIterable(users).publish();

        //here I have passed value by passed by value thats why its isnt changes in next Observer
        observable.autoConnect()
                .map(user -> new User(user.getLevel(), user.getName() + "\n --- Altered --- ", user.getEmail()))
                .subscribe(s -> AppLog.loge("\n1" + s.toString()));
//
//        observable.autoConnect()
//                .toSortedList((o1, o2) -> o1.getName().compareTo(o2.getName()))
//                .subscribe(us -> AppLog.loge("\n2" + us.toString()));
//
//        observable.autoConnect()
//                .subscribeOn(Schedulers.computation())
//                .observeOn(AndroidSchedulers.mainThread())
//                .filter(user -> {
//                    Thread.sleep(3000);
//                    return user.getLevel() != 0;
//                })
//                .subscribe(user -> AppLog.loge("\n3" + user.toString()));


        observable.subscribe(new Observer<User>() {
            @Override
            public void onSubscribe(Disposable d) {
                AppLog.loge("Changes Detected onSubscribe() \n" + d.toString());
            }

            @Override
            public void onNext(User user) {
                AppLog.loge("Changes Detected OnNext() \n" + user.toString());

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

        try {
            Thread.sleep(5000);

            AppLog.loge("-----------------------------------------------------");

            users.add(new User(1, "-----", "-----"));
            users.add(new User(2, "-----", "-----"));
            users.add(new User(3, "-----", "-----"));
            users.add(new User(4, "-----", "-----"));
            users.add(new User(5, "-----", "-----"));
            users.add(new User(0, "-----", "-----"));


            AppLog.loge("-----------------------------------------------------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            AppLog.loge("------------------Finally------------------");
        }


    }


    private void conditionalOperatorsExample() {
        //if we pass him empty or tell him to do this if you got empty
//        Observable.empty()
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .defaultIfEmpty("nothingSelected")
//                .subscribe(o -> AppLog.loge(o.toString()));

        //if we have list or its empty
//        Observable.from(DataGenerator.userList())
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .first()
//                .defaultIfEmpty(null)
//                .subscribe(user -> AppLog.loge(user.toString()));

        //iterate untill it get Level 1
//        Observable.from(DataGenerator.userList())
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .takeWhile(user -> {
//                    return user.getLevel()!=1;
//                }).subscribe(user -> AppLog.loge(user.toString()));

//        Observable.from(DataGenerator.userList())
////                .subscribeOn(Schedulers.newThread())
////                .observeOn(AndroidSchedulers.mainThread())
//                .skipWhile(user -> user.getLevel()<1)
//                .subscribe(user -> AppLog.loge(user.toString()));

        Observable.fromIterable(DataGenerator.userList())
                .skipWhile(user -> user.getName().length() < 3)
                .subscribe(user -> AppLog.loge("Rx2 " + user.getName().toString()));
//        rx.Observable.from(DataGenerator.userList())
//                .skipWhile(user -> user.getName().length()<3)
//                .subscribe(user -> AppLog.loge("Rx "+user.getName().toString()));
    }


    private void groupbyExample() {
        //Schedulers can effect the Result
        //this method will populate another three list of Admin, Guest and Moderator from Single list
//        ArrayList<User> adminList = new ArrayList<>();
//        ArrayList<User> GuestList = new ArrayList<>();
//        ArrayList<User> ModeratorList = new ArrayList<>();
//
//        rx.Observable.from(DataGenerator.userList())
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .groupBy(new Func1<User, String>() {
//                    @Override
//                    public String call(User user) {
//                        return user.getLevel() == 0 ? "ADMIN" : (user.getLevel() == 1 ? "Guest" : "Moderator");
//                    }
//                })
//                .subscribe(stringUserGroupedObservable -> {
//
//                    stringUserGroupedObservable.subscribe(user -> {
//                        if (stringUserGroupedObservable.getKey().equals("ADMIN")) {
//                            adminList.add(user);
//                            AppLog.loge("Admin Added " + user.toString());
//                        } else if (stringUserGroupedObservable.getKey().equals("Guest")) {
//                            GuestList.add(user);
//                            AppLog.loge("Guest Added " + user.toString());
//                        } else {
//                            ModeratorList.add(user);
//                            AppLog.loge("Moderator Added " + user.toString());
//                        }
//                    });
//                });
    }

    private void scanExample() {

        //will give the result of the scan Function
//        rx.Observable.from(DataGenerator.userList())
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//
//                .scan(new StringBuilder(), (stringBuilder, user) -> {
//                    //will return the append Object
////                    return stringBuilder.append(user);
//
//                    return stringBuilder.append(user.getName() + " ");
//
//                })
//                //will give the last scan result
////                .last()
//                .subscribe(stringBuilder -> AppLog.loge(stringBuilder.toString()));
    }

    private void flatmapExample() {
//        rx.Observable.from(DataGenerator.userList())
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
////                .toSortedList((user, user2) -> user.getName().compareTo(user2.getName()))
//                .flatMap(user ->
//                {
////                    ArrayList<User> myUser = new ArrayList<User>();
////                    for (User user1 : user) {
////                        user1.setEmail("KAMRAN");
////                        String s = user1.getName().toUpperCase();
////                        user1.setName(s);
////                        myUser.add(user1);
////                    }
////                    return Observable.from(myUser);
//                    String[] returnString = {user.getName().toUpperCase(), user.getName().toLowerCase()};
//                    return rx.Observable.from(returnString);
//
//                })
//                .subscribe(user -> AppLog.loge(user.toString()));
////                .subscribe(r -> AppLog.loge(r.toString()));
    }

    private void userFiltration() {
//        rx.Observable.from(DataGenerator.userList())
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .filter(user -> user.getLevel() != User.GUEST)
//                .toSortedList((user, user2) -> user.getName().compareTo(user2.getName()))
//                .subscribe(users -> {
//                    for (User user : users) {
//                        AppLog.loge(user.toString());
//                    }
//                });
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onStop() {
        super.onStop();
   }
}
