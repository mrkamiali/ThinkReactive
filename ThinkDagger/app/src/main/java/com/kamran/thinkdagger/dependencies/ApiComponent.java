package com.kamran.thinkdagger.dependencies;

import com.kamran.thinkdagger.ui.home.MainActivity;

import javax.inject.Inject;

import dagger.Component;

/**
 * Created by Kamran ALi on 2/5/2017.
 */
@Component(modules = ApiModeule.class,dependencies = NetworkComponent.class)
@CustomScope
public interface ApiComponent {

    void inject(MainActivity activity);
}
