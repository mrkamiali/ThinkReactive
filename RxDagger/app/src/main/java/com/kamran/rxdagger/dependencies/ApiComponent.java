package com.kamran.rxdagger.dependencies;

import com.kamran.rxdagger.ui.MainActivity;

import dagger.Component;

/**
 * Created by Kamran ALi on 2/3/2017.
 */

@CustomScope
@Component(modules = ApiModule.class, dependencies = NetworkComponent.class)
public interface ApiComponent {

    void inject(MainActivity mainActivity);
}
