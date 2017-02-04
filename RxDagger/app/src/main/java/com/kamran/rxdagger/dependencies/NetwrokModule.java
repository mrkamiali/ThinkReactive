package com.kamran.rxdagger.dependencies;


import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.kamran.rxdagger.model.Constant;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Kamran ALi on 2/3/2017.
 */

@Module
public class NetwrokModule {

    private String mBase_URL;

    public NetwrokModule(String mBase_URL) {
        this.mBase_URL = mBase_URL;
    }

    @Provides
    @Singleton
    RxJava2CallAdapterFactory rxJava2CallAdapterFactory() {

        return RxJava2CallAdapterFactory.create();
    }

    @Provides
    @Singleton
    GsonConverterFactory gsonConverterFactory() {

        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    Retrofit retrofitBuilferService(RxJava2CallAdapterFactory rxJava2CallAdapterFactory,
                                    GsonConverterFactory gsonConverterFactory) {

        return new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .addConverterFactory(gsonConverterFactory)
                .build();
    }


}

