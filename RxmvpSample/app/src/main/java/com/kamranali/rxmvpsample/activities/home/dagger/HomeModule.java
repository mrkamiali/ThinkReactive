package com.kamranali.rxmvpsample.activities.home.dagger;

import android.app.Activity;

import com.kamranali.rxmvpsample.activities.home.mvp.MainActivityView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kamranali on 09/03/2017.
 */

@Module
public class HomeModule {

    private final Activity activity;

    public HomeModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    MainActivityView view() {
        return new MainActivityView(activity);
    }
}
