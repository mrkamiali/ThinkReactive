package com.kamran.dagger.dagger2withmultipleapi.dependencies;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.DateTypeAdapter;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.kamran.dagger.dagger2withmultipleapi.service.GetUserService;
import com.kamran.dagger.dagger2withmultipleapi.utils.Constants;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Kamran ALi on 2/6/2017.
 */

@Module(includes = NetworkModule.class)
public class ApiComponentModule {

    @Provides
    @ApiCustomScope
    GetUserService getUserService(Retrofit retrofit) {
        return retrofit.create(GetUserService.class);
    }

//    //bad ma Gson ko hata k deakna hy is it working or not
//    @Provides
//    @ApiCustomScope
//    Gson gson(){
//        GsonBuilder gsonBuilder = new GsonBuilder();
//        //DateTime.class, new DateTimeConverter()
//        gsonBuilder.registerTypeAdapter(gsonBuilder.getClass(),new DateTypeAdapter());
//        return gsonBuilder.create();
//    }

    @Provides
    @ApiCustomScope
    Retrofit retrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

}

