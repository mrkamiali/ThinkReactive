package com.kamran.thinkdagger.dependencies;

import com.kamran.thinkdagger.ui.home.MainActivity;

import dagger.Component;

/**
 * Created by Kamran ALi on 2/5/2017.
 */

@CustomScope
@Component(modules = ApiModule.class, dependencies = NetworkComponent.class)
public interface ApiComponent {

    void inject(MainActivity mainActivity);
}
