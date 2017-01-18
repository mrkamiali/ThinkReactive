package com.example.kamranali.ObservablePractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import rx.Observable;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //iterate on List and print it
        Observable.from(DataGenerator.IterableList(20))
                .subscribeOn(Schedulers.newThread())
                .subscribe(integer -> AppLog.logd("Form List " + integer));

        //Iterate on Array and print it
        Observable.from(DataGenerator.array())
                .subscribeOn(Schedulers.immediate())
                .subscribe(integer -> AppLog.logd("Form Array " + integer));

        //Scedule Work
        Observable<Integer> from = Observable.from(DataGenerator.IterableList(20));
        from.subscribeOn(Schedulers.computation())
                .filter(integer -> {
                    AppLog.logd("OnFilter " + Thread.currentThread().getName());
                    return integer % 2 == 0;
                }).observeOn(Schedulers.io())
                .map(integer -> "OnMap AfterInc inMap " + integer)
                .doOnNext(s -> AppLog.logd("doOnNext " + s + " " + Thread.currentThread().getName()))
                .subscribe(integer -> AppLog.logd("subscribe " + Thread.currentThread().getName() + " " + integer));


    }

}
