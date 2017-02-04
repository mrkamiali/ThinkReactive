package com.kamran.rxdagger.dependencies;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by Kamran ALi on 2/3/2017.
 */
@Singleton
@Component(modules = NetwrokModule.class)
public interface NetworkComponent {

    Retrofit retrofit();
}
