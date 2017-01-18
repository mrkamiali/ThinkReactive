package com.example.kamranali.reactprogram1st;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Observer;

import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;


public class MainActivity extends AppCompatActivity  {

    TextView textView;
    String text="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView1);
        List<String> list = Arrays.asList("One", "Two", "Three", "Four", "Five");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            text +=iterator.next()+"\n";
        }
        textView.setText(text);

        Observable<String> observable = Observable.from(list);
        observable.subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                text += s + " \n";
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Log.d("MIAN ", throwable.getMessage());
            }
        }, new Action0() {
            @Override
            public void call() {
                textView.setText(text);
            }
        });
    }


}
