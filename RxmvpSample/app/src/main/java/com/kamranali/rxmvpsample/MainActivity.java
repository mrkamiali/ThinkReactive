package com.kamranali.rxmvpsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kamranali.rxmvpsample.activities.home.mvp.MainActivityView;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    MainActivityView view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(view);
    }
}
