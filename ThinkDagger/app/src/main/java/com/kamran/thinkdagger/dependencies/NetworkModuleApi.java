package com.kamran.thinkdagger.dependencies;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Kamran ALi on 2/5/2017.
 */
@Module
public class NetworkModuleApi {

    private String baseUrl;

    public NetworkModuleApi(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Provides
    GsonConverterFactory providesGsonConverterFactory (){
        return GsonConverterFactory.create();
    }

    @Provides
    RxJava2CallAdapterFactory providesRxJava2CallAdapterFactory(){
        return RxJava2CallAdapterFactory.create();
    }

    @Provides
    Retrofit providesRetrofitService(GsonConverterFactory gsonConverterFactory,
                                     RxJava2CallAdapterFactory rxJava2CallAdapterFactory) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .build();
    }
}
