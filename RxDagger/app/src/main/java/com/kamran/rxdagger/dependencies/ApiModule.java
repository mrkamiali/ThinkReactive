package com.kamran.rxdagger.dependencies;

import com.kamran.rxdagger.service.FloweService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Kamran ALi on 2/3/2017.
 */

@Module
public class ApiModule {

    @Provides
    @CustomScope
    FloweService getFlowerService(Retrofit retrofit){

        return retrofit.create(FloweService.class);
    }


}
