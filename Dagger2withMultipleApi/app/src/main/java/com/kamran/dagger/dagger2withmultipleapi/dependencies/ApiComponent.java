package com.kamran.dagger.dagger2withmultipleapi.dependencies;

import com.kamran.dagger.dagger2withmultipleapi.ui.MainActivity;

import dagger.Component;

/**
 * Created by Kamran ALi on 2/6/2017.
 */
@ApiCustomScope
@Component(modules = {ApiComponentModule.class,PicassoModule.class})
public interface ApiComponent {

    void inject (MainActivity activity);

}

