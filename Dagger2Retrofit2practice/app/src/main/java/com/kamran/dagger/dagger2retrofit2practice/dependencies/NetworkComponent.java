package com.kamran.dagger.dagger2retrofit2practice.dependencies;
import javax.inject.Scope;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by Kamran ALi on 2/15/2017.
 */
@Component(modules =  NetworkModule.class)
public interface NetworkComponent {

    //Retrofit
    Retrofit retrofit();
}
