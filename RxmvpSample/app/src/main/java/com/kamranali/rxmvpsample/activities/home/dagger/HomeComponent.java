package com.kamranali.rxmvpsample.activities.home.dagger;

import com.kamranali.rxmvpsample.MainActivity;

import dagger.Component;

/**
 * Created by kamranali on 09/03/2017.
 */

@Component(modules = HomeModule.class)
public interface HomeComponent {

    void injec(MainActivity activity);
}
