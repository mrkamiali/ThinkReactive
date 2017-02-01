package com.example.kamranali.rxandroid;

import java.util.ArrayList;


import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * Created by Kamran ALi on 1/24/2017.
 */

public class Model extends ArrayList<User> implements ObservableOnSubscribe<User>{
    ObservableEmitter<User> emitter;
    @Override
    public boolean add(User user) {
        emitter.onNext(user);
        return super.add(user);
    }

    @Override
    public void add(int index, User user) {
        emitter.onNext(user);
        super.add(index, user);

    }

    @Override
    public void subscribe(ObservableEmitter<User> emitter) throws Exception {
        this.emitter = emitter;
    }
}
