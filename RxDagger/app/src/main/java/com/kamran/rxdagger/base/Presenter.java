package com.kamran.rxdagger.base;

/**
 * Created by Kamran ALi on 2/3/2017.
 */

public interface Presenter {

    void onCreate();

    void onResume();

    void onPause();

    void onDestroy();
}
