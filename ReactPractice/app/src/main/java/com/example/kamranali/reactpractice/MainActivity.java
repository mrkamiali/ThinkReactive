package com.example.kamranali.reactpractice;


import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import io.reactivex.*;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import rx.*;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView1);

        Flowable.just(1,10)
                .subscribeOn(Schedulers.computation())
                .map(v -> v*v)
                .blockingSubscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        AppLog.logd("BlockingSubscribe() "+integer);
                    }
                });

        //Observable with Schedulers
//        Observable.just("1asd","2dsd","asd3")
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<String>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        e.printStackTrace();
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        AppLog.logd("From Observable.just onNext "+s);
//                    }
//                });
//        Looper bLooper = Looper.getMainLooper();
//        Observable.just(1,2,3)
//                .observeOn(AndroidSchedulers.f)
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                    e.printStackTrace();
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                                AppLog.logd("in Integer OnNext "+integer);
//                    }
//                });


        //With Flowable
//        Flowable.just("Flowable HEllo")
//                .subscribe(new Consumer<String>() {
//                    @Override
//                    public void accept(String s) throws Exception {
//                        ((TextView) findViewById(R.id.textView1)).setText(s);
//                    }
//                });

        //observable.from
//        Integer[] numbers = {0,1,2,3,4,5};
//
//        Observable<Integer> observable = Observable.from(numbers);
//        observable.subscribe(new Action1<Integer>() {
//            @Override
//            public void call(Integer integer) {
//                AppLog.logd("Action1() "+integer);
//            }
//        });

    }
}
