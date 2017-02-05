package com.kamran.thinkdagger.dependencies;

import dagger.Component;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Kamran ALi on 2/5/2017.
 */


@Component(modules = NetworkModuleApi.class)
public interface NetworkComponent {


    Retrofit retrofit();

}
